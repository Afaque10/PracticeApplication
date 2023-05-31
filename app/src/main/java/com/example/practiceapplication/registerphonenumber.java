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
import android.widget.Toast;

public class registerphonenumber extends AppCompatActivity {
    final Handler handler = new Handler(Looper.getMainLooper());

    Button bottombutton;
    ProgressBar Prog;
    EditText numberverify;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerphonenumber);

        Prog=(ProgressBar) findViewById(R.id.loadingbar);
        numberverify=(EditText) findViewById(R.id.numberphone);

        bottombutton=(Button) findViewById(R.id.in);
        bottombutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd();

            }
        });

    }
    public void  asd( ){
        Intent x = new Intent(registerphonenumber.this,otpverification_page.class);
        String otpnumber = numberverify.getText().toString().trim();
        if (otpnumber.length()!=10)
        {
            Toast.makeText(getApplicationContext(),"Number Should 10 Digits",Toast.LENGTH_LONG).show();
        }
        else
        {
            Prog.setVisibility(View.VISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Prog.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Otp Sent Successfully",Toast.LENGTH_LONG).show();
                    startActivity(x);

                }
            },1500);

        }





    }
}