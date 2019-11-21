package com.example.hp.investosurestart;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 5/11/2018.
 */

public class JsonData {
    public JsonData(Context mcontext) {
        this.mcontext = mcontext;
    }

    Context mcontext;
    ArrayList<List> tableList=new ArrayList<>();
    public void getJSon1_titledata(Context context){
String[] strings=new String[3];
        try { String resource = AssetJSONFile("feed.json",mcontext);
            JSONArray jsonobject=new JSONArray(resource);

            for(int i=0;i<jsonobject.length();i++){
                JSONObject object=jsonobject.getJSONObject(0);
                JSONArray array=object.getJSONArray("data");

                List<List> rowList = new ArrayList<>();

                for (int k=1;k<array.length();k++) {
                    JSONArray fine=array.getJSONArray(k);

                    List<String> dataList = new ArrayList<>();
                    for (int t=0;t<fine.length();t++) {
                        dataList.add(fine.getString(t));
                    }
                    rowList.add(dataList);
                }
                tableList.add(rowList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public int getJSondetailsdata(Context context,String string){
     //   ArrayList<String> strings=new ArrayList<>();
               int n=0;
        int i;
        String s=null;

        try {
            String resource = AssetJSONFile("feed2.json",context);

            JSONArray jsonobject=new JSONArray(resource);
            Toast.makeText(context,""+ string,Toast.LENGTH_SHORT).show();

            for(i=0;i<jsonobject.length();i++){
              JSONObject object=jsonobject.getJSONObject(i);
               s=object.getString("name");
if(s.contains(string)){

    n=i;
    break;
}


               }
            if(i==jsonobject.length()){
                n=jsonobject.length();
            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(context,""+s,Toast.LENGTH_SHORT).show();
return n;

    }
    public ArrayList<String> getJSonalldata(int a,Context context){
        ArrayList<String> strings=new ArrayList<>();



        try {
            String resource = AssetJSONFile("feed3.json",context);
            JSONArray jsonobject=new JSONArray(resource);

                if(a==0){
                    for(int i=0;i<jsonobject.length();i++){
                        JSONObject object=jsonobject.getJSONObject(i);
                        String s=object.getString("category");
                if(s.contains("Equity")){
                    s=object.getString("name");
                    strings.add(s);
                }
                    }
                    return strings;
                }

                    if(a==1) {
                        for(int i=0;i<jsonobject.length();i++){
                            JSONObject object=jsonobject.getJSONObject(i);
                            String s=object.getString("category");

                            if(s.contains("Debt")){
                                s=object.getString("name");
                            strings.add(s);}

                        }
                        return strings;
                    }
                    if(a==2) {

                        for(int i=0;i<jsonobject.length();i++){
                            JSONObject object=jsonobject.getJSONObject(i);
                            String s=object.getString("category");

                        if(s.contains("Hybrid")){
                        s=object.getString("name");
                        strings.add(s);}

                    }
                        return strings;

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return strings;

    }
    public static String AssetJSONFile (String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }
    public ArrayList<String> holding_sector(int n,Context context)  {
        ArrayList<String> Holding_sector=new ArrayList<>();
        try {String resource = AssetJSONFile("feed2.json",context);
            JSONArray jsonobject=new JSONArray(resource);
            JSONObject object=jsonobject.getJSONObject(n);
            JSONArray jsonArray=object.getJSONArray("sectors");
            for(int i=0;i<jsonArray.length();i++){
                String s=jsonArray.getString(i);
                Holding_sector.add(s);



            }



        }

        catch (IOException e) {
            e.printStackTrace();}
        catch (JSONException e) {
            e.printStackTrace();
        }


        return Holding_sector;
    }
    public ArrayList<String> holding_data(int n,Context context) {
        ArrayList<String> Holding_data=new ArrayList<>();
        try {

            String resource = AssetJSONFile("feed2.json",context);
            JSONArray jsonobject=new JSONArray(resource);
            JSONObject object=jsonobject.getJSONObject(n);
            JSONArray jsonArray=object.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                String s=jsonArray.getString(i);
                Holding_data.add(s);



            }



        }
        catch (IOException e) {
            e.printStackTrace();}

        catch (JSONException e) {
            e.printStackTrace();
        }


        return Holding_data;
    }
}
