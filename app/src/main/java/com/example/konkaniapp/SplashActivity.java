package com.example.konkaniapp;

import static com.example.konkaniapp.utility.NetworkUtils.isConnected;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.konkaniapp.fragments.NoInternetFragment;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isConnected(SplashActivity.this)) {
                    Intent intent = new Intent(SplashActivity.this, LogInActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main, new NoInternetFragment())
                            .commit();
                }
            }
        }, SPLASH_DURATION);
    }
}


