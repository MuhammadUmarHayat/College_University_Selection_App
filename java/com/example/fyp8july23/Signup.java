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


public class Signup extends AppCompatActivity {

    EditText etNames1,etFatherNames1,etCNICs1,etAddresss1,etEmails1,etPws1;
    Spinner spGenders1;
    Button btnBacks1,btnSignups1;
    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db=new MyDBHelper(this);

        spGenders1 =findViewById(R.id.spGenders);
        etNames1=findViewById(R.id.etNames);
        etFatherNames1=findViewById(R.id.etFatherNames);
        etCNICs1=findViewById(R.id.etCNICs);
        etAddresss1 =findViewById(R.id.etAddresss);
        etEmails1 =findViewById(R.id.etEmails);
        etPws1=findViewById(R.id.etPws);
        btnBacks1 =findViewById(R.id.btnBacks);
        btnSignups1 =findViewById(R.id.btnSignups);

        btnBacks1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //back to main activity
                Intent intent = new Intent(Signup.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnSignups1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String status="ok";
                String userType="student";
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
                    Toast.makeText(Signup.this,"You are Registered",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Signup.this,"Something is wrong",Toast.LENGTH_LONG).show();



            }
        });


    }
}