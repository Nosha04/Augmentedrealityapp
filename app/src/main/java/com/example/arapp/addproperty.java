package com.example.arapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class addproperty extends AppCompatActivity implements DataInterface {


    EditText edt_propertyname,edt_propertytype,edt_description,edt_address,edt_city,edt_price;
    TextView txt_propertyimage;
    Button btn_submit;

    Webservice_Volley volley;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproperty);

        edt_propertyname = (EditText) findViewById(R.id.edt_propertyname);
        edt_propertytype = (EditText) findViewById(R.id.edt_propertytype);
        edt_address = (EditText) findViewById(R.id.edt_address);
        edt_description = (EditText) findViewById(R.id.edt_description);
        edt_city =(EditText) findViewById(R.id.edt_city);
        edt_price =(EditText)findViewById(R.id.edt_price);
        txt_propertyimage =(TextView) findViewById(R.id.txt_propertyimage);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        volley = new Webservice_Volley(this,this);






        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (!Commonfunction.checkString(edt_propertyname.getText().toString())) {
                    edt_propertyname.setError("Enter Property Name");
                    return;
                }

                if (!Commonfunction.checkString(edt_propertytype.getText().toString())) {
                    edt_propertytype.setError("Enter Property Type");
                    return;
                }


                if (!Commonfunction.checkString(edt_address.getText().toString())) {
                    edt_address.setError("please enter Address");
                    return;
                }

                if (!Commonfunction.checkString(edt_description.getText().toString())) {
                    edt_description.setError("please enter Property Description");
                    return;
                }

                if (!Commonfunction.checkString(edt_city.getText().toString())) {
                    edt_city.setError("please enter City");
                    return;
                }




                if (!Commonfunction.checkString(edt_price.getText().toString())) {
                    edt_price.setError("please enter Property Price");
                    return;
                }







                String url = Constants.Webserive_Url + "addproperty.php";
                HashMap<String, String> params = new HashMap<>();
                params.put("PROPERTY_ID", "");
                params.put("BUILDER_ID", "");
                params.put("BUILDER_NAME", "");
                params.put("PROPERTY_NAME", edt_propertyname.getText().toString());
                params.put("PROPERTY_TYPE",edt_propertytype.getText().toString());
                params.put("DESCRIPTION",edt_description.getText().toString());
                params.put("ADDRESS",edt_address.getText().toString());
                params.put("LONGTUDE","");
                params.put("lATITUDE","");
                params.put("CITY",edt_city.getText().toString());
                params.put("PRICE",edt_price.getText().toString());
                params.put("IMAGE","");




                volley.CallVolley(url, params, "addproperty.php");

            }

        });

    }    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();



    }
}
