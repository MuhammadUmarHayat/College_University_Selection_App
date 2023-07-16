package com.example.fyp8july23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeleteInstetute extends AppCompatActivity {

    TextView tv;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_instetute);
        tv=findViewById(R.id.tvDelInst1);
        btn1=findViewById(R.id.btnDelIns1);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("instituteName"))
        {
            String name = intent.getStringExtra("instituteName");
            if (intent != null && intent.hasExtra("Message"))
            {
                String program = intent.getStringExtra("Message");
                tv.setText("Welcome, " + name + "-Message "+program+"!");
            }
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(DeleteInstetute.this, Manager.class);
                startActivity(page);
            }
        });
    }
}