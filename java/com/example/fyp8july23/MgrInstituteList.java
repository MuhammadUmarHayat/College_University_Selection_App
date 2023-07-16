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

public class MgrInstituteList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id,name, medium, address, city,  link;
    MyDBHelper db;
    AllinstitutesAdapter adapter;
    Button btninslistBack1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_institute_list);
        db=new MyDBHelper(this);
        btninslistBack1=findViewById(R.id.btninslistBack);
        id=new ArrayList<>();
        name=new ArrayList<>();
        medium=new ArrayList<>();
        link=new ArrayList<>();

        address=new ArrayList<>();
        city =new ArrayList<>();
        recyclerView= findViewById(R.id.recyclerViewAllInstitutes);
        adapter=new  AllinstitutesAdapter(this,id,name, medium, address, city,  link);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        btninslistBack1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MgrInstituteList.this, Manager.class);

                startActivity(intent);
            }
        });


    }

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);
        Cursor cursor = db.getAllData("institutes");
        if (cursor.getCount() == 0)
        {

        } else {
            while (cursor.moveToNext()) {
                //String 1 name, String 2 medium, String 3 address, String 4 city, 5String link
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                medium.add(cursor.getString(2));

                city.add(cursor.getString(4));
                address.add(cursor.getString(3));
                link.add(cursor.getString(5));


            }
        }
    }
}
