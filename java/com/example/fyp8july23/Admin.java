package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin extends AppCompatActivity
{
    TextView tv;
    Button adminbtnsignupMgr, adminAddInstitutes,adminAddProgram,adminCollegeList,adminUniversityList;
    Button adminGirlsInstitutes,adminBoysInstitutes,adminLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        tv=findViewById(R.id.tvAdmin1);
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("userid"))
        {
            String name = intent.getStringExtra("userid");
            tv.setText("Welcome, " + name + "!");

        }
        adminbtnsignupMgr=findViewById(R.id.adminbtnsignupMgr);
        adminAddInstitutes=findViewById(R.id. adminAddInstitutes);
        adminAddProgram=findViewById(R.id.adminAddProgram);
        adminCollegeList=findViewById(R.id.adminCollegeList);
        adminUniversityList=findViewById(R.id.adminUniversityList);


        adminGirlsInstitutes  =findViewById(R.id.adminGirlsInstitutes);
        adminBoysInstitutes =findViewById(R.id. adminBoysInstitutes);
        adminLogout  =findViewById(R.id.  adminLogout);

        adminbtnsignupMgr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Admin.this, ManagerRegistration.class);
                startActivity(intent);
            }
        });

        adminAddInstitutes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Admin.this, AdminAddInstitute.class);
                startActivity(intent);
            }
        });


        adminAddProgram.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Admin.this, AdminAddPrograms.class);
                startActivity(intent);
            }
        });

        adminCollegeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, AdminCollegeList.class);
                startActivity(intent);
            }
        });
//1
        adminUniversityList .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, AdminUniversityList.class);
                startActivity(intent);
            }
        });
        adminGirlsInstitutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, AdminGirlsList.class);
                startActivity(intent);
            }
        });

        adminBoysInstitutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, AdminBoysList.class);
                startActivity(intent);
            }
        });



        adminLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Admin.this, login.class);
                startActivity(intent);
            }
        });



    }
}