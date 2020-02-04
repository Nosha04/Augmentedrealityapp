package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;
import com.example.arapp.utils.DataInterface;
import com.example.arapp.utils.Webservice_Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class edit extends AppCompatActivity implements DataInterface {


    EditText edt_firstname,edt_lastname,edt_address,edt_email,edt_phone;
    Button btn_update;

    Webservice_Volley volley;

    JSONObject jsondata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        edt_firstname = (EditText) findViewById(R.id.edt_firstname);
        edt_lastname = (EditText) findViewById(R.id.edt_lastname);
        edt_address = (EditText) findViewById(R.id.edt_address);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_phone =(EditText) findViewById(R.id.edt_phone);
        btn_update = (Button) findViewById(R.id.btn_update);

        volley = new Webservice_Volley(this, this);


        try {
            jsondata = new JSONObject(getIntent().getStringExtra("data"));

            if (jsondata != null) {

                edt_firstname.setText(jsondata.getString("F_NAME"));
                edt_lastname.setText(jsondata.getString("L_NAME"));
                edt_email.setText(jsondata.getString("E_MAIL"));
                edt_address.setText(jsondata.getString("ADDRESS"));
                edt_phone.setText(jsondata.getString("PHONE"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Commonfunction.checkString(edt_email.getText().toString())) {
                    edt_email.setError("please enter E-mail");
                    return;
                }

                if (!Commonfunction.checkEmail(edt_email.getText().toString())) {
                    edt_email.setError("please enter valid E-mail");
                    return;
                }


                if (!Commonfunction.checkString(edt_firstname.getText().toString())) {
                    edt_firstname.setError("Enter Firstname");
                    return;
                }

                if (!Commonfunction.checkString(edt_lastname.getText().toString())) {
                    edt_lastname.setError("Enter lastname");
                    return;
                }



                if (!Commonfunction.checkString(edt_address.getText().toString())) {
                    edt_address.setError("please enter E-mail");
                    return;
                }




                if (!Commonfunction.checkMobileNo(edt_phone.getText().toString())) {
                    edt_phone.setError("please enter phonenumber");
                    return;
                }







                String url = Constants.Webserive_Url + "updateprofile.php";
                HashMap<String, String> params = new HashMap<>();
                params.put("E_MAIL", edt_email.getText().toString());
                params.put("CLIENT_ID","2");

                params.put("F_NAME",edt_firstname.getText().toString());
                params.put("L_NAME",edt_lastname.getText().toString());
                params.put("ADDRESS",edt_address.getText().toString());
                params.put("PHONE",edt_phone.getText().toString());



                volley.CallVolley(url, params, "updateprofile.php");

            }

        });



    }    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

    }
}
