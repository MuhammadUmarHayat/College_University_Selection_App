package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Manager extends AppCompatActivity
{
    Button btAddInstitute1,btInstituteDetails1,btnAddPrograms1,btnMgrViewProgramsList1,btnViewCandidateList1,btnMgrLogout1;
    private SessionManager sessionManager;
    TextView mgrNameTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        sessionManager = new SessionManager(getApplicationContext());


        if (!sessionManager.isLoggedIn()) {
            // User is not logged in, redirect to login activity
            Intent intent = new Intent(Manager.this, login.class);
            startActivity(intent);
            finish();
        }
        btAddInstitute1  =findViewById(R.id.btAddInstitute);
        btInstituteDetails1=findViewById(R.id.btInstituteDetails);
        btnAddPrograms1=findViewById(R.id.btnAddPrograms);
        btnMgrViewProgramsList1=findViewById(R.id.btnMgrViewProgramsList);
        btnViewCandidateList1 =findViewById(R.id.btnViewCandidateList);
        btnMgrLogout1=findViewById(R.id.btnMgrLogout);
        mgrNameTv1=findViewById(R.id.mgrNameTv);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("userid"))
        {
            String name = intent.getStringExtra("userid");

            mgrNameTv1.setText(name);
        }
        btAddInstitute1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String userid=mgrNameTv1.getText().toString();
                Intent page = new Intent(Manager.this, MgrAddInstitute.class);
                intent.putExtra("userid", userid);
                startActivity(page);
                finish();
            }
        });

        btInstituteDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String userid=mgrNameTv1.getText().toString();
                Intent page = new Intent(Manager.this, MgrInstituteList.class);
                intent.putExtra("userid", userid);
                startActivity(page);
            }
        });
        btnAddPrograms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(Manager.this, MgrAddPrograms.class);
                startActivity(page);
            }
        });
        btnMgrViewProgramsList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page = new Intent(Manager.this, MgrProgramList.class);
                startActivity(page);
            }
        });
        btnViewCandidateList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page = new Intent(Manager.this, ViewCandidateList.class);
                startActivity(page);

            }
        });
        btnMgrLogout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logout();
                // Start the login activity
                Intent intent = new Intent(Manager.this, login.class);
                startActivity(intent);
                finish();
            }
        });





    }
}