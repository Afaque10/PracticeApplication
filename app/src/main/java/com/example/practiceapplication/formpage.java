package com.example.practiceapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class formpage extends AppCompatActivity {
    final Handler handler =new Handler(Looper.getMainLooper());

    EditText nameedittext,addressedittext,dateofbirthedittext,genderdeittext,phonenumberedittext;
    Button submitbutton;
    ProgressBar Prgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpage);

        Prgs=(ProgressBar) findViewById(R.id.loading);

        nameedittext=(EditText) findViewById(R.id.name);
        addressedittext=(EditText) findViewById(R.id.address);
        dateofbirthedittext=(EditText) findViewById(R.id.Dob);
        genderdeittext=(EditText) findViewById(R.id.Gender);
        phonenumberedittext=(EditText) findViewById(R.id.number);
        submitbutton=(Button) findViewById(R.id.nextbutton);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namedata = nameedittext.getText().toString().trim();
                String addressdata = addressedittext.getText().toString().trim();
                String dobdata = dateofbirthedittext.getText().toString().trim();
                String genderdata = genderdeittext.getText().toString().trim();
                String numberdata = phonenumberedittext.getText().toString().trim();

                Intent v = new Intent(getApplicationContext(),detailspage.class);
                v.putExtra("name",namedata);
                v.putExtra("address",addressdata);
                v.putExtra("Dob",dobdata);
                v.putExtra("Gender",genderdata);
                v.putExtra("number",numberdata);
                Prgs.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Prgs.setVisibility(View.VISIBLE);
                        startActivity(v);
                    }
                },1500);



            }
        });


    }
}