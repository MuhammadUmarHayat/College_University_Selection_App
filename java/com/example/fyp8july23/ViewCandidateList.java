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
public class ViewCandidateList extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<String> id, user_cnic, institute, program, status, remarks;
    MyDBHelper dbMain;
    AllCandidatesAdapter adapter;
    Button btninslistBack1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_candidate_list);
        dbMain = new MyDBHelper(this);
        btninslistBack1 = findViewById(R.id.btnCndBack);
        recyclerView = findViewById(R.id.rcCnd);
        id = new ArrayList<>();
        user_cnic = new ArrayList<>();
        institute = new ArrayList<>();
        program = new ArrayList<>();
        status = new ArrayList<>();
        remarks = new ArrayList<>();
        adapter = new AllCandidatesAdapter(this, id, user_cnic, institute, program, status, remarks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        btninslistBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ViewCandidateList.this, Manager.class);

                startActivity(intent);
            }
        });
    }

    private void displayData() {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);

        Cursor cursor = dbMain.getAllData("users_Applied_Table");
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext())
            {
                //id,  user_cnic1,institute2,program3, status4,remarks5;
                id.add(cursor.getString(0));
                institute.add(cursor.getString(2));
                user_cnic.add(cursor.getString(1));

                program.add(cursor.getString(3));
                status.add(cursor.getString(4));
                remarks.add(cursor.getString(5));


            }
        }//else
    }//end
}