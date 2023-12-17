package com.example.planvr;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class homepageadapter extends RecyclerView.Adapter<homepageadapter.homepageviewholder> {

    Context context;
    ArrayList<homepagedata> list;

    

    public homepageadapter(Context context,ArrayList<homepagedata> list) {
        this.context = context;
        this.list = list;
    }

    class homepageviewholder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView imgview,btn;

        public homepageviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.prjoectsname);
            imgview = itemView.findViewById(R.id.vrname);
            btn = itemView.findViewById(R.id.menupage);
        }
    }

    @NonNull
    @Override
    public homepageviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.activity_homercitem,parent,false);
        return new homepageadapter.homepageviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull homepageviewholder holder, int position) {
        homepagedata data = list.get(position);
        holder.imgview.setImageResource(data.getVrimg());
        holder.name.setText(data.getPorjectname());
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, menupage.class);
                context.startActivity(intent);            }
        });


    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
