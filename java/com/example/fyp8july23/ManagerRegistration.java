package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ManagerRegistration extends AppCompatActivity {

    EditText etNames1,etFatherNames1,etCNICs1,etAddresss1,etEmails1,etPws1;
    Spinner spGenders1;
    Button btnBacks1,btnSignups1;
    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_registration);
        db=new MyDBHelper(this);

        spGenders1 =findViewById(R.id.AdminspGenders);
        etNames1=findViewById(R.id.AdminetNames);
        etFatherNames1=findViewById(R.id.AdminetFatherNames);
        etCNICs1=findViewById(R.id.AdminetCNICs);
        etAddresss1 =findViewById(R.id.AdminetAddresss);
        etEmails1 =findViewById(R.id.AdminetEmails);
        etPws1=findViewById(R.id.AdminetPws);
        btnBacks1 =findViewById(R.id.AdminbtnBacks);
        btnSignups1 =findViewById(R.id.AdminbtnSignups);

        btnBacks1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //back to main activity
                Intent intent = new Intent(ManagerRegistration.this, Admin.class);
                startActivity(intent);
            }
        });


        btnSignups1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String status="ok";
                String userType="manager";
                String name =  etNames1.getText().toString();
                String  FName= etFatherNames1.getText().toString();
                String gender =  spGenders1.getSelectedItem().toString();
                String  cnic= etCNICs1.getText().toString();
                String address =  etAddresss1.getText().toString();
                String  email= etEmails1.getText().toString();
                String  pw= etPws1.getText().toString();
//saveUser(String full_name, String father_name, String gender, String cnic,
// String address, String status,String user_type, String email, String password)
                boolean isInserted =db.saveUser(name,FName,gender,cnic,address,status,userType,email,pw);
                if(isInserted == true)
                    Toast.makeText(ManagerRegistration.this,"You are Registered",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ManagerRegistration.this,"Something is wrong",Toast.LENGTH_LONG).show();



            }
        });


    }
}