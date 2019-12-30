package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arapp.utils.Commonfunction;

public class forgetpassword extends AppCompatActivity {

    EditText edt_email;
    Button btn_submit;
    TextView txt_forgetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);


        edt_email=(EditText)findViewById(R.id.edt_email);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        txt_forgetpassword=(TextView)findViewById(R.id.txt_forgetpassword);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Commonfunction.checkString(edt_email.getText().toString()))
                {
                    edt_email.setError("please enter E-mail");
                    return;
                }

                if (!Commonfunction.checkEmail(edt_email.getText().toString()))
                {
                    edt_email.setError("please enter valid E-mail");
                    return;
                }

            }
        });

        txt_forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(forgetpassword.this,Verification.class);
                startActivity(i);
            }
        });

    }
}
