package com.example.practiceapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class registerphonenumber extends AppCompatActivity {
    final Handler handler = new Handler(Looper.getMainLooper());

    EditText numberverify,otpdigitone,otpdigittwo,otpdigitthree,otpdigitfour,otpdigitfive,otpdigitsix;
    Button Sendbutton,Verifybutton;
    ProgressBar Progsend,Progverify;
    TextView phonenumbertextview;
    FirebaseAuth mAuth;
    LinearLayout otpsendlayout,otpverifylayout;
    String otpID,phonenumber,finalotp;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerphonenumber);

        Progverify=(ProgressBar) findViewById(R.id.progressbar);
        Progsend=(ProgressBar) findViewById(R.id.loadingbar);
        numberverify=(EditText) findViewById(R.id.numberphone);
        phonenumbertextview=(TextView) findViewById(R.id.phonetextview);
        mAuth = FirebaseAuth.getInstance();
        otpsendlayout=(LinearLayout) findViewById(R.id.Linearlaypoutsendotp);
        otpverifylayout=(LinearLayout) findViewById(R.id.linearlayoutverifyotp);

        otpdigitone=(EditText) findViewById(R.id.otp1);
        otpdigittwo=(EditText) findViewById(R.id.otp2);
        otpdigitthree=(EditText) findViewById(R.id.otp3);
        otpdigitfour=(EditText) findViewById(R.id.otp4);
        otpdigitfive=(EditText) findViewById(R.id.otp5);
        otpdigitsix = (EditText) findViewById(R.id.otp6);

        Sendbutton=(Button) findViewById(R.id.in);
        Verifybutton=(Button) findViewById(R.id.click);

        Sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sendotp();

            }
        });
        Verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyotp();

            }
        });
    }
    private void verifyotp() {

        String number1 = otpdigitone.getText().toString().trim();
        String number2 = otpdigittwo.getText().toString().trim();
        String number3 = otpdigitthree.getText().toString().trim();
        String number4 = otpdigitfour.getText().toString().trim();
        String number5 = otpdigitfive.getText().toString().trim();
        String number6 = otpdigitsix.getText().toString().trim();
        String finalotp = number1 + number2 + number3 + number4 + number5 + number6;

        if (number1.isEmpty()||number2.isEmpty()||number3.isEmpty()||number4.isEmpty()||number5.isEmpty()||number6.isEmpty()){

            Toast.makeText(getApplicationContext(),"Otp Cannot Be Blank",Toast.LENGTH_LONG).show();
        }
        else {
            if(finalotp.length()!=6){

                Toast.makeText(getApplicationContext(),"Otp Length Less Then Six",Toast.LENGTH_LONG).show();
            }
            else {

                Progverify.setVisibility(View.VISIBLE);
                PhoneAuthCredential authCredential = PhoneAuthProvider.getCredential(otpID,finalotp);
                signInWithPhoneAuthCredential(authCredential);

            }

        }




    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential authCredential) {
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
            Progverify.setVisibility(View.GONE);
            Intent x = new Intent(registerphonenumber.this,formpage.class);
            x.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            Toast.makeText(getApplicationContext(),"Otp Verified successfully",Toast.LENGTH_LONG).show();
            startActivity(x);
            finish();

            }
            else{
                Progverify.setVisibility(View.GONE);
                String msg = task.getException().getMessage();
                if (msg.equals("The sms code has expired. Please re-send the verification code to try again.")) {
                    Toast.makeText(getApplicationContext(), "Code Expired", Toast.LENGTH_LONG).show();
                } else if (msg.equals("The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user.")) {
                    Toast.makeText(getApplicationContext(), "Invalid Code", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                }





            }




            }
        });
    }


    public void  Sendotp( ){
        phonenumber = numberverify.getText().toString().trim();

        if(phonenumber.isEmpty()){
            Toast.makeText(getApplicationContext(),"Phone Number Should not be empty",Toast.LENGTH_LONG).show();

        }
        else if (phonenumber.length()!=10){
            Toast.makeText(getApplicationContext(),"Phone Number Should be 10 Digits",Toast.LENGTH_LONG).show();
        }
        else
        {
            Progsend.setVisibility(View.VISIBLE);
            PhoneAuthOptions phoneAuthOptions = PhoneAuthOptions.newBuilder(mAuth).
                    setPhoneNumber("+91"+phonenumber).
                    setTimeout(60L, TimeUnit.SECONDS).
                    setActivity(this).setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Progsend.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                            Progsend.setVisibility(View.GONE);
                            otpsendlayout.setVisibility(View.GONE);
                            phonenumbertextview.setText("+91 "+phonenumber);
                            otpverifylayout.setVisibility(View.VISIBLE);
                            otpID = verificationId;
                            Toast.makeText(getApplicationContext(),"OTP sent successfully",Toast.LENGTH_LONG).show();
                            //mResendToken = token;
                        }
                    }).build();
            PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions);

        }

        }






    }
