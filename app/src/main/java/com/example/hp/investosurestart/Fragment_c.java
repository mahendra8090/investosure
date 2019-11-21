package com.example.hp.investosurestart;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by hp on 4/10/2018.
 */

public class Fragment_c extends Fragment implements View.OnClickListener{
    CardView card1;
    CardView card2;
    CardView card3;
    CardView card4;
    FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_c,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       card1=(CardView)getActivity().findViewById(R.id.card1);
        card2=(CardView)getActivity().findViewById(R.id.card2);
        card3=(CardView)getActivity().findViewById(R.id.card3);
        card4=(CardView)getActivity().findViewById(R.id.card4);
card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),""+v.getId(),Toast.LENGTH_SHORT).show();

     /*   Insurance_details_frag login_frag=new Insurance_details_frag();
        FragmentTransaction transaction_login=manager.beginTransaction();
        transaction_login.add(R.id.home_layout,login_frag,"login");

        transaction_login.commit();*/

Intent i=new Intent(getActivity(),ProfileActivity.class);
        startActivity(i);
    }
}
