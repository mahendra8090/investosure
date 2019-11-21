package com.example.hp.investosurestart;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mviewPager;
    private LinearLayout mlinearLayout;
    public Slide_adapter mslider_adpter;
    private TextView[] mdot=new TextView[3];
    private ImageView mprebutton;
    private ImageView mnextbutton;
    private int mcurrentpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mprebutton=(ImageView) findViewById(R.id.prebutton);
        mprebutton.setImageDrawable(getResources().getDrawable(R.drawable.backward));
        mnextbutton=(ImageView) findViewById(R.id.nextbutton);
        mnextbutton.setImageDrawable(getResources().getDrawable(R.drawable.forward));
        mviewPager=(ViewPager)findViewById(R.id.viewpager);
        mlinearLayout=(LinearLayout)findViewById(R.id.dotlayout);

        mslider_adpter=new Slide_adapter(this);
        mviewPager.setAdapter(mslider_adpter);
        adddotindicator(0);
        mviewPager.addOnPageChangeListener(view_listner);
        buttonname(0);
        mnextbutton.setOnClickListener(new View.OnClickListener(){

                                           @Override
                                           public void onClick(View view) {

                                               mviewPager.setCurrentItem(mcurrentpage+1);
                                               if(mcurrentpage==2){
                                                   Intent intent=new Intent(MainActivity.this,Login_Activity.class);
                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
        mprebutton.setOnClickListener(new View.OnClickListener(){

                                          @Override
                                          public void onClick(View view) {
                                              mviewPager.setCurrentItem(mcurrentpage-1);
                                          }
                                      }
        );
    }
    public void adddotindicator(int position){

        for(int i=0;i<mdot.length;i++) {
            mdot[i] = new TextView(this);
            mdot[i].setText(Html.fromHtml("&#8226"));
            mdot[i].setTextSize(35);
            mdot[i].setTextColor(getResources().getColor(R.color.colorWhite));
            mlinearLayout.addView(mdot[i]);}
        if(mdot.length>0){
            mdot[position].setTextColor(getResources().getColor(R.color.colorAccent));


        }
    }


    ViewPager.OnPageChangeListener view_listner=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            dotcolorchange(i);
            mcurrentpage=i;
            buttonname(mcurrentpage);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public void dotcolorchange(int position){
        for(int i=0;i<mdot.length;i++){
            mdot[i].setTextColor(getResources().getColor(R.color.colorWhite));
        }
        if(mdot.length>0){
            mdot[position].setTextColor(getResources().getColor(R.color.colorAccent));


        }

    }
    public void buttonname(int i){
        int   currentpage=mdot.length-1;
        if(i==0){
            mprebutton.setEnabled(false);
            mnextbutton.setEnabled(true);
            mnextbutton.setVisibility(View.VISIBLE);
            mprebutton.setVisibility(View.INVISIBLE);


        }
        else if(i==currentpage)
        {
            mprebutton.setEnabled(true);
            mnextbutton.setEnabled(true);
            mprebutton.setVisibility(View.VISIBLE);
            mprebutton.setVisibility(View.VISIBLE);




        }
        else{
            mprebutton.setEnabled(true);
            mnextbutton.setEnabled(true);
            mprebutton.setVisibility(View.VISIBLE);
            mprebutton.setVisibility(View.VISIBLE);


        }
    }
    }

