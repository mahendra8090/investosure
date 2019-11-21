package com.example.hp.investosurestart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp on 5/11/2018.
 */

public class Debt_fund_list_frag extends Fragment implements View.OnClickListener{
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.all_mutual_fund_list_frag_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<String> arrayList=new ArrayList<String>();

        JsonData jsonData=new JsonData(getActivity());
        arrayList=jsonData.getJSonalldata(0,getActivity());
        listView=(ListView)getActivity().findViewById(R.id.all_debt_listview);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(itemsAdapter);
        final ArrayList<String> finalArrayList = arrayList;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity(),Mutual_details.class);
                i.putExtra("fund_name", finalArrayList.get(position).toString());
                i.putExtra("fragment_no",0);
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), ""+v.getId(), Toast.LENGTH_SHORT).show();

    }

}