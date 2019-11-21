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

public class RecyclerAdapter_Notificationlist extends RecyclerView.Adapter<RecyclerAdapter_Notificationlist.ViewHolder> {
    Context mcontext;
    public RecyclerAdapter_Notificationlist(Context context) {
      mcontext=context;
    }

    private String[] titles = {"Notification One",
            "Notification Two",
            "Notification Three",
            "Notification Four",
            "Notification Five",
            "Notification Six",
            "Notification Seven",
            "Notification Eight"};

    private String[] details = {"what is about",
            "what is about", "what is about",
            "what is about", "what is about",
            "what is about", "what is about",
            "what is about"};



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;

        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            itemTitle = (TextView)itemView.findViewById(R.id.item_title_notification);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail_notification);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();




                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout_notification, viewGroup, false);
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