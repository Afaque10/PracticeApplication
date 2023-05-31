package com.example.practiceapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    final Handler handler = new Handler(Looper.getMainLooper());
    ProgressBar Prog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Prog=(ProgressBar) findViewById(R.id.load);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previousStarted = prefs.getBoolean(getString(R.string.pref_previously_started),false);





        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!previousStarted){
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
                    edit.commit();
                    Intent b = new Intent(SplashScreen.this,Introductionpage.class);
                    b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(b);
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashScreen.this,registerphonenumber.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                    Prog.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Prog.setVisibility(View.GONE);
                            startActivity(intent);
                            finish();
                        }
                    },1500);





                }


            }
        },1500);


    }
}