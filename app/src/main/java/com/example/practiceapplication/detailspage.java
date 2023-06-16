package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailspage extends AppCompatActivity {

    TextView nametextview,addresstextview,dateofbirthtextview,gendertextview,numbertextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspage);

        nametextview=findViewById(R.id.nametextview);
        addresstextview=findViewById(R.id.addresstextview);
        dateofbirthtextview=findViewById(R.id.Dobtextview);
        gendertextview=findViewById(R.id.Gendertextview);
        numbertextview=findViewById(R.id.numbertextview);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String date_of_birth = intent.getStringExtra("Dob");
        String gender = intent.getStringExtra("Gender");
        String number = intent.getStringExtra("number");

        nametextview.setText(name);
        addresstextview.setText(address);
        dateofbirthtextview.setText(date_of_birth);
        gendertextview.setText(gender);
        numbertextview.setText(number);


    }
}