package com.example.hp.investosurestart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Call_activity extends AppCompatActivity {
EditText mobile;
    Button btn,testing_layout;
    LinearLayout linearLayout;
    HashMap data;
    String s=null;
    Boolean t=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_request_activity);
        mobile=(EditText)findViewById(R.id.mobile_no);
        testing_layout=(Button)findViewById(R.id.layout_text);
        linearLayout=(LinearLayout)findViewById(R.id.testing_lay);
        linearLayout.setVisibility(View.INVISIBLE);

        btn=(Button)findViewById(R.id.call_me_btn);
        data=new HashMap();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 s=mobile.getText().toString();
                if(s==null){
                    Toast.makeText(Call_activity.this,"fill your mobile no",Toast.LENGTH_LONG).show();
                }
                else
                {
                    data.put("number",""+s);
                    data.put("reason","portfolio");

                    VolleyR(data,"http://www.investosure.com/request_callback");
                }
            }
        });

    }
    public void VolleyR(HashMap<String, String> data, String Urlf) {

       // Toast.makeText(getActivity(),"in vooly",Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(Call_activity.this);

        JSONObject urlf = new JSONObject(data);


        final JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST,"http://www.investosure.com/request_callback", urlf,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                           Toast.makeText(Call_activity.this, ""+response, Toast.LENGTH_SHORT).show();
                          JSONArray jsonArray = response.getJSONArray("");
                            btn.setText("soon");

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Toast.makeText(Call_activity.this,"volly error   "+error,Toast.LENGTH_SHORT).show();

                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                return params;
            }


        };


        queue.add(putRequest);


    }

public  void clicked(View v){
    if(t==true){
        linearLayout.setVisibility(View.INVISIBLE);

        t=false;
    }
    else{
        linearLayout.setVisibility(View.VISIBLE);
        t=true;
    }


}
}
