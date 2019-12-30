package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;
import com.example.arapp.utils.DataInterface;
import com.example.arapp.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class forgetpassword extends AppCompatActivity implements DataInterface {

    EditText edt_email;
    Button btn_submit;
    TextView txt_forgetpassword;

    Webservice_Volley volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);


        edt_email=(EditText)findViewById(R.id.edt_email);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        txt_forgetpassword=(TextView)findViewById(R.id.txt_forgetpassword);


        volley = new Webservice_Volley(this,this);

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


                String url = Constants.Webserive_Url+"forgotpsw.php";
                HashMap<String,String> params = new HashMap<>();
                params.put("E_MAIL",edt_email.getText().toString());


                volley.CallVolley(url,params,"forgotpsw.php");



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

    @Override
    public void getData(JSONObject jsonObject, String tag) {

    }
}
