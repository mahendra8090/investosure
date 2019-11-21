package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by hp on 6/8/2018.
 */

public class Double_piechart_frag extends Fragment {
    PieChart mPiechart1,mPiechart2;
    ArrayList<String> data_sector1=new ArrayList<>();
    ArrayList<String> name_sector1=new ArrayList<>();
    ArrayList<String> data_sector2=new ArrayList<>();
    ArrayList<String> name_sector2=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.double_piechart_layout,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPiechart1 = (PieChart) getActivity().findViewById(R.id.piechart1);
        mPiechart2 = (PieChart) getActivity().findViewById(R.id.piechart2);
        name_sector1 = getArguments().getStringArrayList("name_sector1");
        data_sector1 = getArguments().getStringArrayList("data_sector1");
        name_sector2 = getArguments().getStringArrayList("name_sector2");
        data_sector2 = getArguments().getStringArrayList("data_sector2");
       // mPiechart = (PieChart) getActivity().findViewById(R.id.piechart);
        mPiechart1.setUsePercentValues(true);
        mPiechart1.getDescription().setEnabled(false);
        mPiechart1.setExtraOffsets(5, 10, 5, 5);
        mPiechart1.setDragDecelerationFrictionCoef(8.95f);
        mPiechart1.setDrawHoleEnabled(true);
        mPiechart1.setHoleColor(R.color.colorAccent);
        ArrayList<PieEntry> value = new ArrayList<>();

        for (int i = 0; i < name_sector1.size(); i++) {
         //   String s = name_sector1.get(i).toString();
            float f = Float.parseFloat(data_sector1.get(i).toString());
            value.add(new PieEntry(f, ""));
        }

        PieDataSet dataset = new PieDataSet(value, "");
        dataset.setSliceSpace(3f);

        dataset.setSelectionShift(5f);
        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData pieData = new PieData(dataset);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(getResources().getColor(R.color.colorAccent));
        mPiechart1.setData(pieData);



        mPiechart2.setUsePercentValues(true);
        mPiechart2.getDescription().setEnabled(false);
        mPiechart2.setExtraOffsets(5, 10, 5, 5);
        mPiechart2.setDragDecelerationFrictionCoef(8.95f);
        mPiechart2.setDrawHoleEnabled(true);
        mPiechart2.setHoleColor(R.color.colorAccent);
        ArrayList<PieEntry> value2 = new ArrayList<>();

        for (int i = 0; i < name_sector2.size(); i++) {
          //  String s = name_sector2.get(i).toString();
            float f = Float.parseFloat(data_sector2.get(i).toString());
            value2.add(new PieEntry(f, ""));
        }

        PieDataSet dataset2 = new PieDataSet(value2, "");
        dataset2.setSliceSpace(3f);
        dataset2.setSelectionShift(5f);
        dataset2.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData pieData2 = new PieData(dataset2);
        pieData2.setValueTextSize(10f);
        pieData2.setValueTextColor(getResources().getColor(R.color.colorAccent));
        mPiechart2.setData(pieData2);

    }

}

