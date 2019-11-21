package com.example.hp.investosurestart;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
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
import java.util.List;

import static android.R.id.list;
import static android.media.CamcorderProfile.get;

public class Mutual_details extends AppCompatActivity {
    int a;
    String s,s2;
Boolean holding_show=true;
    Boolean details_show=true;
    Boolean detail_show=true;
    Boolean Economic_Measures_show=true;
    Boolean Statistical_Measures_show=true;
    ImageView holding_expand,details_expand,detail_expand,Statistical_expand,Economic_expand;
    ArrayList<String>  Holding_sectors_name,Holding_sectors_sector,Holding_sectors_percentage,Sector_data_name;
    ArrayList<String> data_sector=new ArrayList<>();
    ArrayList<String> name_sector=new ArrayList<>();

    ArrayList<String> Sector_data_percentage;
    ArrayList<String> nav_data_time=new ArrayList<>();
    ArrayList<String> nav_data_percentage=new ArrayList<>();
    ArrayList<String> bench_data_time=new ArrayList<>();
    ArrayList<String> bench_data_percentage=new ArrayList<>();
    Bundle bundle;
    Bundle bundle2;
    Bundle bundle3;
    Bundle bundle4;
    ProgressDialog progressDialog;




   // ArrayList<List> mtableList = new ArrayList<>();
    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentManager fragmentManager2=getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_details);

       progressDialog = new ProgressDialog(Mutual_details.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
     progressDialog.show();
        Bundle b1=new Bundle();
        b1=getIntent().getExtras();
        a=b1.getInt("fragment_no");
      Holding_sectors_name=new ArrayList<>();
        Holding_sectors_sector=new ArrayList<>();
        Holding_sectors_percentage=new ArrayList<>();
        Sector_data_name=new ArrayList<>();
        bundle2=new Bundle();
        bundle3=new Bundle();
        bundle4=new Bundle();
        Sector_data_percentage=new ArrayList<>();
        holding_expand = (ImageView) findViewById(R.id.holding_expand);
        details_expand = (ImageView) findViewById(R.id.details_expand);
        Economic_expand=(ImageView)findViewById(R.id.Economic_expand);
        Statistical_expand = (ImageView) findViewById(R.id.Statistical_expand);
        detail_expand = (ImageView) findViewById(R.id.detail_expand);
        holding_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
        details_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
         bundle=new Bundle();
          s=getIntent().getStringExtra("fund_name");
        s2=s;
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
        String url="https://investosure.com/fund_data/"+Url;
        String url2="http://investosure.com/fund_data/Aditya%20Birla%20Sun%20Life%20Active%20Debt%20Multi-Manager%20FoF%20Scheme";
        if(url2.contentEquals(url)){
           // Toast.makeText(Mutual_details.this,"correct",Toast.LENGTH_SHORT).show();
        }
        // Toast.makeText(Mutual_details.this,""+url2,Toast.LENGTH_SHORT).show();
        final RequestQueue queue = Volley.newRequestQueue(Mutual_details.this);

          //  Toast.makeText(Mutual_details.this,""+url,Toast.LENGTH_SHORT).show();








        final StringRequest jsonRequest = new StringRequest(Request.Method.GET, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  progressDialog.show();
                progressDialog.dismiss();
                try {
                    JSONObject new_object=new JSONObject(response);
                    JSONObject object=new_object.getJSONObject("fund");
                // Toast.makeText(Mutual_details.this,""+object,Toast.LENGTH_SHORT).show();
                    String manager=object.getString("manager");
                    String riskometer=object.getString("riskometer");
                    String launch_date=object.getString("launch_date");
                    String sharpe=object.getString("sharpe");
                    String objective=object.getString("objective");
                    String benchmark_name=object.getString("benchmark_name");
                    String exit_load=object.getString("exit_load");
                    String beta=object.getString("beta");
                    String mean_val=object.getString("mean_val");
                    String assets=object.getString("assets");
                    String stddev=object.getString("stddev");
                    String expense=object.getString("expense");
                    bundle4.putString("manager",manager);
                    bundle4.putString("riskometer",riskometer);
                    bundle4.putString("launch_date",launch_date);

                    bundle4.putString("objective",objective);


                    bundle4.putString("exit_load",exit_load);
                    bundle4.putString("expense",expense);
                    bundle4.putString("assets",assets);


                    bundle4.putString("mean_val",mean_val);



                    bundle4.putString("stddev",stddev);
                    bundle4.putString("sharpe",sharpe);
                    bundle4.putString("beta",beta);







                    String name=object.getString("name");
                    bundle.putString("name",name);
                    String type=object.getString("ty");
                    bundle.putString("type",type);
                    String rating=object.getString("rating");
                    bundle.putString("rating",rating);

                    String nav=object.getString("nav");
                    String value=object.getString("value");
                    String risk=object.getString("risk");
                    bundle.putString("risk",risk);
                    JSONArray holdingrarray=object.getJSONArray("holdings_data");
                    JSONArray msector_data=object.getJSONArray("sector_data");
            //    Toast.makeText(Mutual_details.this,""+msector_data,Toast.LENGTH_SHORT).show();
                    for(int i=0;i<msector_data.length();i++) {
                    JSONArray sec_array=msector_data.getJSONArray(i);
                       name_sector.add(sec_array.getString(0));
                       data_sector.add(""+sec_array.getDouble(1));

                    }
                    for(int i=0;i<holdingrarray.length()||i<10;i++){
                        JSONArray jsonArray=holdingrarray.getJSONArray(i);

                        Holding_sectors_name.add(jsonArray.getString(0));
                        Holding_sectors_sector.add(jsonArray.getString(1));
                        Holding_sectors_percentage.add(jsonArray.getString(2));

                    }
                    Toast.makeText(Mutual_details.this,"yes it is   "+Holding_sectors_name.get(0).toString(),Toast.LENGTH_SHORT).show();


                    JSONArray nav_dataarray=object.getJSONArray("nav_data");
                    // Toast.makeText(Mutual_details.this,""+nav_dataarray,Toast.LENGTH_SHORT).show();
                    for(int i=0;i<nav_dataarray.length();i++){
                        JSONArray jsonArray2=nav_dataarray.getJSONArray(i);

                        nav_data_time.add(""+(jsonArray2.getLong(0)));
                        nav_data_percentage.add(""+jsonArray2.getDouble(1));


                    }
                    bundle.putStringArrayList("time",nav_data_time);
                    bundle.putStringArrayList("percentage",nav_data_percentage);
                    //  Toast.makeText(Mutual_details.this,""+nav_data_time.get(0),Toast.LENGTH_SHORT).show();
                    Mutual_details_frag mutual_details_frag=new Mutual_details_frag();
                    // mutual_details_frag.setArguments(bundle);
                    mutual_details_frag.setArguments(bundle);
                    FragmentTransaction fragmentTransaction=fragmentManager2.beginTransaction();
                    fragmentTransaction.replace(R.id.graph_layout,mutual_details_frag,"upper_deatils");
                    fragmentTransaction.commit();
                    Toast.makeText(Mutual_details.this,"yes    it is "+nav_data_time.get(0).toString(),Toast.LENGTH_SHORT).show();
                    JSONArray bench_dataarray=object.getJSONArray("benchmark_data");
                    // Toast.makeText(Mutual_details.this,""+nav_dataarray,Toast.LENGTH_SHORT).show();
                    for(int i=0;i<bench_dataarray.length();i++){
                        JSONArray jsonArray2=bench_dataarray.getJSONArray(i);

                        bench_data_time.add(""+(jsonArray2.getLong(0)));
                        bench_data_percentage.add(""+jsonArray2.getDouble(1));


                    }



                   // Toast.makeText(Mutual_details.this,""+data_sector.get(0),Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Mutual_details.this,"check internet connection"+error,Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                finish();

            }

        });


