package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class AdmissionNow extends AppCompatActivity {

    Button btnbackAdmission1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_now);
        btnbackAdmission1=findViewById(R.id.btnbackAdmission);
        btnbackAdmission1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent Adminpage = new Intent(AdmissionNow.this, MainActivity.class);
                startActivity(Adminpage);
            }
        });
    }
}