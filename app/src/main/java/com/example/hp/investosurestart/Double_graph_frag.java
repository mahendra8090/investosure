package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * Created by hp on 6/8/2018.
 */

public class Double_graph_frag extends Fragment {
    LineChart lineChart1,lineChart2;
    ArrayList<String> time1=new ArrayList<>();
    ArrayList<String> time2=new ArrayList<>();
    ArrayList<String> percentage1=new ArrayList<>();
    ArrayList<String> percentage2=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.double_graph_frag_layout,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        time1=getArguments().getStringArrayList("time1");
        time2=getArguments().getStringArrayList("time2");
        percentage2=getArguments().getStringArrayList("percentage2");
        percentage1=getArguments().getStringArrayList("percentage1");

        lineChart1=(LineChart)getActivity().findViewById(R.id.line_chart1);


        // lineChart.setOnChartGestureListener(getActivity());
        // lineChart.setOnChartValueSelectedListener(getActivity());
        lineChart1.setDragEnabled(true);
        lineChart1.setScaleEnabled(false);


        Float j=0.0f;
        ArrayList<Entry> yvalues=new ArrayList<>();
        ArrayList<Entry> yvalues2=new ArrayList<>();
        for(int i=0;i<time1.size();i++){

            yvalues.add(new Entry(Float.parseFloat(time1.get(i))-Float.parseFloat(time1.get(0)),Float.parseFloat(percentage1.get(i))));
        }
        for(int i=0;i<time1.size();i++){

            yvalues2.add(new Entry(Float.parseFloat(time2.get(i))-Float.parseFloat(time2.get(0)),Float.parseFloat(percentage2.get(i))));
        }







String[] s1=new String[]{
        "0","1","2","3","4","5","6"
};
ArrayList<ILineDataSet> lines=new ArrayList<>();

            LineDataSet set1=new LineDataSet(yvalues,"data set1");
        set1.setDrawCircles(false);
        set1.setColors(getResources().getColor(R.color.colororange));
        set1.setCircleColor(getResources().getColor(R.color.colororange));

            set1.setFillAlpha(110);
        lines.add(set1);
        LineDataSet set2=new LineDataSet(yvalues2,"data set 2");
        set2.setDrawCircles(false);
        set2.setFillAlpha(110);
        lines.add(set2);
        LineData data2=new LineData(lines);
    lineChart1.setData(data2);




}
}
