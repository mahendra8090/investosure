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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context mcontext;

    public int mtype;
    public RecyclerAdapter(Context context,int type) {
        mtype=type;
      mcontext=context;
    }



    public ArrayList<String> getlist(int n){
        ArrayList<String> arrayList=new ArrayList<String>();
        JsonData jsonData=new JsonData(mcontext);
        arrayList=jsonData.getJSonalldata(n,mcontext);
        return arrayList;
    }

    private String[] titles = {"Chapter One",
            "Chapter Two",
            "Chapter Three",
            "Chapter Four",
            "Chapter Five",
            "Chapter Six",
            "Chapter Seven",
            "Chapter Eight"};

    private String[] details = {"",
            "", "",
            "", "",
            "", "",
            ""};



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;

        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Toast.makeText(mcontext,"yes"+position,Toast.LENGTH_LONG).show();
                   Intent i=new Intent(mcontext,Mutual_details.class);
                    i.putExtra("fund_name",getlist(mtype).get(position));
                    i.putExtra("fragment_no",mtype);
                    mcontext.startActivity(i);



                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(getlist(mtype).get(i));
        viewHolder.itemDetail.setText(details[i]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}