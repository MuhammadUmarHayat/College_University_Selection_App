package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeletePrograms extends AppCompatActivity {
    Button btnDelProg1;
    TextView tvDelProgt11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_programs);
        btnDelProg1=findViewById(R.id.btnDelProg1);
        tvDelProgt11=findViewById(R.id.tvDelProgt1);
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("ProgramName"))
        {
            String name = intent.getStringExtra("ProgramName");
            if (intent != null && intent.hasExtra("Message"))
            {
                String program = intent.getStringExtra("Message");
                tvDelProgt11.setText("Welcome, " + name + "-Message "+program+"!");
            }
        }
        btnDelProg1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(DeletePrograms.this, Manager.class);
                startActivity(page);
            }
        });

    }
}