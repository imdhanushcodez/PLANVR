package com.example.planvr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class builderviewpage extends AppCompatActivity {

    RecyclerView rc;
    ArrayList<builderdata> list;
    builderadapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builderviewpage);

        rc = findViewById(R.id.buidrc);

        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(builderviewpage.this));
        list = new ArrayList<>();

        list.add(new builderdata(R.drawable.builder1,"BUILDING CONSTRUCTIONS","porur,chennai - 12","8973645887"));
        list.add(new builderdata(R.drawable.builder2,"STACKCY DEVELOPERS","tambaram,chennai - 69","8973645887"));
        list.add(new builderdata(R.drawable.builder3,"ENNIS ROOFING","madurayol,chennai - 19","8973645887"));
        list.add(new builderdata(R.drawable.builder4,"PARKEO CONSTRUCTYIONS","ECR,chennai - 43","8973645887"));




        adapter = new builderadapter(builderviewpage.this,list);
        rc.setAdapter(adapter);
    }
}