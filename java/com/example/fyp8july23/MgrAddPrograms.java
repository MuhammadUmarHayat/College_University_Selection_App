package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MgrAddPrograms extends AppCompatActivity
{
    EditText etMgrname1,etprorgram1,etDuration1,etSemsesterName1,etStartingDate1,etClosingDate1,etInstituteName1,etTotalSeats1;
    Button btnPrgSave1,btnPrgBack1;
    MyDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_add_programs);
        etMgrname1 =findViewById(R.id.MgretMgrname);
        etprorgram1 =findViewById(R.id.Mgretprorgram);
        etDuration1 =findViewById(R.id.MgretDuration);
        etSemsesterName1 =findViewById(R.id.MgrSemsesterName);
        etStartingDate1  =findViewById(R.id.MgretStartingDate);
        etClosingDate1 =findViewById(R.id.MgretClosingDate);
        etInstituteName1 =findViewById(R.id.MgretInstituteName);//
        etTotalSeats1=findViewById(R.id.MgretTotalSeats);
        btnPrgSave1 =findViewById(R.id.MgrbtnPrgSave);
        btnPrgBack1 =findViewById(R.id.MgrbtnPrgBack);

        db=new MyDBHelper(this);




        btnPrgBack1 .setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(MgrAddPrograms.this, Manager.class);
                startActivity(page);
            }
        });


        btnPrgSave1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                //   ,,,,,,;
                try {
                    String status = "ok";
                    String mgr = etMgrname1.getText().toString();
                    String pragram = etprorgram1.getText().toString();
                    String duration = etDuration1.getText().toString();
                    String semester = etSemsesterName1.getText().toString();
                    String start = etStartingDate1.getText().toString();
                    String close = etClosingDate1.getText().toString();
                    String instituteName = etInstituteName1.getText().toString();
                    String s = etTotalSeats1.getText().toString();
                    int seats = Integer.parseInt(s);
                    String remarks = "-";
                    boolean isInserted = db.saveProgram(pragram, duration, semester, start, close, status, remarks, instituteName, mgr, seats);
                    if (isInserted == true)
                        Toast.makeText(MgrAddPrograms.this, "Record is saved successfully", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MgrAddPrograms.this, "Something is wrong", Toast.LENGTH_LONG).show();
                }
                catch ( Exception exp)
                {
                    Toast.makeText(MgrAddPrograms.this, exp.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}