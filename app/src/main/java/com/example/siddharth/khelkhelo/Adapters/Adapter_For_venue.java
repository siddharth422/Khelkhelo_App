package com.example.siddharth.khelkhelo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.ModelClass;
import com.example.siddharth.khelkhelo.Modelclasses.Model;
import com.example.siddharth.khelkhelo.R;
import com.example.siddharth.khelkhelo.Team_RCB;
import com.example.siddharth.khelkhelo.Venue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 23/5/18.
 */

public class Adapter_For_venue extends RecyclerView.Adapter<Adapter_For_venue.MyHolder>{
    private Context context;
    private ArrayList<ModelClass> modelClass;

    private Adapter_For_venue.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(Venue listener){
        mListener=listener;
    }
    public Adapter_For_venue(ArrayList<ModelClass> modelClass, Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_For_venue.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venue_card,parent,false);
        return new Adapter_For_venue.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_For_venue.MyHolder holder, int position) {
        ModelClass mClass=modelClass.get(position);
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
            imageView=itemView.findViewById(R.id.image_view_venue);
            textView=itemView.findViewById(R.id.text_view_venue);
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


