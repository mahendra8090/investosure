package com.example.hp.investosurestart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by hp on 4/28/2018.
 */

public class Learn_frag extends Fragment implements View.OnClickListener {
    CardView c1,c2,c3,c4;
    homepagecommu mhomepagecommu;
    ImageView back_from_learn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learn_frag_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mhomepagecommu=(homepagecommu)getActivity();
        back_from_learn=(ImageView)getActivity().findViewById(R.id.back_from_learntohome);
        c1=(CardView)getActivity().findViewById(R.id.learn_card1);
        c2=(CardView)getActivity().findViewById(R.id.learn_card2);
        c3=(CardView)getActivity().findViewById(R.id.learn_card3);
        c4=(CardView)getActivity().findViewById(R.id.learn_card4);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
back_from_learn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

            if(v.getId()==R.id.back_from_learntohome)
                {
                    mhomepagecommu.respond_homepage();
                    Toast.makeText(getActivity(),""+v.getId(),Toast.LENGTH_SHORT).show();

            }
              if(v.getId()==R.id.learn_card1)  {
            Toast.makeText(getActivity(),""+v.getId(),Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getActivity(),LearninDetail.class);
                  i.putExtra("frag_no","1");
                startActivity(i);

        }
        if(v.getId()==R.id.learn_card2)  {
            Toast.makeText(getActivity(),""+v.getId(),Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getActivity(),LearninDetail.class);
            i.putExtra("frag_no","2");
            startActivity(i);

        }
        if(v.getId()==R.id.learn_card3)  {
            Toast.makeText(getActivity(),""+v.getId(),Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getActivity(),LearninDetail.class);
            i.putExtra("frag_no","3");
            startActivity(i);

        }

    }
}
