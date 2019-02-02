package com.example.siddharth.khelkhelo.Scorecard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Adapters.Adapter_For_battingscore;
import com.example.siddharth.khelkhelo.Modelclasses.Model_BattingScore;
import com.example.siddharth.khelkhelo.Modelclasses.Model_for_Bowling;
import com.example.siddharth.khelkhelo.R;

import java.util.ArrayList;

/**
 * Created by siddharth on 12/6/18.
 */

public class Adapter_For_bowling extends RecyclerView.Adapter<Adapter_For_bowling.MyHolder>{
    private Context context;
    private ArrayList<Model_for_Bowling> modelClass;

    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public Adapter_For_bowling(ArrayList<Model_for_Bowling> modelClass,Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_For_bowling.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bowlingscored,parent,false);
        return new Adapter_For_bowling.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_For_bowling.MyHolder holder, int position) {
        Model_for_Bowling mClass=modelClass.get(position);
        // Picasso.with(context).load(mClass.getPhoto()).into(holder.imageView);
        holder.textView.setText(mClass.getBowlername());
        holder.textView2.setText(mClass.getOver());
        holder.textView3.setText(mClass.getMadin());
        holder.textView4.setText(mClass.getWicket());
        holder.textView5.setText(mClass.getRun());
        holder.textView6.setText(mClass.getEr());
        holder.textView7.setText(mClass.getTeam());
        holder.textView7.setText(mClass.getDate());
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
        public TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,t8;
        public MyHolder(View itemView) {
            super(itemView);
            // imageView=itemView.findViewById(R.id.imageViewplayer);
            textView=itemView.findViewById(R.id.bowlername);
            textView2=itemView.findViewById(R.id.over);
            textView3=itemView.findViewById(R.id.madin);
            textView4=itemView.findViewById(R.id.runbowler);
            textView5=itemView.findViewById(R.id.wicket);
            textView6=itemView.findViewById(R.id.er);
            textView7=itemView.findViewById(R.id.team);
            t8=itemView.findViewById(R.id.date);

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



