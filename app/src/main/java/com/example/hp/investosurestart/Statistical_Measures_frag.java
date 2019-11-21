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


public class Statistical_Measures_frag extends Fragment {
    TextView sd,Sharpe_ratio,launch_date,Beta;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statistical_measures,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String stddev=getArguments().getString("stddev");
        String sharpe=getArguments().getString("sharpe");
        String beta=getArguments().getString("beta");

        sd=(TextView)getActivity().findViewById(R.id.SD);
        sd.setText(stddev);
        Sharpe_ratio=(TextView)getActivity().findViewById(R.id.Sharpe_ratio);
        Sharpe_ratio.setText(sharpe);
        Beta=(TextView)getActivity().findViewById(R.id.beta);
        Beta.setText(beta);

    }
}
