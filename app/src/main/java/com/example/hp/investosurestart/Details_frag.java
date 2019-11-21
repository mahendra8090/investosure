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


public class Details_frag extends Fragment {
    TextView obj,manager,launch_date,assets;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_frag_layout,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String objective=getArguments().getString("objective");
        String Mmanager=getArguments().getString("manager");
        String Mlaunch_date=getArguments().getString("launch_date");
        String Massets=getArguments().getString("assets");
        obj=(TextView)getActivity().findViewById(R.id.objective);
        obj.setText(objective);
        manager=(TextView)getActivity().findViewById(R.id.manager);
        manager.setText(Mmanager);
        launch_date=(TextView)getActivity().findViewById(R.id.launch_date);
        launch_date.setText(Mlaunch_date);
        assets=(TextView)getActivity().findViewById(R.id.assets);
        assets.setText(Massets);
    }
}
