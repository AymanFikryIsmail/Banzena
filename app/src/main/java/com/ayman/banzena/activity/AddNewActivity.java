package com.ayman.banzena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ayman.banzena.R;

public class AddNewActivity extends AppCompatActivity {

    Button addnewByanBtn , stationInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        addnewByanBtn=findViewById(R.id.addnewByan);
        stationInfo=findViewById(R.id.stationInfo);

        addnewByanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddNewActivity.this, AddDataActivity.class);
                startActivity(i);
            }
        });
        stationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddNewActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
