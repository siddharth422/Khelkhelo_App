package com.example.siddharth.khelkhelo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Modelclasses.Model_For_Result;

import java.util.ArrayList;

/**
 * Created by Siddharth on 03-May-18.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyHolder>{
    private Context context;
    private ArrayList<Model_For_Result> modelclasses;

    public ResultAdapter(ArrayList<Model_For_Result> modelForResults, Context context) {
        this.modelclasses = modelForResults;
        this.context = context;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_row, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        final Model_For_Result mclass = modelclasses.get(position);
        holder.team1.setText(mclass.getFistteamname());
        holder.team2.setText(mclass.getSecondteamname());
        holder.run1.setText(mclass.getRunone());
        holder.run2.setText(mclass.getRunsecond());
        holder.win.setText(mclass.getWonby());
        holder.desc.setText(mclass.getDescription());
    }

    @Override
    public int getItemCount() {
        return modelclasses.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView team1,team2,run1,run2,win,desc;

        public MyHolder(View itemView) {
            super(itemView);
            team1=itemView.findViewById(R.id.team1name);
            team2=itemView.findViewById(R.id.team2name);
            run1=itemView.findViewById(R.id.team1Score);
            run2=itemView.findViewById(R.id.team2Score);
            win=itemView.findViewById(R.id.wontxt);
            desc=itemView.findViewById(R.id.wondesc);
        }
    }
}
