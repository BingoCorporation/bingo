package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.bingo.bingo.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int splash_time=6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Launch Screenplash
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },splash_time);

    }
}
