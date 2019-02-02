package com.example.siddharth.khelkhelo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Modelclasses.Model_For_Team;
import com.example.siddharth.khelkhelo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Siddharth on 23-Apr-18.
 */

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyHolder>{
    private Context context;
    private ArrayList<Model_For_Team> modelclasses;

    public MyAdpter(ArrayList<Model_For_Team> modelForTeams, Context context) {
        this.modelclasses = modelForTeams;
        this.context = context;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        final Model_For_Team mclass = modelclasses.get(position);
        holder.textView.setText(mclass.getImage_desc());
        Picasso.with(context).load(mclass.getImage_url()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelclasses.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            textView=itemView.findViewById(R.id.textview);
        }
    }
}
