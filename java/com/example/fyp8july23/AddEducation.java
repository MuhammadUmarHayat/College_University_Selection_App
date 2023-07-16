package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddEducation extends AppCompatActivity
{
    EditText etCNIC1,  etDegreeName1,  etPassingYear1;
    EditText  etBoard1, etTotalMarks1, etMarksObtained1, etpercentage1;
    Spinner SpinnerStatus1;
    Button btnEducationSave1,btnEducationBack1;
    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_education);
        etCNIC1=findViewById(R.id.etCNIC) ;
        etDegreeName1=findViewById(R.id.etDegreeName) ;
        etPassingYear1 =findViewById(R.id. etPassingYear) ;
        etBoard1=findViewById(R.id. etBoard) ;
        etTotalMarks1=findViewById(R.id.etTotalMarks) ;
        etMarksObtained1=findViewById(R.id.etMarksObtained) ;
        etpercentage1=findViewById(R.id. etpercentage) ;
        SpinnerStatus1=findViewById(R.id.SpinnerStatus) ;
        btnEducationSave1=findViewById(R.id.btnEducationSave);
        btnEducationBack1=findViewById(R.id.btnEducationBack);
        db=new MyDBHelper(this);
        btnEducationSave1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String cnic=etCNIC1.getText().toString();
                String degree=etCNIC1.getText().toString();
                String passing_year=etCNIC1.getText().toString();
                String board=etCNIC1.getText().toString();
                float total_marks=Float.valueOf(etTotalMarks1.getText().toString());
                float marks_obtained=Float.valueOf(etMarksObtained1.getText().toString());
                float percentage=Float.valueOf(etpercentage1.getText().toString());
                String status=etCNIC1.getText().toString();
                boolean result=db.saveUser_Education(cnic, degree, passing_year,  board, total_marks,  marks_obtained, percentage,  status);
                if(result)
                {
                    Toast.makeText(AddEducation.this, "Record has been added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddEducation.this, "Error ! something is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnEducationBack1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(AddEducation.this, Student.class);
                startActivity(intent);
            }
        });

    }
}