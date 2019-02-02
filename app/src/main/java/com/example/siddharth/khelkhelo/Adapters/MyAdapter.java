package com.example.siddharth.khelkhelo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.Modelclasses.ModelClass;
import com.example.siddharth.khelkhelo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Abhinay on 4/3/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
    private Context context;
    private ArrayList<ModelClass> modelClass;

    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public MyAdapter(ArrayList<ModelClass> modelClass,Context context)
    {
      this.modelClass=modelClass;
      this.context=context;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                  .inflate(R.layout.card_row,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
     ModelClass mClass=modelClass.get(position);
     Picasso.with(context).load(mClass.getPhoto()).into(holder.imageView);
     holder.textView.setText(mClass.getName());

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
        imageView=itemView.findViewById(R.id.imageView);
        textView=itemView.findViewById(R.id.textView);
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
