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

public class otpverification_page extends AppCompatActivity {
    final Handler handler = new Handler(Looper.getMainLooper());

    Button downbutton;
    ProgressBar Prog;
    EditText otpdigitone,otpdigittwo,otpdigitthree,otpdigitfour,otpdigitfive;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification_page);

        Prog=(ProgressBar) findViewById(R.id.progressbar);
        otpdigitone=(EditText) findViewById(R.id.otp1);
        otpdigittwo=(EditText) findViewById(R.id.otp2);
        otpdigitthree=(EditText) findViewById(R.id.otp3);
        otpdigitfour=(EditText) findViewById(R.id.otp4);
        otpdigitfive=(EditText) findViewById(R.id.otp5);


        downbutton=(Button) findViewById(R.id.click);
        downbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd();

            }
        });

    }
    public void  asd( ){
        Intent x = new Intent(otpverification_page.this,homepage.class);
        x.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        String number1 = otpdigitone.getText().toString().trim();
        String number2 = otpdigittwo.getText().toString().trim();
        String number3 = otpdigitthree.getText().toString().trim();
        String number4 = otpdigitfour.getText().toString().trim();
        String number5 = otpdigitfive.getText().toString().trim();
        String FinalString = number1+number2+number3+number4+number5;

        if (number1.isEmpty()||number2.isEmpty()||number3.isEmpty()||number4.isEmpty()||number5.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Otp Cannot Be Blank",Toast.LENGTH_LONG).show();
        }
        else{
            if (FinalString.length()!=5)
            {
                Toast.makeText(getApplicationContext(),"Invalid Otp",Toast.LENGTH_LONG).show();
            }

            else
            {
                Prog.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Prog.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Otp Verified Successfully",Toast.LENGTH_LONG).show();
                        startActivity(x);
                        finish();

                    }
                },1500);

            }
        }




    }
}