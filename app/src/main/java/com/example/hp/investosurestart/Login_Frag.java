package com.example.hp.investosurestart;

import android.app.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 4/9/2018.
 */

public class Login_Frag extends Fragment implements View.OnClickListener{
    commu_login commuLog;
    DefaultHttpClient httpClientStatic = new DefaultHttpClient();
    EditText l_username,l_password;
    String l_str_username,l_str_password;
    String url="http://www.investosure.com:8993/login";
    public   HashMap<String, String> data;

   CookieManager myCookieManager;
    CardView b1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.login_layout,container,false);
        return view;}
  /*   }
    public JSONObject loginUser() throws IOException {
        // Building Parameters

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", ""));
        params.add(new BasicNameValuePair("password", ""));
        String csrfmiddlewaretoken = getCsrfFromUrl("http://www.investosure.com:8993/login").toString();
        params.add(new BasicNameValuePair("csrfmiddlewaretoken", csrfmiddlewaretoken));
        JSONObject json =getJSONFromUrl("http://www.investosure.com:8993/login", params);
        return json;
    }
   public JSONObject getJSONFromUrl(String url, List<NameValuePair> params) {

        // Making HTTP GET request to get csrfmiddlewaretoken:
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            Log.e("JSON", "In login user 02.4");
            HttpResponse httpResponse = httpClientStatic.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
          //  is = httpEntity.getContent();
          //  .....
            //Next is read respone, and return json type
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return
    }*/

    public String getCsrfFromUrl(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);

        HttpResponse httpResponse = httpClientStatic.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
      //  is = httpEntity.getContent();
        List<Cookie> cookies = httpClientStatic.getCookieStore().getCookies();
        if (cookies.isEmpty()) {
            Log.e("COOKIES GET ",  "Empty Cookies");
        } else {
            for (int i = 0; i < cookies.size(); i++) {
                Log.e("COOKIES GET ",  cookies.get(i).getName()+"--"+cookies.get(i).getValue());
            }
        }
        return cookies.get(0).getValue();
    }



   @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       commuLog= (commu_login) getActivity();
       myCookieManager = new CookieManager();
        b1=(CardView) getActivity().findViewById(R.id.button_login);
       b1.setOnClickListener(this);


   }
    public void VolleyR(HashMap<String, String> data, String Urlf) {

        Toast.makeText(getActivity(),"in vooly",Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        JSONObject urlf = new JSONObject(data);


        final JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST,"http://www.investosure.com/login", urlf,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        Toast.makeText(getActivity(),"in responce",Toast.LENGTH_SHORT).show();
                        // For a given earthquake, extract the JSONObject associated with the
                        // key called "properties", which represents a list of all properties
                        // for that earthquake.

                        try {
                            Toast.makeText(getActivity(), ""+response, Toast.LENGTH_SHORT).show();
                            JSONArray jsonArray = response.getJSONArray("");

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"volly error   "+error,Toast.LENGTH_SHORT).show();

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
    public void onClick(View view) {



    }
    public String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        Toast.makeText(getActivity(),"work",Toast.LENGTH_SHORT).show();
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public void postData() {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("id", "12345"));
            nameValuePairs.add(new BasicNameValuePair("stringdata", "Hi"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }}


//   Toast.makeText(getActivity(),"login clicked",Toast.LENGTH_SHORT).show();
     // commuLog.respond_login();
       // l_str_username=l_username.getText().toString();
       // l_str_password=l_password.getText().toString();
     /*  data = new HashMap<String, String>();

       data.put("username","gothia");

        data.put("password","gothiache14");
        data.put("csrfmiddlewaretoken","4VbXvYaj2sx3LELZlgPZ4PCLdBQzZQWSa2PXMef98EorHyAwJjrk2c2Z59OEZ926");

      VolleyR(data, url);*/


/*
    final RequestQueue queue = Volley.newRequestQueue(getActivity());






        final StringRequest jsonRequest = new StringRequest(Request.Method.GET, "http://www.investosure.com:8993/login", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                CookieManager manager = new CookieManager();
                try {
                    Toast.makeText(getActivity(),""+manager.getCookieStore().get(new URI("http://www.investosure.com:8993/login")).toString(),Toast.LENGTH_SHORT).show();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getActivity(),"getting",Toast.LENGTH_SHORT).show();
                CookieHandler.setDefault(manager);
              String s=  manager.getCookieStore().getCookies().toString();

            }





                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),""+error,Toast.LENGTH_SHORT).show();


                    }

                });


// Add the request to the RequestQueue.
        queue.add(jsonRequest);



    }*/








