package com.example.practiceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginspalshscreen extends AppCompatActivity {

    EditText email,password;
    Button signinbutton;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginspalshscreen);
        email=(EditText) findViewById(R.id.emailid);
        password=(EditText) findViewById(R.id.loginpassword);
        signinbutton=(Button) findViewById(R.id.Singin);




        mAuth = FirebaseAuth.getInstance();
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

            mAuth.signInWithEmailAndPassword(emaildata,Passworddata).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        Intent x = new Intent(loginspalshscreen.this,homepage.class);
                        x.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        Toast.makeText(getApplicationContext(),"Login successfull",Toast.LENGTH_LONG).show();
                        startActivity(x);
                        finish();
                    }
                    else {
                        String msg = task.getException().getMessage();
                        if (msg.equals("There is no user record corresponding to this identifier. The user may have been deleted.")){
                            Toast.makeText(loginspalshscreen.this, "No user Found", Toast.LENGTH_LONG).show();

                        }


                        else if (msg.equals("The password is invalid or the user does not have a password.")){
                            Toast.makeText(loginspalshscreen.this, "Invalid Email or Password", Toast.LENGTH_LONG).show();


                        }

                        else {
                            Toast.makeText(loginspalshscreen.this, "Something went wrong", Toast.LENGTH_LONG).show();
                        }

                    }

                }
            });

        }
        




    }


}