package com.example.hp.investosurestart;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Compair_in_detail extends AppCompatActivity {
    TextView t_risk1,t_risk2,t_type1,t_type2,t_rating1,t_rating2,t_sd1,t_sd2,t_er1,t_er2,t_aum1,t_aum2,t_sr1,t_sr2,t_beta1,t_beta2,t_fund1,t_fund2;
    ArrayList<String> Holding_sectors_name_1,Holding_sectors_sector_1,Holding_sectors_percentage_1,Holding_sectors_name_2,Holding_sectors_sector_2,Holding_sectors_percentage_2;
    ArrayList<String> data_sector_1=new ArrayList<>();
    ArrayList<String> name_sector_1=new ArrayList<>();
    ArrayList<String> data_sector_2=new ArrayList<>();
    ArrayList<String> name_sector_2=new ArrayList<>();

    ArrayList<String> Sector_data_percentage;
    ArrayList<String> nav_data_time_1=new ArrayList<>();
    ArrayList<String> nav_data_percentage_1=new ArrayList<>();
    ArrayList<String> nav_data_time_2=new ArrayList<>();
    ArrayList<String> nav_data_percentage_2=new ArrayList<>();
    Bundle bundle_fund1,bundle_fund2,bundle_fund3;
    FragmentManager manager=getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compair_in_detail);
        t_sd1= (TextView) findViewById(R.id.sd1);
        t_sd2= (TextView) findViewById(R.id.sd2);
        t_er1= (TextView) findViewById(R.id.er1);
        t_er2= (TextView) findViewById(R.id.er1);
        t_sr1= (TextView) findViewById(R.id.sr1);
        t_sr2= (TextView) findViewById(R.id.sr1);
        t_beta1= (TextView) findViewById(R.id.beta1);
        t_beta2= (TextView) findViewById(R.id.beta1);

        t_fund1= (TextView) findViewById(R.id.fund1_name);
        t_fund2= (TextView) findViewById(R.id.fund2_name);
        t_aum1= (TextView) findViewById(R.id.aum1);
        t_aum2= (TextView) findViewById(R.id.aum2);
        t_risk1= (TextView) findViewById(R.id.risk1);
        t_risk2= (TextView) findViewById(R.id.risk2);
        t_type1= (TextView) findViewById(R.id.type1);
        t_type2= (TextView) findViewById(R.id.type2);
        t_rating1= (TextView) findViewById(R.id.rating1);
        t_rating2= (TextView) findViewById(R.id.rating2);

        Holding_sectors_name_1=new ArrayList<>();
        Holding_sectors_sector_1=new ArrayList<>();
        Holding_sectors_percentage_1=new ArrayList<>();
        Holding_sectors_name_2=new ArrayList<>();
        Holding_sectors_sector_2=new ArrayList<>();
        Holding_sectors_percentage_2=new ArrayList<>();
        bundle_fund1=new Bundle();
        bundle_fund2=new Bundle();
        bundle_fund3=new Bundle();


        String fund1=getIntent().getStringExtra("fund1");
        String fund2=getIntent().getStringExtra("fund2");
        Toast.makeText(Compair_in_detail.this,"yes_"+fund1,Toast.LENGTH_SHORT).show();
        Toast.makeText(Compair_in_detail.this,"yes_"+fund2,Toast.LENGTH_SHORT).show();
        getdata_fund1(""+fund1);
        getdata_fund2(""+fund2);




    }
  public void  getdata_fund1(String s){
        String Url="";
        String[] arr = s.split(" ");
        int l=arr.length;
        int i=0;
        for ( String ss : arr) {
            if(i==l-1){
                Url=Url+ss;
                break;
            }
            Url=Url+ss+"%20";
            i++;

        }
        String url="http://investosure.com/fund_data/"+Url;

        // Toast.makeText(Mutual_details.this,""+url2,Toast.LENGTH_SHORT).show();
        final RequestQueue queue = Volley.newRequestQueue(Compair_in_detail.this);

        //  Toast.makeText(Mutual_details.this,""+url,Toast.LENGTH_SHORT).show();








        final StringRequest jsonRequest = new StringRequest(Request.Method.GET, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // Toast.makeText(Compair_in_detail.this,""+response,Toast.LENGTH_SHORT).show();

                JSONObject new_object = null;
                try {
                    new_object = new JSONObject(response);

                    JSONObject object = new_object.getJSONObject("fund");
                    // Toast.makeText(Mutual_details.this,""+object,Toast.LENGTH_SHORT).show();
                    String manager1=object.getString("manager");
                    String riskometer1=object.getString("riskometer");
                    String launch_date1=object.getString("launch_date");
                    String sharpe1=object.getString("sharpe");
                    t_sr1.setText(sharpe1);
                    String objective1=object.getString("objective");
                    String benchmark_name1=object.getString("benchmark_name");
                    String exit_load1=object.getString("exit_load");

                    String beta1=object.getString("beta");
                    t_beta1.setText(beta1);
                    String mean_val1=object.getString("mean_val");
                    String assets1=object.getString("assets");
                    String stddev1=object.getString("stddev");
                    t_sd1.setText(stddev1);
                    String expense1=object.getString("expense");
                    t_er1.setText(expense1);
                    String name1=object.getString("name");
                    t_fund1.setText(name1);
                    String type1=object.getString("ty");
                    t_type1.setText(type1);
                    String rating1=object.getString("rating");
                    t_rating1.setText(rating1);
                    String nav1=object.getString("nav");
                    String value1=object.getString("value");
                    String risk1=object.getString("risk");
                    t_risk1.setText(risk1);


                    JSONArray holdingrarray = object.getJSONArray("holdings_data");
                    JSONArray msector_data = object.getJSONArray("sector_data");
                    //    Toast.makeText(Mutual_details.this,""+msector_data,Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < msector_data.length(); i++) {
                        JSONArray sec_array = msector_data.getJSONArray(i);
                        name_sector_1.add(sec_array.getString(0));
                        data_sector_1.add("" + sec_array.getDouble(1));

                    }
                    bundle_fund3.putStringArrayList("name_sector1", name_sector_1);
                    bundle_fund3.putStringArrayList("data_sector1", data_sector_1);


                    // Toast.makeText(Mutual_details.this,""+data_sector.get(0),Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < holdingrarray.length(); i++) {
                        JSONArray jsonArray = holdingrarray.getJSONArray(i);

                        Holding_sectors_name_1.add(jsonArray.getString(0));
                        Holding_sectors_sector_1.add(jsonArray.getString(1));
                        Holding_sectors_percentage_1.add(jsonArray.getString(2));

                    }
                    bundle_fund2.putStringArrayList("Holding_sectors_name1", Holding_sectors_name_1);
                    bundle_fund2.putStringArrayList("Holding_sectors_sector1", Holding_sectors_sector_1);
                    bundle_fund2.putStringArrayList("Holding_sectors_percentage1", Holding_sectors_percentage_1);

                    JSONArray nav_dataarray = object.getJSONArray("nav_data");
                    // Toast.makeText(Mutual_details.this,""+nav_dataarray,Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < nav_dataarray.length(); i++) {
                        JSONArray jsonArray2 = nav_dataarray.getJSONArray(i);

                        nav_data_time_1.add("" + (jsonArray2.getLong(0)));
                        nav_data_percentage_1.add("" + jsonArray2.getDouble(1));


                    }
                    Toast.makeText(Compair_in_detail.this, "" + nav_data_time_1.get(0).toString(), Toast.LENGTH_SHORT).show();
                    bundle_fund1.putStringArrayList("time1", nav_data_time_1);
                    bundle_fund1.putStringArrayList("percentage1", nav_data_percentage_1);
                    //  Toast.makeText(Mutual_details.this,""+nav_data_time.get(0),Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Compair_in_detail.this, "check internet connection", Toast.LENGTH_SHORT).show();


            }
        });


