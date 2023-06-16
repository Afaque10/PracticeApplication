package com.example.practiceapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Introductionpage extends AppCompatActivity {

    TextView introductionpagebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductionpage);





        introductionpagebutton=(TextView) findViewById(R.id.login_button);
        introductionpagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),registerphonenumber.class);
                startActivity(b);
            }
        });
    }
}