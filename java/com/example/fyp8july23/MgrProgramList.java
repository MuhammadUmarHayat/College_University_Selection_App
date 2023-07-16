package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MgrProgramList extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnPrglistBack1;
    //Program(String prorgram, String duration, String semester_name, String starting_date, String closing_date,
    // String status, String remarks, String institute, String manager, int seats) {
    ArrayList<String> id,prorgram, duration, semester_name, starting_date,  closing_date,institute;
    MyDBHelper db;
    AllProgramsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_program_list);
        db=new MyDBHelper(this);
        //id,prorgram, duration, semester_name, starting_date,  closing_date,institute;
        id=new ArrayList<>();
        prorgram=new ArrayList<>();
        duration=new ArrayList<>();
        semester_name=new ArrayList<>();

        starting_date=new ArrayList<>();
        closing_date =new ArrayList<>();
        institute =new ArrayList<>();
        recyclerView= findViewById(R.id.recyclerViewAllPrograms);

        adapter=new  AllProgramsAdapter(this,id,prorgram, duration, semester_name, starting_date,  closing_date,institute);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        btnPrglistBack1=findViewById(R.id.btnPrglistBack);
        btnPrglistBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MgrProgramList.this, Manager.class);

                startActivity(intent);

            }
        });


    }

    private void displayData()
    {

        // String       manager = intent.getStringExtra("userid");
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);
        Cursor cursor = db.getAllData("programs_table");
        if (cursor.getCount() == 0)
        {

        } else {
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

}