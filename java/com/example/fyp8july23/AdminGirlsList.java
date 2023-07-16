package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AdminGirlsList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id,name, medium, address, city,  link;
    MyDBHelper dbMain;
    InstituteAdapter adapter;
    Button btninslistBack1;
    List<ImageModel> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_girls_list);
        dbMain=new MyDBHelper(this);
        btninslistBack1=findViewById(R.id.btninslistBackGirls);
        id=new ArrayList<>();
        name=new ArrayList<>();
        medium=new ArrayList<>();
        link=new ArrayList<>();

        address=new ArrayList<>();
        city =new ArrayList<>();
        imageList = new ArrayList<>();
        recyclerView= findViewById(R.id.AdminrecyclerViewAllInstitutesGirls);
        adapter=new  InstituteAdapter(this,id,name, medium, address, city,  link,imageList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        btninslistBack1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminGirlsList.this, Admin.class);

                startActivity(intent);
            }
        });


    }

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);
        String m="girls";
        Cursor cursor = dbMain.getInstituteMedium(m);
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                //String 1 name, String 2 medium, String 3 address, String 4 city, 5String link
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                medium.add(cursor.getString(2));

                city.add(cursor.getString(4));
                address.add(cursor.getString(3));
                link.add(cursor.getString(5));
                byte[] imageBytes = cursor.getBlob(7);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                imageList.add(new ImageModel(bitmap));

            }
        }//else
    }
}