// Add the request to the RequestQueue.
        queue.add(jsonRequest);

    }
    public void  getdata_fund2(String s){
        String Url="";
        String[] arr = s.split(" ");
        int l=arr.length;
        int i=0;
        for ( String ss : arr) {
            if(i==l-1){
                Url=Url+ss;
                break;
            }
            Url=Url+ss+"%20";
            i++;

        }
        String url="http://investosure.com/fund_data/"+Url;
        String url2="http://investosure.com/fund_data/Aditya%20Birla%20Sun%20Life%20Active%20Debt%20Multi-Manager%20FoF%20Scheme";
        if(url2.contentEquals(url)){
            // Toast.makeText(Mutual_details.this,"correct",Toast.LENGTH_SHORT).show();
        }
        // Toast.makeText(Mutual_details.this,""+url2,Toast.LENGTH_SHORT).show();
        final RequestQueue queue = Volley.newRequestQueue(Compair_in_detail.this);

        //  Toast.makeText(Mutual_details.this,""+url,Toast.LENGTH_SHORT).show();








        final StringRequest jsonRequest = new StringRequest(Request.Method.GET, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject new_object=new JSONObject(response);
                    JSONObject object=new_object.getJSONObject("fund");
                    // Toast.makeText(Mutual_details.this,""+object,Toast.LENGTH_SHORT).show();

                    String riskometer2=object.getString("riskometer");
                    String launch_date2=object.getString("launch_date");
                    String sharpe2=object.getString("sharpe");
                    t_sr2.setText(sharpe2);
                    String objective2=object.getString("objective");
                    String benchmark_name2=object.getString("benchmark_name");
                    String exit_load2=object.getString("exit_load");
                    String beta2=object.getString("beta");
                    t_beta2.setText(beta2);
                    String mean_val2=object.getString("mean_val");
                    String assets2=object.getString("assets");
                    String stddev2=object.getString("stddev");
                    t_sd2.setText(stddev2);
                    String expense2=object.getString("expense");
                    t_er2.setText(expense2);
                    String name2=object.getString("name");
                    t_fund2.setText(name2);
                    String type2=object.getString("ty");
                    t_type2.setText(type2);
                    String rating2=object.getString("rating");
                    t_rating2.setText(rating2);
                    String nav2=object.getString("nav");
                    String value2=object.getString("value");
                    String risk2=object.getString("risk");
                    t_risk2.setText(risk2);
                    JSONArray holdingrarray=object.getJSONArray("holdings_data");
                    JSONArray msector_data=object.getJSONArray("sector_data");
                    //    Toast.makeText(Mutual_details.this,""+msector_data,Toast.LENGTH_SHORT).show();
                    for(int i=0;i<msector_data.length();i++) {
                        JSONArray sec_array=msector_data.getJSONArray(i);
                        name_sector_2.add(sec_array.getString(0));
                        data_sector_2.add(""+sec_array.getDouble(1));

                    }
                    bundle_fund3.putStringArrayList("name_sector2", name_sector_2);
                    bundle_fund3.putStringArrayList("data_sector2", data_sector_2);


                    // Toast.makeText(Mutual_details.this,""+data_sector.get(0),Toast.LENGTH_SHORT).show();
                    for(int i=0;i<holdingrarray.length();i++){
                        JSONArray jsonArray=holdingrarray.getJSONArray(i);

                        Holding_sectors_name_2.add(jsonArray.getString(0));
                        Holding_sectors_sector_2.add(jsonArray.getString(1));
                        Holding_sectors_percentage_2.add(jsonArray.getString(2));

                    }
                    bundle_fund2.putStringArrayList("Holding_sectors_name2", Holding_sectors_name_2);
                    bundle_fund2.putStringArrayList("Holding_sectors_sector2", Holding_sectors_sector_2);
                    bundle_fund2.putStringArrayList("Holding_sectors_percentage2", Holding_sectors_percentage_2);

                    JSONArray nav_dataarray=object.getJSONArray("nav_data");
                    // Toast.makeText(Mutual_details.this,""+nav_dataarray,Toast.LENGTH_SHORT).show();
                    for(int i=0;i<nav_dataarray.length();i++){
                        JSONArray jsonArray2=nav_dataarray.getJSONArray(i);

                        nav_data_time_2.add(""+(jsonArray2.getLong(0)));
                        nav_data_percentage_2.add(""+jsonArray2.getDouble(1));


                    }
                    Toast.makeText(Compair_in_detail.this, ""+nav_data_time_2.get(0).toString(), Toast.LENGTH_SHORT).show();
                    bundle_fund1.putStringArrayList("time2",nav_data_time_2);
                    bundle_fund1.putStringArrayList("percentage2",nav_data_percentage_2);
                    //  Toast.makeText(Mutual_details.this,""+nav_data_time.get(0),Toast.LENGTH_SHORT).show();
                    Double_graph_frag double_graph_frag=new Double_graph_frag();
                     double_graph_frag.setArguments(bundle_fund1);
                    FragmentTransaction transaction2=manager.beginTransaction();
                    transaction2.add(R.id.compair_graph_layout,double_graph_frag,"2");
                    transaction2.commit();
                    Double_piechart_frag double_piechart_frag=new Double_piechart_frag();
                    double_piechart_frag.setArguments(bundle_fund3);
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.add(R.id.compair_pie_chart_layout,double_piechart_frag,"1");
                    transaction.commit();


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Compair_in_detail.this,"check internet connection",Toast.LENGTH_SHORT).show();


            }

        });


// Add the request to the RequestQueue.
        queue.add(jsonRequest);

    }
}
