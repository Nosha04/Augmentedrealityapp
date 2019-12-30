package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arapp.utils.Commonfunction;

public class Verification extends AppCompatActivity {

    EditText edt_num1,edt_num2,edt_num3,edt_num4;
    Button btn_verify;
    TextView txt_verification;

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


        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Commonfunction.checkString(edt_num1.getText().toString()))
                {
                    edt_num1.setError("num1");
                    return;
                }

                if (!Commonfunction.checkString(edt_num2.getText().toString()))
                {
                    edt_num2.setError("num2");
                    return;
                }

                if (!Commonfunction.checkString(edt_num3.getText().toString()))
                {
                    edt_num3.setError("num3");
                    return;
                }

                if (!Commonfunction.checkString(edt_num4.getText().toString()))
                {
                    edt_num4.setError("num4");
                    return;
                }

            }
        });

        txt_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Verification.this,ResetPassword.class);
                startActivity(i);
            }
        });


    }
}
