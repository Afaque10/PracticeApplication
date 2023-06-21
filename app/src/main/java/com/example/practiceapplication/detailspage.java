package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class detailspage extends AppCompatActivity {

    TextView nametextview,addresstextview,dateofbirthtextview,gendertextview,numbertextview;
    FirebaseAuth mAuth;
   DatabaseReference profileref;
    String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspage);

        nametextview=findViewById(R.id.nametextview);
        addresstextview=findViewById(R.id.addresstextview);
        dateofbirthtextview=findViewById(R.id.Dobtextview);
        gendertextview=findViewById(R.id.Gendertextview);
        numbertextview=findViewById(R.id.numbertextview);

        mAuth = FirebaseAuth.getInstance();
        uid = mAuth.getCurrentUser().getUid();
        profileref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);

        profileref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String dbname,dbaddress,dbdob,dbphone;

                dbname = snapshot.child("Name").getValue().toString();
                dbaddress = snapshot.child("Address").getValue().toString();
                dbdob = snapshot.child("Dob").getValue().toString();
                dbphone = snapshot.child("PhoneNumber").getValue().toString();


                nametextview.setText(dbname);
                addresstextview.setText(dbaddress);
                dateofbirthtextview.setText(dbdob);
                numbertextview.setText(dbphone);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





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