// Add the request to the RequestQueue.
        queue.add(jsonRequest);







       /* JsonData jsonData=new JsonData(this);
        int i=jsonData.getJSondetailsdata(this,s);
        Toast.makeText(Mutual_details.this,""+i,Toast.LENGTH_SHORT).show();

     Holding_sectors=jsonData.holding_sector(i,this);



        Holding_data=jsonData.holding_data(i,this);
       bundle=new Bundle();
        bundle.putStringArrayList("sectors",Holding_sectors);
        bundle.putStringArrayList("data",Holding_data);*/

        // List<List> row=mtableList.get(1);
        //List<String> stringList=row.get(1);
        //String s=stringList.get(1).toString();


        //  Toast.makeText(Mutual_details.this,"00000000    "+s,Toast.LENGTH_SHORT).show();


        // Bundle bundle1 = new Bundle();
        // bundle1.putString("edttext", s);
// set Fragmentclass Arguments





    }



    public void show_holding(View v){
        if(holding_show==true){

                bundle3.putStringArrayList("name_sector", name_sector);
                bundle3.putStringArrayList("data_sector", data_sector);
                holding_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_less_black_24dp));
                Pie_chart_frag pie_chart_frag = new Pie_chart_frag();
                pie_chart_frag.setArguments(bundle3);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.piechart_layout, pie_chart_frag, "piechart");
                transaction.commit();

                holding_show = false;




        }
       else
        { holding_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
            Pie_chart_frag pie_chart_frag= (Pie_chart_frag) fragmentManager.findFragmentByTag("piechart");

            FragmentTransaction transaction1=fragmentManager.beginTransaction();

                transaction1.detach(pie_chart_frag);

                transaction1.commit();
                holding_show=true;




    }
}  public void show_details(View v){
        if(details_show==true){
            bundle2.putStringArrayList("Holding_sectors_name",Holding_sectors_name);
            bundle2.putStringArrayList("Holding_sectors_sector",Holding_sectors_sector);
            bundle2.putStringArrayList("Holding_sectors_percentage",Holding_sectors_percentage);
            details_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_less_black_24dp));
            Detailsofholding mDetailsofholding=new Detailsofholding();
            mDetailsofholding.setArguments(bundle2);
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.add(R.id.mutual_details_layout,mDetailsofholding,"mDetailsofholding");
            transaction.commit();

            details_show=false;



        }
      else
        { details_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
            Detailsofholding mDetailsofholding= (Detailsofholding) fragmentManager.findFragmentByTag("mDetailsofholding");

            FragmentTransaction transaction1=fragmentManager.beginTransaction();

                transaction1.detach(mDetailsofholding);

                transaction1.commit();
                details_show=true;




        }
    }


