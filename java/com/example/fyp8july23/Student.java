package com.example.fyp8july23;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Student extends AppCompatActivity
{
    MyDBHelper db;
    Spinner spCity,spProgram;
    List<String> itemCity,itemProgram ;
    Button btnsearch,btnviewAll,btnLogout1,btnAddEducation1,btnNotifications;
    RecyclerView recyclerView;
    ArrayList<String> id,prorgram, duration, semester_name, starting_date,  closing_date,institute;
    ProgramsAdapter programAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
//        spCity=findViewById(R.id.spinnerCity);//spinnerProgram
        spProgram=findViewById(R.id.spinnerProgram);
        btnsearch=findViewById(R.id.btnSearch);
        btnviewAll=findViewById(R.id.btnallinstitutes);
        btnLogout1=findViewById(R.id.btnLogout);
        btnAddEducation1=findViewById(R.id.btnAddEducation);
        btnNotifications=findViewById(R.id.btnviewNotification);
        btnAddEducation1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Student.this, AddEducation.class);

                startActivity(intent);
            }
        });
        btnNotifications.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Student.this, ViewNotifications.class);

                startActivity(intent);
            }
        });
        recyclerView=findViewById(R.id.rcStudent);
        db=new MyDBHelper(this);

        id=new ArrayList<>();
        prorgram=new ArrayList<>();
        duration=new ArrayList<>();
        semester_name=new ArrayList<>();

        starting_date=new ArrayList<>();
        closing_date =new ArrayList<>();
        institute =new ArrayList<>();


        itemCity = new ArrayList<>();
        itemProgram = new ArrayList<>();

        //get cities
//        Cursor cursor=db.getCities();
//        if (cursor.moveToFirst()) {
//            do {
//                String data = cursor.getString(0);//cursor.getString(cursor.getColumnIndex("managerid"));
//                itemCity.add(data);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        //bind cities
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemCity);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spCity.setAdapter(adapter);

        //get programs
        Cursor cursor2=db.getPrograms();
        if (cursor2.moveToFirst()) {
            do {
                String data = cursor2.getString(0);
                itemProgram.add(data);
            } while (cursor2.moveToNext());
        }

        cursor2.close();
        //bind cities
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemProgram);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProgram.setAdapter(adapter2);

        btnviewAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                programAdapter=new  ProgramsAdapter(Student.this,id,prorgram, duration, semester_name, starting_date,  closing_date,institute);
                recyclerView.setAdapter(programAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Student.this));
                String program="all";String city="all";
                displayData(program);

            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //String city="all"; //spCity.getSelectedItem().toString();
                String program=spProgram.getSelectedItem().toString();
                programAdapter=new  ProgramsAdapter(Student.this,id,prorgram, duration, semester_name, starting_date,  closing_date,institute);
                recyclerView.setAdapter(programAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Student.this));

                displayData(program);

            }
        });
        btnLogout1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Student.this, login.class);

                startActivity(intent);
            }
        });

    }//end on create

    private void displayData(String program)
    {
        Cursor cursor ;

        if(program.equals("all") )
        {
            cursor = db.getAllData("programs_table");
        }
        else
        {

            cursor = db.Search(program);

        }


        if (cursor.getCount() == 0)
        {

        } else
        {
            while (cursor.moveToNext())
            {
                //id,prorgram, duration, semester_name, starting_date,  closing_date,institute
                id.add(cursor.getString(0));
                prorgram.add(cursor.getString(1));
                duration.add(cursor.getString(2));
                semester_name.add(cursor.getString(3));
                starting_date.add(cursor.getString(4));
                closing_date.add(cursor.getString(5));
                institute.add(cursor.getString(8));


            }
        }
    }

}//class








