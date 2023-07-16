package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CandidateStatus extends AppCompatActivity
{
    TextView tv;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_status);
        tv=findViewById(R.id.tvStatus);
        btn1=findViewById(R.id.btnBackCanSt);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("CNIC"))
        {
            String name = intent.getStringExtra("CNIC");
            if (intent != null && intent.hasExtra("Message"))
            {
                String program = intent.getStringExtra("Message");
                tv.setText("Candidate CNIC= " + name + " Message "+program+"!");
            }
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(CandidateStatus.this, Manager.class);
                startActivity(page);
            }
        });
    }
}