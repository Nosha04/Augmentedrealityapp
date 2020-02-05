package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;
import com.example.arapp.utils.DataInterface;
import com.example.arapp.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements DataInterface {

    EditText edt_firstname,edt_lastname,edt_address,edt_email,edt_password,edt_age,edt_phone;
    RadioButton btn_male,btn_female;
    Button btn_signup;
    TextView txt_signup;
    RadioGroup rg_gender;

    Webservice_Volley volley;


    String gender="";
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
        edt_phone=(EditText)findViewById(R.id.edt_phone);


        rg_gender=(RadioGroup)findViewById(R.id.rg_gender);

        volley = new Webservice_Volley(this,this);

        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=(RadioButton)findViewById(checkedId);
                gender= rb.getText().toString();

            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
                {

                if (!Commonfunction.checkString(edt_firstname.getText().toString())) {
                    edt_firstname.setError("Enter Firstname");
                    return;
                }

                if (!Commonfunction.checkString(edt_lastname.getText().toString())) {
                    edt_lastname.setError("Enter lastname");
                    return;
                }


                /* (!Commonfunction.checkString(edt_age.getText().toString())) {
                    edt_age.setError("Enter your age");
                    return;
                }*/

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

                if (!Commonfunction.checkString(gender))
                {
                    Toast.makeText(MainActivity.this, "Please select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }


                String url = Constants.Webserive_Url+"registration.php";
                HashMap<String,String> params = new HashMap<>();
                params.put("F_NAME",edt_firstname.getText().toString());
                params.put("L_NAME",edt_lastname.getText().toString());
                params.put("ADDRESS",edt_address.getText().toString());
                params.put("E_MAIL",edt_email.getText().toString());
                params.put("PASSWORD",edt_password.getText().toString());
//                params.put("AGE",edt_age.getText().toString());
                params.put("AGE","0");
                params.put("CLIENT_PIC","");
                params.put("GENDER",gender);
                params.put("PHONE",edt_phone.getText().toString());

                volley.CallVolley(url,params,"registration.php");



            }
        });
            }

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

    }
}
