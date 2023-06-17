package com.example.practiceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginspalshscreen extends AppCompatActivity {

    EditText email,password;
    Button signinbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginspalshscreen);
        email=(EditText) findViewById(R.id.emailid);
        password=(EditText) findViewById(R.id.loginpassword);
        signinbutton=(Button) findViewById(R.id.Singin);

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });





    }
    public void login (){

        String emaildata = email.getText().toString().trim();
        String Passworddata = password.getText().toString().trim();


        if (emaildata.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Email Should Not Be Empty", Toast.LENGTH_SHORT).show();
        }
       else if (!emaildata.contains("@gmail.com")){

            Toast.makeText(getApplicationContext(),"Email Error",Toast.LENGTH_LONG).show();
        }
       else if (Passworddata.isEmpty())
       {
            Toast.makeText(getApplicationContext(), "Password Should Not Be Empty", Toast.LENGTH_SHORT).show();
        }
        else if (Passworddata.length()<8)
        {
            Toast.makeText(getApplicationContext(), "Password Length Should Be Greater Than 8", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "All Data Correct", Toast.LENGTH_SHORT).show();

        }
        




    }


}