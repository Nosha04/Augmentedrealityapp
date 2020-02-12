package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;

import org.json.JSONObject;

import java.util.HashMap;

public class builderSignup extends AppCompatActivity {

    EditText edt_firstname,edt_lastname,edt_address,edt_email,edt_password,edt_phone,edt_companyname,edt_city,edt_website;
    Button btn_signup;
    TextView txt_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder_signup);

        edt_firstname = (EditText) findViewById(R.id.edt_firstname);
        edt_lastname = (EditText) findViewById(R.id.edt_lastname);
        edt_address = (EditText) findViewById(R.id.edt_address);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        txt_signup = (TextView) findViewById(R.id.txt_signup);
        edt_phone = (EditText) findViewById(R.id.edt_phone);
        edt_companyname = (EditText) findViewById(R.id.edt_companyname);
        edt_city = (EditText) findViewById(R.id.edt_city);
        edt_website = (EditText) findViewById(R.id.edt_website);


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

                if (!Commonfunction.checkMobileNo(edt_phone.getText().toString())) {
                    edt_phone.setError("please enter phonenumber");
                    return;
                }

                if (!Commonfunction.checkString(edt_companyname.getText().toString())) {
                    edt_companyname.setError("Enter Companyname");
                    return;
                }

                if (!Commonfunction.checkString(edt_city.getText().toString())) {
                    edt_city.setError("Enter City");
                    return;
                }

                if (!Commonfunction.checkString(edt_website.getText().toString())) {
                    edt_website.setError("Enter Website");
                    return;
                }



                String url = Constants.Webserive_Url+"builderregistration.php";
                HashMap<String,String> params = new HashMap<>();
                params.put("BUILDER_FNAME",edt_firstname.getText().toString());
                params.put("BUILDER_LNAME",edt_lastname.getText().toString());
                params.put("ADDRESS",edt_address.getText().toString());
                params.put("B_EMAIL_ID",edt_email.getText().toString());
                params.put("PASSWORD",edt_password.getText().toString());
                params.put("B_CONTACT_NO",edt_phone.getText().toString());
                params.put("CITY",edt_city.getText().toString());
                params.put("COMPANY_NAME",edt_companyname.getText().toString());
                params.put("B_WEBSITE",edt_website.getText().toString());



            }
        });
    }

  /*  @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

    }*/
}




//


