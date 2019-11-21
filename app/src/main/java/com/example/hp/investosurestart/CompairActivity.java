package com.example.hp.investosurestart;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CompairActivity extends AppCompatActivity {
FragmentManager manager=getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compair);

        Bundle b1=new Bundle();
        b1=getIntent().getExtras();
        int a=b1.getInt("fragment_no");
        String s=b1.getString("fund_name");
        Toast.makeText(CompairActivity.this,"s is this "+s,Toast.LENGTH_LONG).show();
        Bundle b=new Bundle();
        b.putString("fund_name_",s);
        Toast.makeText(CompairActivity.this,""+a,Toast.LENGTH_SHORT).show();
        switch (a) {
            case 0: {
                Toast.makeText(CompairActivity.this, "first", Toast.LENGTH_SHORT).show();
                Debt_fund_list_frag_compair mutual_fund_list_frag = new Debt_fund_list_frag_compair();
                Toast.makeText(CompairActivity.this,""+s,Toast.LENGTH_LONG).show();
                mutual_fund_list_frag.setArguments(b);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.all_mutual_list_layout_compair, mutual_fund_list_frag, "mutual_fund_list_frag");
                transaction.commit();
                break;

            }
            case 1: {
                Toast.makeText(CompairActivity.this, "second", Toast.LENGTH_SHORT).show();
                all_equity_list_compair all_equity_list = new all_equity_list_compair();
                Toast.makeText(CompairActivity.this,""+s,Toast.LENGTH_LONG).show();
                all_equity_list.setArguments(b);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.all_mutual_list_layout_compair, all_equity_list, "all_equity_list");
                transaction.commit();
                break;


            }
            case 2: {
                Toast.makeText(CompairActivity.this, "second", Toast.LENGTH_SHORT).show();
                Hybrid_fund_frag_compair all_hybrid_list = new Hybrid_fund_frag_compair();
                Toast.makeText(CompairActivity.this,""+s,Toast.LENGTH_LONG).toString();
                all_hybrid_list.setArguments(b);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.all_mutual_list_layout_compair, all_hybrid_list, "all_hybrid_list");
                transaction.commit();
                break;


            }

        }}}