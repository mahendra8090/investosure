package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by hp on 4/28/2018.
 */

public class Notification_frag extends Fragment implements View.OnClickListener {
    FragmentManager manager=getFragmentManager();
    homepagecommu mhomepagecommu;
    ImageView back_notification_button;
    RecyclerView recyclerView_noti;
    RecyclerView.LayoutManager layoutManager_noti;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_frag_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mhomepagecommu=(homepagecommu)getActivity();
        back_notification_button=(ImageView)getActivity().findViewById(R.id.back_from_noti);
        recyclerView_noti = (RecyclerView)getActivity().findViewById(R.id.notification_list);
        layoutManager_noti = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView_noti.setLayoutManager(layoutManager_noti);
        RecyclerAdapter_Notificationlist adapter1;
        adapter1 = new RecyclerAdapter_Notificationlist(getActivity());
        recyclerView_noti.setAdapter(adapter1);
        back_notification_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
if(v.getId()==R.id.back_from_noti){
mhomepagecommu.respond_homepage();}
        }

}
