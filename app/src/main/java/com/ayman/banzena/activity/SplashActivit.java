package com.ayman.banzena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ayman.banzena.R;

public class SplashActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
                new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                openActivity();
            }
        }, 2000);
    }

    public void openActivity() {

            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            finish();

    }
}
