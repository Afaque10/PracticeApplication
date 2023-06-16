package com.example.practiceapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class formpage extends AppCompatActivity {
    final Handler handler =new Handler(Looper.getMainLooper());

    EditText nameedittext,addressedittext,dateofbirthedittext,genderdeittext,phonenumberedittext;
    Button submitbutton;
    ProgressBar Prgs;
    FirebaseAuth mAuth;
    DatabaseReference Userref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpage);
        Prgs=(ProgressBar) findViewById(R.id.loading);
        mAuth=FirebaseAuth.getInstance();
        Userref= FirebaseDatabase.getInstance().getReference().child("User");

        nameedittext=(EditText) findViewById(R.id.name);
        addressedittext=(EditText) findViewById(R.id.address);
        dateofbirthedittext=(EditText) findViewById(R.id.Dob);
        genderdeittext=(EditText) findViewById(R.id.Gender);
        phonenumberedittext=(EditText) findViewById(R.id.number);
        submitbutton=(Button) findViewById(R.id.nextbutton);

        String uid = mAuth.getUid();

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




                HashMap userMAP = new HashMap();
                userMAP.put("Name",namedata);
                userMAP.put("Address",addressdata);
                userMAP.put("Dob",dobdata);
                userMAP.put("Gender",genderdata);
                userMAP.put("PhoneNumber",numberdata);
                userMAP.put("UID",uid);

                Userref.child(uid).updateChildren(userMAP).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        Prgs.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_LONG).show();
                        startActivity(v);
                        finish();


                    }
                });

            }
        });


    }
}