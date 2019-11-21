package com.example.hp.investosurestart;

/**
 * Created by Shade on 5/9/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class _details_RecyclerAdapter extends RecyclerView.Adapter<_details_RecyclerAdapter.ViewHolder> {
    ArrayList<String> mHolding_sectors_name=new ArrayList<>();
    ArrayList<String> mHolding_sectors_sector=new ArrayList<>();
    ArrayList<String> mHolding_sectors_percentage=new ArrayList<>();
    Context mcontext;
    public _details_RecyclerAdapter(Context context, ArrayList<String> Holding_sectors_name, ArrayList<String> Holding_sectors_sector, ArrayList<String> Holding_sectors_percentage) {
      mcontext=context;
        mHolding_sectors_name=Holding_sectors_name;
        mHolding_sectors_sector=Holding_sectors_sector;
        mHolding_sectors_percentage=Holding_sectors_percentage;
    }






    class ViewHolder extends RecyclerView.ViewHolder{



        public TextView name;
        public TextView sector;
        public TextView assects;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.fund_name);
            assects = (TextView)itemView.findViewById(R.id.fund_assect);
           sector =
                    (TextView)itemView.findViewById(R.id.fund_sector);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {




                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fund_details_lay, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mHolding_sectors_name.get(i));
        viewHolder.assects.setText(mHolding_sectors_percentage.get(i));
        viewHolder.sector.setText(mHolding_sectors_sector.get(i));

    }

    @Override
    public int getItemCount() {
        return mHolding_sectors_name.size();
    }
}