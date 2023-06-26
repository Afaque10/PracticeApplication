package com.example.practiceapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class        homepage extends AppCompatActivity {

    LinearLayout cartimage,users;
    ImageView logoutbutton;
    FirebaseAuth mAuth;
    ImageView profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        logoutbutton=(ImageView) findViewById(R.id.logoutbutton);
        profile = (ImageView) findViewById(R.id.user);
        mAuth=FirebaseAuth.getInstance();
        cartimage=(LinearLayout) findViewById(R.id.cart_button);
        users=(LinearLayout) findViewById(R.id.list_users);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(homepage.this,detailspage.class);
                startActivity(c);
            }
        });
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(homepage.this,list_users.class);
                startActivity(q);
            }
        });
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                Toast.makeText(getApplicationContext(),"Signout Successful",Toast.LENGTH_LONG).show();
                Intent c = new Intent(homepage.this,registerphonenumber.class);
                c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(c);
                finish();

            }
        });
        cartimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd();

            }
        });

    }
    public void  asd( ){
        Intent x = new Intent(homepage.this,loginsplah.class);
        startActivity(x);
    }
}