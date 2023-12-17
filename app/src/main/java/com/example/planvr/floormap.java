package com.example.planvr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class floormap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floormap);
    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(floormap.this,menupage.class);
        startActivity(i);
    }
}