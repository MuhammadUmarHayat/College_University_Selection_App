package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button btnadmission,btnCollage,btnUniversity,btnLogin,btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();//hide the title bar
        btnadmission=findViewById(R.id.btnm1);
        btnCollage =findViewById(R.id.btnm2);
        btnUniversity =findViewById(R.id.btnm3);
        btnLogin =findViewById(R.id.btnm4);

        btnSignup=findViewById(R.id.btnm5);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Adminpage = new Intent(MainActivity.this, Signup.class);
                startActivity(Adminpage);
            }
        });





        btnadmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent Adminpage = new Intent(MainActivity.this, AdmissionNow.class);
                startActivity(Adminpage);
            }
        });

        btnCollage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent Adminpage = new Intent(MainActivity.this, CollageList.class);
                startActivity(Adminpage);
            }
        });
        btnUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent Adminpage = new Intent(MainActivity.this, UniversityList.class);
                startActivity(Adminpage);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent Adminpage = new Intent(MainActivity.this, login.class);
                startActivity(Adminpage);

            }
        });


    }
}