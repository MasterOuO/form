package com.master.form;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

@SuppressLint("Registered")
public class second extends AppCompatActivity {

    //TextView name,gender,mail,bir,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        Intent intent = getIntent();
        //float bmi = intent.getFloatExtra("BMI_EXTRA", 0);
        String na = intent.getStringExtra("name");
        String ge = intent.getStringExtra("gender");
        String ma = intent.getStringExtra("mail");
        String bi = intent.getStringExtra("bir");
        String ph = intent.getStringExtra("phone");
        String sc = intent.getStringExtra("school");

        TextView name =  findViewById(R.id.name);
        TextView gender =  findViewById(R.id.gender);
        TextView mail =  findViewById(R.id.mail);
        TextView bir =  findViewById(R.id.bir);
        TextView school =  findViewById(R.id.school);
        TextView phone =  findViewById(R.id.phone);

        name.setText(na);
        gender.setText(ge);
        mail.setText(ma);
        bir.setText(bi);
        phone.setText(ph);
        school.setText(sc);

    }



}
