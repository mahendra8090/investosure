package com.example.hp.investosurestart;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeeAllMutualActivity extends AppCompatActivity {
RecyclerView  recyclerView1;
    RecyclerView.Adapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    ArrayList<ArrayList<String>> midlist=new ArrayList<>();
    ArrayList<List> tableList = new ArrayList<>();
FragmentManager manager=getSupportFragmentManager();

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_mutual);






Bundle b1=new Bundle();
        b1=getIntent().getExtras();
         int a=b1.getInt("fragment_no");
        Toast.makeText(SeeAllMutualActivity.this,""+a,Toast.LENGTH_SHORT).show();
        switch (a){
            case 0:
            {Toast.makeText(SeeAllMutualActivity.this,"first",Toast.LENGTH_SHORT).show();
                Debt_fund_list_frag mutual_fund_list_frag=new Debt_fund_list_frag();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.all_mutual_list_layout,mutual_fund_list_frag,"mutual_fund_list_frag");
                transaction.commit();
                break;

            }
            case 1:
            {Toast.makeText(SeeAllMutualActivity.this,"second",Toast.LENGTH_SHORT).show();
                all_equity_list all_equity_list=new all_equity_list();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.all_mutual_list_layout,all_equity_list,"all_equity_list");
                transaction.commit();
                break;




            }
            case 2:
            {Toast.makeText(SeeAllMutualActivity.this,"second",Toast.LENGTH_SHORT).show();
                Hybrid_fund_frag all_hybrid_list=new Hybrid_fund_frag();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.all_mutual_list_layout,all_hybrid_list,"all_hybrid_list");
                transaction.commit();
                break;




            }


        }




























    }
      /*  textView=(TextView)findViewById(R.id.testing);










                try { String resource = AssetJSONFile("feed.json",SeeAllMutualActivity.this);
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
        try

        { String resource = AssetJSONFile("feed2.json",SeeAllMutualActivity.this);
            JSONArray jsonobject2=new JSONArray(resource);
ArrayList<String> names=new ArrayList<>();
    for(int j=0;j<jsonobject2.length();j++){
        JSONObject object=jsonobject2.getJSONObject(j);
        String name=object.getString("name");
        names.add(name);
    }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //My problem is here!!

           List<List> row=tableList.get(1);
        List<String> stringList=row.get(1);
        textView.setText(stringList.get(1).toString());





    recyclerView1 = (RecyclerView)findViewById(R.id.recycler_view_seeall);
        layoutManager1 = new LinearLayoutManager(SeeAllMutualActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new RecyclerAdapter_Seeall(this,tableList.size(),tableList);
        recyclerView1.setAdapter(adapter1);

    }


    public static String AssetJSONFile (String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }*/
}
