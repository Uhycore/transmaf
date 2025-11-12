package com.example.transmaf;// ganti sesuai package kamu

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class TravelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));


        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuTravel = findViewById(R.id.menuTravel);
        LinearLayout menuHistory = findViewById(R.id.menuHistory);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);

        menuHome.setOnClickListener(v -> {
            Intent intent = new Intent(TravelActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        menuTravel.setOnClickListener(v -> {
            Intent intent = new Intent(TravelActivity.this, TravelActivity.class);
            startActivity(intent);
        });

        menuHistory.setOnClickListener(v -> {
            Intent intent = new Intent(TravelActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        menuProfile.setOnClickListener(v -> {
            Intent intent = new Intent(TravelActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
