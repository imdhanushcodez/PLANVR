package com.example.planvr;

import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.content.ContextCompat.startActivity;
import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class builderadapter extends RecyclerView.Adapter<builderadapter.builderviewholder> {
    Context context;
    ArrayList<builderdata> list;

    public builderadapter(Context context, ArrayList<builderdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public builderviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.builderitem,parent,false);
        return new builderadapter.builderviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull builderviewholder holder, int position) {
    builderdata data = list.get(position);
    holder.name.setText(data.getName());
    holder.add.setText(data.getAddress());
    holder.iv.setImageResource(data.getImg());
    holder.btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String number = data.getPhone();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+"8973645887"));
            context.startActivity(intent);

            // Check for CALL_PHONE permission before making the call

        }




    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class builderviewholder extends RecyclerView.ViewHolder{

        TextView name,add;
        ImageView iv;
        AppCompatButton btn;

        public builderviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.bname);
            add = itemView.findViewById(R.id.baddress);
            iv = itemView.findViewById(R.id.bimg);
            btn = itemView.findViewById(R.id.bcall);



        }
    }

}
