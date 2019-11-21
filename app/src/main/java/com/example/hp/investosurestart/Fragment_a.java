package com.example.hp.investosurestart;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hp on 4/10/2018.
 */

public class Fragment_a extends Fragment implements View.OnClickListener
{   TextView mSeeall_1;
    TextView mSeeall_2;
    TextView mSeeall_3;



    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;

    RecyclerView.LayoutManager layoutManager1;
    RecyclerView.LayoutManager layoutManager2;
    RecyclerView.LayoutManager layoutManager3;
    RecyclerView.Adapter adapter1;
    RecyclerView.Adapter adapter2;
    RecyclerView.Adapter adapter3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_a,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "yes it is working1", Toast.LENGTH_SHORT).show();
mSeeall_1=(TextView)getActivity().findViewById(R.id.seeall_1);
        mSeeall_2=(TextView)getActivity().findViewById(R.id.seeall_2);
        mSeeall_3=(TextView)getActivity().findViewById(R.id.seeall_3);

        recyclerView1 = (RecyclerView)getActivity().findViewById(R.id.recycler_view);
        recyclerView2 = (RecyclerView)getActivity().findViewById(R.id.recycler_view2);
        recyclerView3 = (RecyclerView)getActivity().findViewById(R.id.recycler_view3);


        layoutManager1 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new RecyclerAdapter(getActivity(),0);
        recyclerView1.setAdapter(adapter1);

        layoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new RecyclerAdapter(getActivity(),1);
        recyclerView2.setAdapter(adapter2);

        layoutManager3 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView3.setLayoutManager(layoutManager3);
        adapter3 = new RecyclerAdapter(getActivity(),2);
        recyclerView3.setAdapter(adapter3);
    mSeeall_1.setOnClickListener(this);
        mSeeall_2.setOnClickListener(this);
        mSeeall_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(getActivity(),SeeAllMutualActivity.class);
        switch (v.getId()){
            case R.id.seeall_1:
            {i.putExtra("fragment_no",0);
                startActivity(i);
                break;
            }
            case R.id.seeall_2:
            {i.putExtra("fragment_no",1);
                startActivity(i);
                break;
            }
            case R.id.seeall_3:
            {i.putExtra("fragment_no",2);
                startActivity(i);
                break;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
