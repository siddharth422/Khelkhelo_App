package com.example.siddharth.khelkhelo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Adapters.Adapter_DD;
import com.example.siddharth.khelkhelo.Home.Model_for_homescoreboard;
import com.example.siddharth.khelkhelo.Modelclasses.Model;
import com.example.siddharth.khelkhelo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 29/5/18.
 */

public class Adapter_for_Scored_Home extends RecyclerView.Adapter<Adapter_for_Scored_Home.MyHolder>{
    private Context context;
    private ArrayList<Model_for_homescoreboard> modelClass;

    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public Adapter_for_Scored_Home(ArrayList<Model_for_homescoreboard> modelClass,Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_for_Scored_Home.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resultcardview,parent,false);
        return new Adapter_for_Scored_Home.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_for_Scored_Home.MyHolder holder, int position) {
        Model_for_homescoreboard mClass=modelClass.get(position);
        Picasso.with(context).load(mClass.getTeam1image()).into(holder.imageView);
        Picasso.with(context).load(mClass.getTeam2image()).into(holder.imageView2);
        holder.textView.setText(mClass.getMatchnumber());
        holder.textView2.setText(mClass.getTeam1name());
        holder.textView3.setText(mClass.getTeam2name());
        holder.textView4.setText(mClass.getTeam1run());
        holder.textView5.setText(mClass.getTeam2run());
        holder.textView6.setText(mClass.getTeam1rr());
        holder.textView7.setText(mClass.getTeam2rr());
        holder.t8.setText(mClass.getTeam1over());
        holder.t9.setText(mClass.getTeam2over());
        holder.t10.setText(mClass.getResult());
//        holder.t11.setText(mClass.getMatchbetween());
//        holder.t12.setText(mClass.getSeries());
//        holder.t13.setText(mClass.getToss());
//        holder.t14.setText(mClass.getMotm());
//        holder.t15.setText(mClass.getDate());
//        holder.t16.setText(mClass.getTime());
//        holder.t17.setText(mClass.getStadium());
//        holder.t18.setText(mClass.getUmpires());
//        holder.t19.setText(mClass.getReferee());
//        holder.t20.setText(mClass.getWeather());

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
        public ImageView imageView,imageView2;
        public TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,t8,t9,t10,t11,t12,t13
                ,t14,t15,t16,t18,t17,t19,t20;
        public MyHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.team1image);
            imageView2=itemView.findViewById(R.id.team2image);
            textView=itemView.findViewById(R.id.matchno);
            textView2=itemView.findViewById(R.id.team1name);
            textView3=itemView.findViewById(R.id.team2name);
            textView4=itemView.findViewById(R.id.team1score);
            textView5=itemView.findViewById(R.id.team2Score);
            textView6=itemView.findViewById(R.id.team1rr);
            textView7=itemView.findViewById(R.id.team2rr);
            t8=itemView.findViewById(R.id.team1over);
            t9=itemView.findViewById(R.id.team2over);
            t10=itemView.findViewById(R.id.result);
            t11=itemView.findViewById(R.id.matchbtwn);
            t12=itemView.findViewById(R.id.series);
            t13=itemView.findViewById(R.id.toss);
            t14=itemView.findViewById(R.id.motm);
            t15=itemView.findViewById(R.id.date);
            t16=itemView.findViewById(R.id.time);
            t17=itemView.findViewById(R.id.stadium);
            t18=itemView.findViewById(R.id.umpires);
            t19=itemView.findViewById(R.id.referee);
            t20=itemView.findViewById(R.id.weather);

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

