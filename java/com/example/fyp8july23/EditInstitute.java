package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditInstitute extends AppCompatActivity
{
    EditText EditetInstituteNames1,EditetInstituteLink1,EditInstMedium1,EditetInstCity1,EditetInsAddress1;
    Button btnSave,btnBack;
    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_institute);
        EditetInstituteNames1 =findViewById(R.id.EditetInstituteNames);
        EditetInstituteLink1 =findViewById(R.id.EditetInstituteLink);
        EditInstMedium1 =findViewById(R.id.EditInstMedium);
        EditetInstCity1 =findViewById(R.id.EditetInstCity);
        EditetInsAddress1  =findViewById(R.id.EditetInsAddress);
        btnSave =findViewById(R.id.btnEditInsSave);
        btnBack =findViewById(R.id.btnEditInsBacks);

        db=new MyDBHelper(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(EditInstitute.this, Manager.class);
                startActivity(page);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // ,,,,;
                String status = "ok";
                String link = EditetInstituteLink1.getText().toString();
                String name = EditetInstituteNames1.getText().toString();
                String address = EditetInsAddress1.getText().toString();
                String medium = EditInstMedium1.getText().toString();
                String city = EditetInstCity1.getText().toString();

                int seats = 100;
                Intent intent = getIntent();

                if (intent != null && intent.hasExtra("instituteID")) {
                    String instituteID = intent.getStringExtra("instituteID");
                    int  id = Integer.parseInt(instituteID);

                    boolean isInserted = db.updateInstitute(id, name, medium, address, city, link, status);
                    if (isInserted == true)
                        Toast.makeText(EditInstitute.this, "Record is updated successfully", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(EditInstitute.this, "Something is wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}