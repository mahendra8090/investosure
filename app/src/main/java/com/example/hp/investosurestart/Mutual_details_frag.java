package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 4/28/2018.
 */

public class Mutual_details_frag extends Fragment {
    LineChart lineChart;
    String strtext;
    TextView textView,name_fund,type_fund,rating_fund,risk_fund;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.mutual_details_frag_layout,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        name_fund=(TextView)getActivity().findViewById(R.id.name_fund);
        type_fund=(TextView)getActivity().findViewById(R.id.type_fund);
        rating_fund=(TextView)getActivity().findViewById(R.id.rating_fund);
        risk_fund=(TextView)getActivity().findViewById(R.id.risk_fund);
        String name=getArguments().getString("name");
        String type=getArguments().getString("type");
        String rating=getArguments().getString("rating");
        String risk=getArguments().getString("risk");
        name_fund.setText(name);

        type_fund.setText(type);
        rating_fund.setText(rating);
        risk_fund.setText(risk);


       ArrayList<String> time=getArguments().getStringArrayList("time");
      ArrayList<String> percentage=getArguments().getStringArrayList("percentage");

    //  Toast.makeText(getActivity(),"i am in frag"   +time,Toast.LENGTH_SHORT).show();
       //    textView.setText(data.get(0).toString());
        lineChart=(LineChart)getActivity().findViewById(R.id.line_chart);
       // lineChart.setOnChartGestureListener(getActivity());
       // lineChart.setOnChartValueSelectedListener(getActivity());
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
        Float j=0.0f;
        ArrayList<Entry> yvalues=new ArrayList<>();
        if(time.get(0)!=null){
for(int i=0;i<time.size();i++){

    yvalues.add(new Entry(Float.parseFloat(time.get(i))-Float.parseFloat(time.get(0)),Float.parseFloat(percentage.get(i))));
}






        LineDataSet set1=new LineDataSet(yvalues,"data set1");
            set1.setColors(getResources().getColor(R.color.colororange));
            set1.setDrawCircles(false);
        set1.setFillAlpha(110);
        ArrayList<ILineDataSet> dataset=new ArrayList<>();
        dataset.add(set1);
        LineData data=new LineData(dataset);
        lineChart.setData(data);
    }
    else
        {
            Toast.makeText(getActivity(),"graph data is not availble",Toast.LENGTH_SHORT).show();
        }
    }


}
