package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProgram extends AppCompatActivity {

    Button btnPrgBackEdit1,btnPrgSaveEdit1;
    MyDBHelper db;
    EditText EditetprorgramName1,EditetDuration1,EditetSemsesterName1,EditetStartingDate1,EditetClosingDate1,EditetInstituteName1,EditetMgrname1,EditetTotalSeats1;
    TextView tv121;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_program);

        EditetMgrname1  =findViewById(R.id.EditetMgrname);
        EditetprorgramName1 =findViewById(R.id.EditetprorgramName);
        EditetDuration1 =findViewById(R.id.EditetDuration);
        EditetSemsesterName1 =findViewById(R.id.EditetSemsesterName);
        EditetClosingDate1  =findViewById(R.id.EditetClosingDate);
        EditetInstituteName1 =findViewById(R.id.EditetInstituteName);
        EditetStartingDate1 =findViewById(R.id.EditetStartingDate);//
        EditetTotalSeats1=findViewById(R.id.EditetTotalSeats);


        btnPrgSaveEdit1=findViewById(R.id.btnPrgSaveEdit);
        btnPrgBackEdit1=findViewById(R.id.btnPrgBackEdit);
        tv121=findViewById(R.id.tv12);


        db=new MyDBHelper(this);


        btnPrgBackEdit1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent page = new Intent(EditProgram.this, Manager.class);
                startActivity(page);
            }
        });
        btnPrgSaveEdit1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //EditetDuration1,,,,EditetMgrname1,;

                try {
                    String status = "ok";
                    String program = EditetprorgramName1.getText().toString();
                    String duration = EditetDuration1.getText().toString();
                    String semester = EditetSemsesterName1.getText().toString();
                    String start = EditetStartingDate1.getText().toString();
                    String close = EditetClosingDate1.getText().toString();
                    String institute=EditetInstituteName1.getText().toString();
                    String Mgr=EditetMgrname1.getText().toString();
                    String s = EditetTotalSeats1.getText().toString();

                    int seats = Integer.parseInt(s);
                    Intent intent = getIntent();

                    if (intent != null && intent.hasExtra("PID")) {
                        String instituteID = intent.getStringExtra("PID");
                        int id = Integer.parseInt(instituteID);
                        // Toast.makeText(EditProgram.this, id+program+ duration+ semester+ start+ close+ seats+"Record is updated successfully", Toast.LENGTH_LONG).show();
                        boolean isInserted = db.updateProgram(id, program, duration, semester, start, close, seats,institute,Mgr);
                        if (isInserted == true)
                            Toast.makeText(EditProgram.this, "Record is updated successfully", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(EditProgram.this, "Something is wrong", Toast.LENGTH_LONG).show();
                    }
                }
                catch ( Exception exp)
                {
                    Toast.makeText(EditProgram.this, exp.getMessage().toString(), Toast.LENGTH_LONG).show();


                    tv121.setText(exp.toString());
                }
            }
        });
    }
}