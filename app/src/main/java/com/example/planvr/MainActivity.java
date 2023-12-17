package com.example.planvr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.pbar1);

        // Simulate a task that takes some time
        simulateTask();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, homepage.class);
                startActivity(i);
            }
        },4000);
    }
    private void simulateTask() {
        // Show the progress bar
        progressBar.setVisibility(View.VISIBLE);

        // Total duration of the task in milliseconds
        final int totalDuration = 3000;

        // Duration for each progress update
        final int updateInterval = totalDuration / 3;

        // Simulate a background task
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Update at 25%
                    Thread.sleep(updateInterval);
                    updateProgressBar(25);

                    // Update at 50%
                    Thread.sleep(updateInterval);
                    updateProgressBar(50);

                    // Update at 100%
                    Thread.sleep(updateInterval);
                    updateProgressBar(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updateProgressBar(final int progress) {
        // Update the UI on the main thread
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                // Set the progress
                progressBar.setProgress(progress);

                // If the progress is 100%, hide the progress bar
                if (progress == 100) {
                   // progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}