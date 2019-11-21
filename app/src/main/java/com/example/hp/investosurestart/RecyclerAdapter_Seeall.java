package com.example.hp.investosurestart;

/**
 * Created by Shade on 5/9/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter_Seeall extends RecyclerView.Adapter<RecyclerAdapter_Seeall.ViewHolder> {
    Context mcontext;
   private int listsize;
   public ArrayList<List> mtableList = new ArrayList<>();
    public RecyclerAdapter_Seeall(Context context, int n, ArrayList<List> table) {
      mcontext=context;
        listsize=n;
        mtableList =table;
    }

    private String[] titles=gettitlestring();
    public String[] gettitlestring(){
        String[] strings=new String[20];
        for(int i=0;i<listsize;i++){
           strings[i]="topic "+i;
        }
        return  strings;
    }
    private String[] details=getdetailstring();
    public String[] getdetailstring(){
        String[] strings=new String[20];
        for(int i=0;i<listsize;i++){
            strings[i]="details "+i;
        }
        return  strings;
    }







    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;

        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            itemTitle = (TextView)itemView.findViewById(R.id.item_title_seeall);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail_seeall);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Toast.makeText(mcontext,"yes"+position,Toast.LENGTH_LONG).show();
                   Intent i=new Intent(mcontext,Mutual_details.class);
                    mcontext.startActivity(i);


                   i.putExtra("mylist", mtableList);
                    i.putExtra("position",position);




                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout_seeall, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}