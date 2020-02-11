package com.egov.win10.simpelv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    private int waktu_loading=4000;

    public static final String PREFS_NAME = "MyPrefsFile";
    String id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        id_user = settings.getString("username", "default");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity

                if(id_user.equals("default")) {


                    Intent home = new Intent(SplashScreen.this, Login.class);
                    startActivity(home);
                    finish();

                }else{
                    Intent home = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(home);
                    finish();
                }

            }
        },waktu_loading);
    }
}
