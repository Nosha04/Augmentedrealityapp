package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;
import com.example.arapp.utils.DataInterface;
import com.example.arapp.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements DataInterface {

    EditText edt_email,edt_password;
    Button btn_login;
    TextView txt_login,txt_signup,txt_forgetpassword;

    Webservice_Volley volley;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_password=(EditText)findViewById(R.id.edt_password);
        btn_login=(Button)findViewById(R.id.btn_login);
        txt_login=(TextView)findViewById(R.id.txt_login);
        txt_forgetpassword=(TextView)findViewById(R.id.txt_forgetpassword);
        txt_signup=(TextView)findViewById(R.id.txt_signup);

        volley = new Webservice_Volley(this,this);





        btn_login.setOnClickListener(new View.OnClickListener() {
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

                if (!Commonfunction.checkPassword(edt_password.getText().toString()))
                {
                    edt_password.setError("Enter password");
                    return;
                }


                String url = Constants.Webserive_Url+"login.php";
                HashMap<String,String> params = new HashMap<>();
                params.put("E_MAIL",edt_email.getText().toString());
                params.put("PASSWORD",edt_password.getText().toString());

                volley.CallVolley(url,params,"login.php");



            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        txt_forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,forgetpassword.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {

    }
}
