package com.example.hp.investosurestart;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class LearninDetail extends AppCompatActivity {
FragmentManager fragmentManager=getSupportFragmentManager();
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnin_detail);
        linearLayout=(LinearLayout)findViewById(R.id.learn_layout);
        String s=getIntent().getStringExtra("frag_no").toString();
   if(s.contains("1")){
       Learn_mutual_frag learn_mutual_frag=new Learn_mutual_frag();
       FragmentTransaction transaction=fragmentManager.beginTransaction();
       transaction.replace(R.id.learn_layout,learn_mutual_frag,"learn_mutual_frag");
       transaction.commit();

   }
        if(s.contains("2")){
            Learn_finential_planning_frag learn_mutual_frag=new Learn_finential_planning_frag();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.learn_layout,learn_mutual_frag,"learn_mutual_frag");
            transaction.commit();

        }
        if(s.contains("3")){
            Learn_insurance_frag learn_mutual_frag=new Learn_insurance_frag();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.learn_layout,learn_mutual_frag,"learn_mutual_frag");
            transaction.commit();

        }
    }
}
