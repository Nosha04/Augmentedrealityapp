package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;
import com.example.arapp.utils.DataInterface;
import com.example.arapp.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class ResetPassword extends AppCompatActivity implements DataInterface {

    TextView txt_resetpassword;
    EditText edt_newpassword,edt_confirmpassword;
    Button btn_confirm;

    Webservice_Volley volley;

    String id ="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        btn_confirm=(Button)findViewById(R.id.btn_confirm);
        txt_resetpassword=(TextView)findViewById(R.id.txt_resetpassword);
        edt_newpassword=(EditText)findViewById(R.id.edt_newpassword);
        edt_confirmpassword=(EditText)findViewById(R.id.edt_confirmpassword);

        id = getIntent().getStringExtra("id");

        volley = new Webservice_Volley(this,this);


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


                String url = Constants.Webserive_Url+"resetpsw.php";
                HashMap<String,String> params = new HashMap<>();
                params.put("PASSWORD",edt_newpassword.getText().toString());
                params.put("CLIENT_ID",id);


                volley.CallVolley(url,params,"resetpsw.php");




            }
        });




            }

    @Override
    public void getData(JSONObject jsonObject, String tag) {

        try {

            Toast.makeText(this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();

            if (jsonObject.getString("response").equalsIgnoreCase("1")) {

                Intent i = new Intent(ResetPassword.this,LoginActivity.class);
                startActivity(i);

                finishAffinity();

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
