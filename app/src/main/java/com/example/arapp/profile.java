package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arapp.utils.Commonfunction;
import com.example.arapp.utils.Constants;
import com.example.arapp.utils.DataInterface;
import com.example.arapp.utils.Webservice_Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class profile extends AppCompatActivity implements DataInterface {



    TextView txt_name,txt_email,txt_address,txt_number;
    Button btn_edit;

    Webservice_Volley volley;

    JSONObject data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txt_name=(TextView)findViewById(R.id.txt_name);
        txt_email=(TextView)findViewById(R.id.txt_email);
        txt_number=(TextView)findViewById(R.id.txt_number);
        txt_address=(TextView)findViewById(R.id.txt_address);
        btn_edit=(Button)findViewById(R.id.btn_edit);


        volley=new Webservice_Volley(this,this);
        String url = Constants.Webserive_Url+"getprofile.php";
        HashMap<String,String> params = new HashMap<>();
        params.put("CLIENT_ID","2");


        volley.CallVolley(url,params,"getprofile.php");


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(data != null) {

                    Intent i=new Intent(profile.this,edit.class);
                    i.putExtra("data",data.toString());
                    startActivity(i);

                }


            }
        });

    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        try {

            JSONArray jsonresult = jsonObject.getJSONArray("result");

            if (jsonresult.length() > 0){

                data = jsonresult.getJSONObject(0);

                if (data != null){

                    txt_name.setText(data.getString("F_NAME") + " " +data.getString("L_NAME"));
                    txt_email.setText(data.getString("E_MAIL"));
                    txt_address.setText(data.getString("ADDRESS"));
                }

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
