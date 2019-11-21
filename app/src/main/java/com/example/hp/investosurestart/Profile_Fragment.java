package com.example.hp.investosurestart;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

/**
 * Created by hp on 4/15/2018.
 */

public class Profile_Fragment extends Fragment implements View.OnClickListener{
    ImageView profile;
    homepagecommu commuLog;
    LinearLayout linearLayout;
    ImageView back_from_profile_icon;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        commuLog= (homepagecommu) getActivity();
        profile=(ImageView)getActivity().findViewById(R.id.profile_image);
        linearLayout=(LinearLayout)getActivity().findViewById(R.id.test_layout);
        back_from_profile_icon=(ImageView)getActivity().findViewById(R.id.back_from_profile);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.my);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        profile.setImageDrawable(roundedBitmapDrawable);
        back_from_profile_icon.setOnClickListener(this);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back_from_profile){
            commuLog.respond_homepage();
        }    }

}
