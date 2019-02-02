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
import com.example.siddharth.khelkhelo.Modelclasses.Model_BattingScore;
import com.example.siddharth.khelkhelo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by siddharth on 8/6/18.
 */

public class Adapter_For_battingscore extends RecyclerView.Adapter<Adapter_For_battingscore.MyHolder>{
    private Context context;
    private ArrayList<Model_BattingScore> modelClass;

    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public Adapter_For_battingscore(ArrayList<Model_BattingScore> modelClass,Context context)
    {
        this.modelClass=modelClass;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter_For_battingscore.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.battingscorecard,parent,false);
        return new Adapter_For_battingscore.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_For_battingscore.MyHolder holder, int position) {
        Model_BattingScore mClass=modelClass.get(position);
       // Picasso.with(context).load(mClass.getPhoto()).into(holder.imageView);
        holder.textView.setText(mClass.getPlayer_name());
        holder.textView2.setText(mClass.getRun());
        holder.textView3.setText(mClass.getBalls());
        holder.textView4.setText(mClass.getFours());
        holder.textView5.setText(mClass.getSix());
        holder.textView6.setText(mClass.getSr());
        holder.textView7.setText(mClass.getTeam());
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
           // imageView=itemView.findViewById(R.id.imageViewplayer);
            textView=itemView.findViewById(R.id.batsman_name);
            textView2=itemView.findViewById(R.id.run);
            textView3=itemView.findViewById(R.id.balls);
            textView4=itemView.findViewById(R.id.fours);
            textView5=itemView.findViewById(R.id.six);
            textView6=itemView.findViewById(R.id.sr);
            textView7=itemView.findViewById(R.id.team);

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


