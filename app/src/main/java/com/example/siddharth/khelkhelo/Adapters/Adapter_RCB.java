package com.example.siddharth.khelkhelo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Modelclasses.Model;
import com.example.siddharth.khelkhelo.R;
import com.example.siddharth.khelkhelo.Team_CSK;
import com.example.siddharth.khelkhelo.Team_RCB;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 22/5/18.
 */

public class Adapter_RCB extends RecyclerView.Adapter<Adapter_RCB.MyHolder>{
    private Context context;
    private ArrayList<Model> modelClass;

    private Adapter_RCB.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(Team_RCB listener){
        mListener=listener;
    }
    public Adapter_RCB(ArrayList<Model> modelClass, Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_RCB.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_cardview,parent,false);
        return new Adapter_RCB.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_RCB.MyHolder holder, int position) {
        Model mClass=modelClass.get(position);
        Picasso.with(context).load(mClass.getPhoto()).into(holder.imageView);
        holder.textView.setText(mClass.getName());
        // holder.textView2.setText(mClass.getDescription());
       /* Picasso.with(context)
                .load(mClass.getImage_url())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);*/
    }

    @Override
    public int getItemCount() {
        return modelClass.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView,textView2,textView3,textView4,textView5,textView6,textView7;
        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageViewplayer);
            textView=itemView.findViewById(R.id.textViewplayer);
            //textView2=itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

