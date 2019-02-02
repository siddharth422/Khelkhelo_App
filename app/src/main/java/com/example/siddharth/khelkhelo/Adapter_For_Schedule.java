package com.example.siddharth.khelkhelo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Adapters.MyAdapter;
import com.example.siddharth.khelkhelo.Modelclasses.ModelClass;
import com.example.siddharth.khelkhelo.Modelclasses.Model_For_Schedule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 19/5/18.
 */

public class Adapter_For_Schedule extends RecyclerView.Adapter<Adapter_For_Schedule.MyHolder>{
    private Context context;
    private ArrayList<Model_For_Schedule> modelClass;

    private Adapter_For_Schedule.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(Adapter_For_Schedule.OnItemClickListener listener){
        mListener=listener;
    }
    public Adapter_For_Schedule(ArrayList<Model_For_Schedule> modelClass,Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_For_Schedule.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule,parent,false);
        return new Adapter_For_Schedule.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_For_Schedule.MyHolder holder, int position) {
        Model_For_Schedule mClass=modelClass.get(position);
        Picasso.with(context).load(mClass.getTeam1image()).into(holder.imageView);
        Picasso.with(context).load(mClass.getTeam2image()).into(holder.imageView2);
        holder.textView.setText(mClass.getDay());
        holder.textView2.setText(mClass.getDate());
        holder.textView3.setText(mClass.getTime());
        holder.textView4.setText(mClass.getTeam1name());
        holder.textView5.setText(mClass.getTeam2name());




    }

    @Override
    public int getItemCount() {
        return modelClass.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imageView,imageView2;
        public TextView textView,textView2,textView3,textView4,textView5,textView6;
        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.team1image);
            imageView2=itemView.findViewById(R.id.team2image);
            textView=itemView.findViewById(R.id.day_schedule);
            textView2=itemView.findViewById(R.id.date_schedule);
            textView3=itemView.findViewById(R.id.time_schedule);
            textView4=itemView.findViewById(R.id.teamname_schedule);
            textView5=itemView.findViewById(R.id.team2name_schedule);
           // textView2=itemView.findViewById(R.id.textView2);

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
