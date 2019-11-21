package com.example.hp.investosurestart;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hp on 4/5/2018.
 */

public class Slide_adapter extends PagerAdapter {
    Context mcontext;
    LayoutInflater mlayoutinflater;
    public Slide_adapter(Context context) {
        mcontext=context;
    }
    public int[] sliderimages={
            R.drawable.umbrella,
            R.drawable.planting,
            R.drawable.piggybank
    };
    public String[] headings={
            "INSURANCE",
            "Mutual funds",
            "Learn to invest"
    };
    public String[] discription={
            "With InvestoSure’s Investment plans live life worry free.\n",
            "Live Your Todays and dream your tomorrows with Investosure’s Mutual Fund Schemes.\n",
            "Dont depend on others, but be the Master Blaster of the Investment League.\n"
    };
    public String[] question_1={
            "what is insurance?",
            "choose the right one?",
            "how to investm"
    };
    public String[] question_2={
            "why is it important?",
            "how to invest?",
            "how to invest"
    };
    public String[] answer_1={
            "Excepteur sint occaecat cupida\n" +
                    "non proident, sunt in culpa qui\n" +
                    "officia deserunt mollit anim",
            "Excepteur sint occaecat cupida\n" +
                    "non proident, sunt in culpa qui\n" +
                    "officia deserunt mollit anim",
            "Excepteur sint occaecat cupida\n" +
                    "non proident, sunt in culpa qui\n" +
                    "officia deserunt mollit anim"
    };
    public String[] answer_2={
            "Excepteur sint occaecat cupida\nnon proident, sunt in culpa qui\nofficia deserunt mollit anim",
            "Excepteur sint occaecat cupida\nnon proident, sunt in culpa qui\nofficia deserunt mollit anim",
            "Excepteur sint occaecat cupida\nnon proident, sunt in culpa qui\nofficia deserunt mollit anim"
    };


    @Override
    public int getCount() {
        return sliderimages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater)mcontext.getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView mimageView=(ImageView)view.findViewById(R.id.image_slide);



        TextView mHeading=(TextView)view.findViewById(R.id.heading);
        TextView mDescription=(TextView)view.findViewById(R.id.discription);
        TextView mQuestion1=(TextView)view.findViewById(R.id.question1);
        TextView mAnswer1=(TextView)view.findViewById(R.id.answer1);
        TextView mQuestion2=(TextView)view.findViewById(R.id.question2);
        TextView mAnswer2=(TextView)view.findViewById(R.id.answer2);



        mimageView.setImageResource(sliderimages[position]);

        mHeading.setText(headings[position]);
        mDescription.setText(discription[position]);
        mQuestion1.setText(question_1[position]);
        mQuestion2.setText(question_2[position]);
        mAnswer1.setText(answer_1[position]);
        mAnswer2.setText(answer_2[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
