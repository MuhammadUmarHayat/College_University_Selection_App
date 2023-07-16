package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewNotifications extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<String> user_cnic, institute,  program,status,  remarks;
    MyDBHelper dbMain;
    AllNotificationsAdapter adapter;
    Button btninslistBack1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notifications);
        dbMain=new MyDBHelper(this);
        btninslistBack1=findViewById(R.id.btninslistBackNotifications);
        recyclerView= findViewById(R.id.AdminrecyclerViewAllNotifications);

        user_cnic=new ArrayList<>();
        institute=new ArrayList<>();
        program=new ArrayList<>();
        status=new ArrayList<>();
        remarks=new ArrayList<>();
        adapter=new AllNotificationsAdapter(this,user_cnic,institute,program,status,remarks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        btninslistBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ViewNotifications.this, Student.class);

                startActivity(intent);
            }
        });
    }

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);

        Cursor cursor = dbMain.getAllData("users_Applied_Table");
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                //String 1 name, String 2 medium, String 3 address, String 4 city, 5String link

                //user_cnic, institute,  program,status,  remarks;
                user_cnic.add(cursor.getString(1));
                institute.add(cursor.getString(2));
                program.add(cursor.getString(3));

                status.add(cursor.getString(4));
                remarks.add(cursor.getString(5));


            }
        }
    }
}