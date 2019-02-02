package com.example.siddharth.khelkhelo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Adapters.*;
import com.example.siddharth.khelkhelo.Adapters.MyAdapter;
import com.example.siddharth.khelkhelo.Modelclasses.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 28/5/18.
 */

public class Adapter_for_photo extends RecyclerView.Adapter<Adapter_for_photo.MyHolder>{
    private Context context;
    private ArrayList<com.example.siddharth.khelkhelo.Modelclasses.ModelClass> modelClass;

    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public Adapter_for_photo(ArrayList<com.example.siddharth.khelkhelo.Modelclasses.ModelClass> modelClass, Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_for_photo.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_photo,parent,false);
        return new Adapter_for_photo.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_for_photo.MyHolder holder, int position) {
        com.example.siddharth.khelkhelo.Modelclasses.ModelClass mClass=modelClass.get(position);
        Picasso.with(context).load(mClass.getPhoto()).into(holder.imageView);
    //    holder.textView.setText(mClass.getName());
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
        public TextView textView,textView2;
        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_photo);
          //  textView=itemView.findViewById(R.id.textView);
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

