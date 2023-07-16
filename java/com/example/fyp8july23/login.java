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

public class login extends AppCompatActivity {
    private EditText lgEd11,lgEd21;
    private Button btnloginlg,btnBacklg1;
    private Spinner spuserType1;
    MyDBHelper db;
    private SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(getApplicationContext());
//        getSupportActionBar().hide();//hide the title bar
        lgEd11 =findViewById(R.id.lgEd1);
        lgEd21=findViewById(R.id.lgEd2);

        spuserType1=findViewById(R.id.spusertype);

        btnloginlg =findViewById(R.id.btnloginlg);
        btnBacklg1 =findViewById(R.id.btnBacklg);
        db=new MyDBHelper(this);
        btnloginlg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String userid=lgEd11.getText().toString();
                String pw=lgEd21.getText().toString();
                String userType=spuserType1.getSelectedItem().toString();

                if(userType.equals("admin") && userid.equals("admin")&& pw.equals("admin"))
                {
                    sessionManager.setUsername(userid);
                    sessionManager.setLoggedIn(true);
                    Intent intent = new Intent(login.this, Admin.class);
                    intent.putExtra("userid", userid);
                    startActivity(intent);
                    finish();

                }
                if(userType.equals("manager") && userid.equals("manager")&& pw.equals("manager"))
                {
                    sessionManager.setUsername(userid);
                    sessionManager.setLoggedIn(true);
                    Intent intent = new Intent(login.this, Manager.class);
                    intent.putExtra("userid", userid);
                    startActivity(intent);
                    finish();

                }
                if(userType.equals("student") && userid.equals("student")&& pw.equals("student"))
                {
                    Intent intent = new Intent(login.this, Student.class);
                    intent.putExtra("userid", userid);
                    startActivity(intent);
                    finish();
                }
                boolean user=db.isUserExists(userid,pw,userType);
                if(user)
                {
                    if(userType.equals("student"))
                    {

                        sessionManager.setUsername(userid);
                        sessionManager.setLoggedIn(true);

                        Intent intent = new Intent(login.this, Student.class);
                        intent.putExtra("userid", userid);
                        startActivity(intent);
                        finish();

                    }
                    else if(userType.equals("manager"))
                    {
                        sessionManager.setUsername(userid);
                        sessionManager.setLoggedIn(true);
                        //Navigate to intitute manager
                        Intent intent = new Intent(login.this, Manager.class);
                        intent.putExtra("userid", userid);
                        startActivity(intent);

                        finish();
                    }
                    else
                    {
                        Toast.makeText(login.this,"Choose correct user type",Toast.LENGTH_LONG).show();
                    }


                }
                else {
                  //  Toast.makeText(login.this,"Enter correct userid and password",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnBacklg1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //back to main activity
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}