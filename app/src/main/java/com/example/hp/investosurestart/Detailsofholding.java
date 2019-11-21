package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp on 5/24/2018.
 */

public class Detailsofholding extends Fragment {
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String> mHolding_sectors_name=new ArrayList<>();
    ArrayList<String> mHolding_sectors_sector=new ArrayList<>();
    ArrayList<String> mHolding_sectors_percentage=new ArrayList<>();
    _details_RecyclerAdapter adapter1;
    RecyclerView details_re_view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detailsofholding_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHolding_sectors_name=getArguments().getStringArrayList("Holding_sectors_name");
     if(mHolding_sectors_name!=null){


        mHolding_sectors_sector=getArguments().getStringArrayList("Holding_sectors_sector");
        mHolding_sectors_percentage=getArguments().getStringArrayList("Holding_sectors_percentage");
        details_re_view=(RecyclerView)getActivity().findViewById(R.id.details_recyclerview);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        details_re_view.setLayoutManager(layoutManager);
        adapter1 = new _details_RecyclerAdapter(getActivity(),mHolding_sectors_name,mHolding_sectors_sector,mHolding_sectors_percentage);
        details_re_view.setAdapter(adapter1);
   }
    else
        {
            Toast.makeText(getActivity(), "data is not availbale", Toast.LENGTH_LONG).show();
       }
}
}
