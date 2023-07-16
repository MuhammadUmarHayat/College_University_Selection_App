package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdmissionRequest extends AppCompatActivity
{
    Button btnPrgBack1,btnPrgSubmit1;
    TextView tvProgramDuration1,tvProgramSemester1,tvInstituteName1,tvprorgramName1,tvProgramID1;
    EditText etStudentID1;
    MyDBHelper db;
    //programs_table:ID, prorgram,duration,institute,semester_name
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_request);
        db=new MyDBHelper(this);
        btnPrgBack1=findViewById(R.id.btnPrgBack);
        btnPrgSubmit1=findViewById(R.id.btnPrgSubmit);
        tvProgramDuration1=findViewById(R.id.tvProgramDuration);
        tvProgramSemester1=findViewById(R.id.tvProgramSemester);
        tvInstituteName1=findViewById(R.id.tvInstituteName);
        tvprorgramName1=findViewById(R.id.tvprorgramName);
        etStudentID1=findViewById(R.id.etStudentID);
        tvProgramID1=findViewById(R.id.tvProgramID);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("ProgramID"))
        {
            String pid = intent.getStringExtra("ProgramID");
            bindData(pid);
        }
        btnPrgBack1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdmissionRequest.this, Student.class);
                startActivity(intent);
            }
        });
        btnPrgSubmit1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String cnic=etStudentID1.getText().toString();
                String pid= tvProgramID1.getText().toString();;
                String pname=   tvprorgramName1.getText().toString();
                String duration=tvProgramDuration1.getText().toString();
                String semester= tvProgramSemester1.getText().toString();
                String institute=tvInstituteName1.getText().toString();
                boolean isInserted =db.saveUser_Applied(cnic,institute,pname,"request","not");
                if(isInserted == true)
                    Toast.makeText(AdmissionRequest.this,"Your request is submitted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AdmissionRequest.this,"Something is wrong",Toast.LENGTH_LONG).show();
            }
        });
    }//end of create event

    private void bindData(String id)
    {

        Cursor cursor=db.getTableData("programs_table","ID",id);
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                String pid=id;
                String name="";
                String duration="";
                String semester="";
                String institute="";

                pid=cursor.getString(0);
                name=cursor.getString(1);
                duration=cursor.getString(2);
                semester=cursor.getString(3);
                institute=cursor.getString(8);

                tvInstituteName1.setText(institute);
                tvProgramID1.setText(pid);
                tvProgramDuration1.setText(duration);
                tvprorgramName1.setText(name);
                tvProgramSemester1.setText(semester);



            }
        }//else
    }
}