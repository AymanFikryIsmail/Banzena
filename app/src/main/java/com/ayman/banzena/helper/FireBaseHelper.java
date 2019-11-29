package com.ayman.banzena.helper;

import com.ayman.banzena.model.pojo.BanzenaPojo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class FireBaseHelper implements Serializable {

    FirebaseDatabase database;
    public FireBaseHelper() {
        database = FirebaseDatabase.getInstance();
        //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
//    public void addUserToFirebase(UserDTO user) {
//        DatabaseReference myRef = database.getReference("users");
//        myRef.child(user.getId()).setValue(user);
//    }
//
//    public void createTripOnFirebase(TripDTO trip) {
//        DatabaseReference myRef = database.getReference(trip.getUserId());
//        myRef.child(Integer.toString(trip.getId())).setValue(trip);
//    }

    public void createBanzenaOnFirebase(BanzenaPojo Banzena) {
        DatabaseReference myRef = database.getReference("users");
//        myRef.child(Integer.toString(Banzena.getId())).setValue(Banzena);
        myRef.child(Banzena.getBanzenaName()).setValue(Banzena);

    }
    public void updateBanzenaOnFirebase(BanzenaPojo Banzena) {
        DatabaseReference myRef = database.getReference(Banzena.getBanzenaName() );
        myRef.child(Integer.toString(Banzena.getId())).setValue(Banzena);
    }
    public void removeBanzenaFromFirebase(BanzenaPojo Banzena) {
        DatabaseReference myRef = database.getReference(Banzena.getBanzenaName());
        myRef.child(Integer.toString(Banzena.getId())).setValue(null);
    }


    public void retrieveUserBanzenasFromFirebase( final FireBaseCallBack fireBaseCallBack) {
        final ArrayList<BanzenaPojo> Banzenas;
        Banzenas = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            //userSnapshot.child()
                            BanzenaPojo Banzena = userSnapshot.getValue(BanzenaPojo.class);
                            Banzenas.add(Banzena);
                        }
                        fireBaseCallBack.getBanzenas(Banzenas);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }
}