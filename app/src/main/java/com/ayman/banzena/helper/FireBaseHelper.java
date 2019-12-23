package com.ayman.banzena.helper;

import com.ayman.banzena.model.pojo.BanzenaDataPojo;
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

    public void createBanzenaOnFirebase(BanzenaPojo Banzena) {
        DatabaseReference myRef = database.getReference("users");
//        myRef.child(Integer.toString(Banzena.getId())).setValue(Banzena);
        myRef.child(Banzena.getBanzenaName()).setValue(Banzena);

    }

    public void retrieveUserBanzenasFromFirebase(final FireBaseCallBack fireBaseCallBack) {
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



    public void createBanzenaDataOnFirebase(BanzenaDataPojo Banzena) {
        DatabaseReference myRef = database.getReference("banzenadata");
//        myRef.child(Integer.toString(Banzena.getId())).setValue(Banzena);
        myRef.child(Banzena.getBanzenaName()).setValue(Banzena);

    }

    public void retrieveUserBanzenasDataFromFirebase(final FireBaseCallBack fireBaseCallBack) {
        final ArrayList<BanzenaDataPojo> Banzenas;
        Banzenas = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("banzenadata");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            //userSnapshot.child()
                            BanzenaDataPojo Banzena = userSnapshot.getValue(BanzenaDataPojo.class);
                            Banzenas.add(Banzena);
                        }
//                        fireBaseCallBack.getBanzenas(Banzenas);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }
}