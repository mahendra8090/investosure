package com.example.hp.investosurestart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by hp on 4/10/2018.
 */

public class Fragment_b extends Fragment implements View.OnClickListener {
    CardView cardView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cardView =(CardView)getActivity().findViewById(R.id.find_best_plan);
        cardView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        Intent i=new Intent(getActivity(),Call_activity.class);
           startActivity(i);




    }
}
