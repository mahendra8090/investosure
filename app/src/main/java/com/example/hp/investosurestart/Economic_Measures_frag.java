package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hp on 6/15/2018.
 */


public class Economic_Measures_frag extends Fragment {
    TextView Exit_Load,Expense_Ratio,AUM;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.economic_measures,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String exit_load=getArguments().getString("exit_load");
        String expense=getArguments().getString("expense");
        String assets=getArguments().getString("assets");

        Exit_Load=(TextView)getActivity().findViewById(R.id.Exit_Load);
        Exit_Load.setText(exit_load);

        Expense_Ratio=(TextView)getActivity().findViewById(R.id.Expense_Ratio);
        Expense_Ratio.setText(expense);

        AUM=(TextView)getActivity().findViewById(R.id.AUM);
        AUM.setText(assets);

    }
}
