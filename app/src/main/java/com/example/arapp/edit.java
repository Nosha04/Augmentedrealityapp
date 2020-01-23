package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class edit extends AppCompatActivity {


    EditText edt_firstname,edt_lastname,edt_address,edt_email;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);



        edt_firstname=(EditText)findViewById(R.id.edt_firstname);
        edt_lastname=(EditText)findViewById(R.id.edt_lastname);
        edt_address=(EditText)findViewById(R.id.edt_address);
        edt_email=(EditText)findViewById(R.id.edt_email);
        btn_update=(Button)findViewById(R.id.btn_update);



    }
}
