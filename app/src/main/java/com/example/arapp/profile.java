package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {



    TextView txt_name,txt_email,txt_address,txt_number;
    Button btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txt_name=(TextView)findViewById(R.id.txt_name);
        txt_email=(TextView)findViewById(R.id.txt_email);
        txt_number=(TextView)findViewById(R.id.txt_number);
        txt_address=(TextView)findViewById(R.id.txt_address);
        btn_edit=(Button)findViewById(R.id.btn_edit);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(profile.this,edit.class);
                startActivity(i);
            }
        });

    }
}