public void compair_funds(View v){
    Intent i=new Intent(Mutual_details.this,CompairActivity.class);
    i.putExtra("fragment_no",a);
    i.putExtra("fund_name",s2);
    startActivity(i);
}

    public void show_detail(View v){
        if(detail_show==true){

            detail_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_less_black_24dp));
            Details_frag mDetails_frag=new Details_frag();
            mDetails_frag.setArguments(bundle4);
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.add(R.id.mutual_detail_layout2,mDetails_frag,"mDetails_frag");
            transaction.commit();

            detail_show=false;



        }
        else
        {

            detail_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
            Details_frag mDetails_frag= (Details_frag) fragmentManager.findFragmentByTag("mDetails_frag");

            FragmentTransaction transaction1=fragmentManager.beginTransaction();

            transaction1.detach(mDetails_frag);

            transaction1.commit();
            detail_show=true;

        }
    }

    public void Statistical_Measures(View v){
        if(Statistical_Measures_show==true){

            Statistical_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_less_black_24dp));
            Statistical_Measures_frag   statistical_measures_frag=new Statistical_Measures_frag();
            statistical_measures_frag.setArguments(bundle4);
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.add(R.id.Statistical_detail_layout,statistical_measures_frag,"statistical_measures_frag");
            transaction.commit();

            Statistical_Measures_show=false;



        }
        else
        {

            Statistical_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
            Statistical_Measures_frag statistical_measures_frag= (Statistical_Measures_frag) fragmentManager.findFragmentByTag("statistical_measures_frag");

            FragmentTransaction transaction1=fragmentManager.beginTransaction();

            transaction1.detach(statistical_measures_frag);

            transaction1.commit();
            Statistical_Measures_show=true;

        }
    }

    public void Economic_Measures(View v){
        if(Economic_Measures_show==true){

            Economic_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_less_black_24dp));
            Economic_Measures_frag   economic_measures_frag_frag=new Economic_Measures_frag();
            economic_measures_frag_frag.setArguments(bundle4);
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.add(R.id.Economic_detail_layout,economic_measures_frag_frag,"economic_measures_frag_frag");
            transaction.commit();

            Economic_Measures_show=false;



        }
        else
        {

            Economic_expand.setImageDrawable(getDrawable(R.drawable.ic_expand_more_black_24dp));
            Economic_Measures_frag economic_measures_frag_frag= (Economic_Measures_frag) fragmentManager.findFragmentByTag("economic_measures_frag_frag");

            FragmentTransaction transaction1=fragmentManager.beginTransaction();

            transaction1.detach(economic_measures_frag_frag);

            transaction1.commit();
            Economic_Measures_show=true;

        }
    }
}
