package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arapp.utils.Commonfunction;

public class ResetPassword extends AppCompatActivity {

    TextView txt_resetpassword;
    EditText edt_newpassword,edt_confirmpassword;
    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        btn_confirm=(Button)findViewById(R.id.btn_confirm);
        txt_resetpassword=(TextView)findViewById(R.id.txt_resetpassword);
        edt_newpassword=(EditText)findViewById(R.id.edt_newpassword);
        edt_confirmpassword=(EditText)findViewById(R.id.edt_confirmpassword);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Commonfunction.checkPassword(edt_newpassword.getText().toString())) {
                    edt_newpassword.setError("Enter password");
                    return;
                }

                if (!Commonfunction.checkPassword(edt_confirmpassword.getText().toString())) {
                    edt_confirmpassword.setError("Enter password");
                    return;
                }


            }
        });

        txt_resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ResetPassword.this,LoginActivity.class);
                startActivity(i);
            }
        });



            }
}
