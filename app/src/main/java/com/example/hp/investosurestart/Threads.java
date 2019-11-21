package com.example.hp.investosurestart;

import android.content.Context;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Threads extends Thread{
     private Context mcontext;
     public Threads(Context context) {
         mcontext=context;
     }


     @Override
     public void run() {
        // super.run();
         connect();
     }

     public  void connect()
   {

       HttpClient httpclient = new DefaultHttpClient();

       // Prepare a request object
       HttpGet httpget = new HttpGet("http://www.investosure.com/login");

       // Execute the request
       HttpResponse response;
       try {
           response = httpclient.execute(httpget);
           Toast.makeText(mcontext,""+response,Toast.LENGTH_LONG).show();
           // Examine the response status
          // Log.i("Praeda",response.getStatusLine().toString());

           // Get hold of the response entity
        /*   HttpEntity entity = response.getEntity();
           // If the response does not enclose an entity, there is no need
           // to worry about connection release

           if (entity != null) {

               // A Simple JSON Response Read
               InputStream instream = entity.getContent();
               String result= convertStreamToString(instream);
               // now you have the string representation of the HTML request
               instream.close();*/



       } catch (Exception e) {
           Toast.makeText(mcontext,"error  "+e,Toast.LENGTH_LONG).show();
       }
   }
   private static String convertStreamToString(InputStream is) {
   /*
    * To convert the InputStream to String we use the BufferedReader.readLine()
    * method. We iterate until the BufferedReader return null which means
    * there's no more data to read. Each line will appended to a StringBuilder
    * and returned as String.
    */
       BufferedReader reader = new BufferedReader(new InputStreamReader(is));
       StringBuilder sb = new StringBuilder();

       String line = null;
       try {
           while ((line = reader.readLine()) != null) {
               sb.append(line + "\n");
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               is.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return sb.toString();
   }


}
