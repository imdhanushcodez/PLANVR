package com.example.planvr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class costest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costest);
    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(costest.this,menupage.class);
        startActivity(i);
    }
}