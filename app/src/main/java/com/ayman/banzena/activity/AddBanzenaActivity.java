package com.ayman.banzena.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ayman.banzena.R;
import com.ayman.banzena.databinding.ActivityAddBanzenaBinding;
import com.ayman.banzena.helper.FireBaseHelper;
import com.ayman.banzena.model.pojo.BanzenaPojo;

public class AddBanzenaActivity extends AppCompatActivity {

    private FireBaseHelper fireBaseHelper;
    BanzenaPojo Banzena;
    private ActivityAddBanzenaBinding binding;

    String banzenaName , banzenaOhda;
    Double  banzenaOils ,  banzenaTanks   ,  lat ,  lng ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_banzena);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_banzena);

        binding.setLifecycleOwner(this);
        initView();
        fireBaseHelper=new FireBaseHelper();

    }
    void initView(){


        binding.mapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AddBanzenaActivity.this , MapsActivity2.class);
                startActivityForResult(intent, 111);
            }
        });


        binding.addBanzena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banzenaName = binding.banzenaName.getText().toString();
                banzenaOhda = binding.banzenaOhda.getText().toString();
                banzenaOils = Double.valueOf(binding.banzenaOils.getText().toString());
                banzenaTanks = Double.valueOf(binding.banzenaTanks.getText().toString());
                Banzena=new BanzenaPojo(banzenaName, banzenaOhda , banzenaOils , banzenaTanks ,  lat , lng);
                fireBaseHelper.createBanzenaOnFirebase(Banzena);

                Intent i = new Intent(AddBanzenaActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && data != null) {
            if (resultCode == Activity.RESULT_OK) {
                 lat = data.getDoubleExtra("latitude" , 0);
                 lng = data.getDoubleExtra("longitude" , 0);
            } else {
                Toast.makeText(AddBanzenaActivity.this, "open gps and try again ", Toast.LENGTH_LONG).show();
            }
        }
    }
}