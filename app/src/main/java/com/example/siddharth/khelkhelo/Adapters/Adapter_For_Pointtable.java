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
import com.example.siddharth.khelkhelo.Modelclasses.ModelPoint;
import com.example.siddharth.khelkhelo.PointTable;
import com.example.siddharth.khelkhelo.R;
import com.example.siddharth.khelkhelo.Team_CSK;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 23/5/18.
 */

public class Adapter_For_Pointtable extends RecyclerView.Adapter<Adapter_For_Pointtable.MyHolder>{
private Context context;
private ArrayList<ModelPoint> modelClass;

private OnItemClickListener mListener;
public interface OnItemClickListener{
    void onItemClick(int position);
}
    public void setOnItemClickListener(PointTable listener){
        mListener=listener;
    }
    public Adapter_For_Pointtable(ArrayList<ModelPoint> modelClass, Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_For_Pointtable.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pointcard,parent,false);
        return new Adapter_For_Pointtable.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_For_Pointtable.MyHolder holder, int position) {
        ModelPoint mClass=modelClass.get(position);
        Picasso.with(context).load(mClass.getPhoto()).into(holder.imageView);
        holder.textView.setText(mClass.getTeams());
        holder.textView2.setText(mClass.getPlay());
        holder.textView3.setText(mClass.getWin());
        holder.textView4.setText(mClass.getNr());
        holder.textView5.setText(mClass.getNrr());
        holder.textView6.setText(mClass.getPts());

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
        imageView=itemView.findViewById(R.id.teamimagepoint);
        textView=itemView.findViewById(R.id.pteamname);
        textView2=itemView.findViewById(R.id.pteamplay);
        textView3=itemView.findViewById(R.id.pteamwin);
        textView4=itemView.findViewById(R.id.pteamnr);
        textView5=itemView.findViewById(R.id.pteamnrr);
        textView6=itemView.findViewById(R.id.pteampoints);


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

