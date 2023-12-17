package com.example.planvr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class signuppage extends AppCompatActivity {
    ConstraintLayout btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        btn = findViewById(R.id.enterintoregpage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signuppage.this,regpage.class);
                startActivity(i);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(signuppage.this,loginpage.class);
        startActivity(i);
    }
}