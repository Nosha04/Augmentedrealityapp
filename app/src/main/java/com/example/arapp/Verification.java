package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arapp.utils.Commonfunction;

public class Verification extends AppCompatActivity {

    EditText edt_num1,edt_num2,edt_num3,edt_num4;
    Button btn_verify;
    TextView txt_verification;

    String id,code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        edt_num1=(EditText)findViewById(R.id.edt_num1);
        edt_num2=(EditText)findViewById(R.id.edt_num2);
        edt_num3=(EditText)findViewById(R.id.edt_num3);
        edt_num4=(EditText)findViewById(R.id.edt_num4);
        btn_verify=(Button)findViewById(R.id.btn_verify);
        txt_verification=(TextView)findViewById(R.id.txt_verification);

        id = getIntent().getStringExtra("id");
        code = getIntent().getStringExtra("code");

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mycode = edt_num1.getText().toString() + edt_num2.getText().toString() + edt_num3.getText().toString() + edt_num4.getText().toString();

                if (!Commonfunction.checkString(code))
                {
                    Toast.makeText(Verification.this, "Please enter verification code", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mycode.equals(code))
                {
                    Toast.makeText(Verification.this, "Verification code matched.", Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(Verification.this,ResetPassword.class);
                    i.putExtra("id",id);
                    startActivity(i);

                }
                else{
                    Toast.makeText(Verification.this, "Invalid verification code", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
