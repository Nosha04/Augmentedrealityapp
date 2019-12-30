package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.arapp.utils.Commonfunction;

public class MainActivity extends AppCompatActivity {

    EditText edt_firstname,edt_lastname,edt_address,edt_email,edt_password,edt_age;
    RadioButton btn_male,btn_female;
    Button btn_signup;
    TextView txt_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt_firstname=(EditText)findViewById(R.id.edt_firstname);
        edt_lastname=(EditText)findViewById(R.id.edt_lastname);
        edt_address=(EditText)findViewById(R.id.edt_address);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_password=(EditText)findViewById(R.id.edt_password);
        edt_age=(EditText)findViewById(R.id.edt_age);
        btn_male=(RadioButton)findViewById(R.id.btn_male);
        btn_female=(RadioButton)findViewById(R.id.btn_female);
        btn_signup=(Button)findViewById(R.id.btn_signup);
        txt_signup=(TextView)findViewById(R.id.txt_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Commonfunction.checkString(edt_firstname.getText().toString())) {
                    edt_firstname.setError("Enter Firstname");
                    return;
                }

                if (!Commonfunction.checkString(edt_lastname.getText().toString())) {
                    edt_lastname.setError("Enter lastname");
                    return;
                }

                if (!Commonfunction.checkString(edt_age.getText().toString())) {
                    edt_age.setError("Enter your age");
                    return;
                }

                if (!Commonfunction.checkPassword(edt_address.getText().toString())) {
                    edt_address.setError("Enter address");
                    return;
                }

                if (!Commonfunction.checkString(edt_email.getText().toString())) {
                    edt_email.setError("please enter E-mail");
                    return;
                }

                if (!Commonfunction.checkEmail(edt_email.getText().toString())) {
                    edt_email.setError("please enter valid E-mail");
                    return;
                }

                if (!Commonfunction.checkPassword(edt_password.getText().toString())) {
                    edt_password.setError("Enter password");
                    return;
                }


            }
        });
            }
}
