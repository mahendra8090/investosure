package com.example.hp.investosurestart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by hp on 4/28/2018.
 */

public class Pie_chart_frag extends Fragment {
    ArrayList<String> data_sector=new ArrayList<>();
    ArrayList<String> name_sector=new ArrayList<>();
    PieChart mPiechart;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pie_chart_frag_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        name_sector = getArguments().getStringArrayList("name_sector");
        data_sector = getArguments().getStringArrayList("data_sector");
        mPiechart = (PieChart) getActivity().findViewById(R.id.piechart);
        mPiechart.setUsePercentValues(true);
        mPiechart.getDescription().setEnabled(false);
        mPiechart.setExtraOffsets(5, 10, 5, 5);
        mPiechart.setDragDecelerationFrictionCoef(8.95f);
        mPiechart.setDrawHoleEnabled(true);
        mPiechart.setHoleColor(R.color.colorAccent);
        ArrayList<PieEntry> value = new ArrayList<>();

        for (int i = 0; i < name_sector.size(); i++) {
            String s = name_sector.get(i).toString();
            float f = Float.parseFloat(data_sector.get(i).toString());
            value.add(new PieEntry(f, s));
        }

        PieDataSet dataset = new PieDataSet(value, "contries");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);
        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData pieData = new PieData(dataset);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(getResources().getColor(R.color.colorAccent));
        mPiechart.setData(pieData);

    }

}
