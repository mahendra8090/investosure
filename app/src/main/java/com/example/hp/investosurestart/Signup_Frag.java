package com.example.hp.investosurestart;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
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

/**
 * Created by hp on 4/9/2018.
 */

public class Signup_Frag extends Fragment implements View.OnClickListener{
    EditText s_firstName,s_lastname,s_username,s_email,s_mobile,s_state,s_password1,s_password2;
    String str_firstName,str_lastname,str_username,str_email,str_mobile,str_state,str_password1,str_password2;
    public   HashMap<String, String> data;
    String url;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signup_layout,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        s_firstName = (EditText) getActivity().findViewById(R.id.first_name_signup);
        s_lastname = (EditText) getActivity().findViewById(R.id.last_name_signup);
        s_username = (EditText) getActivity().findViewById(R.id.user_name_signup);
        s_email = (EditText) getActivity().findViewById(R.id.email_signup);
        s_mobile = (EditText) getActivity().findViewById(R.id.mobile_signup);
        s_state = (EditText) getActivity().findViewById(R.id.state_signup);
        s_password1 = (EditText) getActivity().findViewById(R.id.password1_signup);
        s_password2 = (EditText) getActivity().findViewById(R.id.password2_signup);
    }
    public void VolleyR(HashMap<String, String> data, String Urlf) {


        RequestQueue queue = Volley.newRequestQueue(getActivity());

        JSONObject urlf = new JSONObject(data);


        final JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST, url, urlf,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response

                        // For a given earthquake, extract the JSONObject associated with the
                        // key called "properties", which represents a list of all properties
                        // for that earthquake.

                        try {
                            Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                            JSONArray jsonArray = response.getJSONArray("");

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


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




    @Override
    public void onClick(View v) {
        str_firstName=s_firstName.getText().toString();
        str_lastname=s_lastname.getText().toString();
        str_email=s_email.getText().toString();
        str_username=s_username.getText().toString();
        str_mobile=s_mobile.getText().toString();
        str_state=s_state.getText().toString();
        str_password1=s_password1.getText().toString();
        str_password2=s_password2.getText().toString();
        data = new HashMap<String, String>();
        data.put("first_name",str_firstName);
        data.put("last_name",str_lastname);
        data.put("username",str_username);
        data.put("email",str_email);
        data.put("mobile",str_mobile);
        data.put("state",str_state);
        data.put("password1",str_password1);
        data.put("password2",str_password2);

        VolleyR(data, url);
    }

}
