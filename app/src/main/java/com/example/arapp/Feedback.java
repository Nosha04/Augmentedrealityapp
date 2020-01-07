package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Feedback extends AppCompatActivity {

    TextView txt_comment,txt_rating;
    Button btn_submit;
    EditText edt_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        txt_comment=(TextView) findViewById(R.id.txt_comment);
        txt_rating=(TextView) findViewById(R.id.txt_rating);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        edt_comment=(EditText) findViewById(R.id.edt_complain);

    }
}
