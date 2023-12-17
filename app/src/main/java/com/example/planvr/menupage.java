package com.example.planvr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class menupage extends AppCompatActivity {
    ConstraintLayout floor,cost,vrpage,arpage;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);

        floor = findViewById(R.id.floorpage);
        cost = findViewById(R.id.costpage);


        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menupage.this, floormap.class);
                startActivity(i);
            }
        });

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menupage.this, costest.class);
                startActivity(i);
            }
        });



        vrpage = findViewById(R.id.vrpage);
        vrpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.PlanVR");
                if (intent != null) {
                    startActivity(intent);
                } else {
                    // VR app not installed
                    Toast.makeText(menupage.this, "VR app not installed", Toast.LENGTH_SHORT).show();
                }

                //GvrView gvrView = getGvrView();
               // gvrView.loadImageFromBitmap(my360ImageBitmap, options);

                //VrPanoramaView.Options options = new VrPanoramaView.Options();
                //gvrView.loadImageFromBitmap(my360ImageBitmap, options);
            }
        });


        arpage = findViewById(R.id.arpage);
        arpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://lakshman1arun.github.io/test/"));

                // Start the activity (web browser) with the Intent
                startActivity(intent);

            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(menupage.this,homepage.class);
        startActivity(i);
    }
}