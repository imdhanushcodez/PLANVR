package com.example.planvr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class homepage extends AppCompatActivity {

    RecyclerView rc;
    ArrayList<homepagedata> list;
    homepageadapter adapter;
    ImageView btn1,btn2;

    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        rc = findViewById(R.id.homerc);
        auth = FirebaseAuth.getInstance();

        btn1 = findViewById(R.id.logout);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(homepage.this,builderviewpage.class);
                startActivity(i);

            }
        });



        btn2 = findViewById(R.id.logoutt);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent i = new Intent(homepage.this,loginpage.class);
                startActivity(i);

            }
        });



        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(homepage.this));
        list = new ArrayList<>();

        list.add(new homepagedata(R.drawable.modernhome2,"PROJECT 1-VR501"));
        list.add(new homepagedata(R.drawable.modernhome,"PROJECT 2-VR502"));
        list.add(new homepagedata(R.drawable.villagerc,"PROJECT 3-VR503"));



        adapter = new homepageadapter(homepage.this,list);
        rc.setAdapter(adapter);





    }

    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
    }
}