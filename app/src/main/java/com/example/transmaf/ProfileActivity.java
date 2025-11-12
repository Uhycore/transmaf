package com.example.transmaf; // ganti sesuai package kamu

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));


        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuTravel = findViewById(R.id.menuTravel);
        LinearLayout menuHistory = findViewById(R.id.menuHistory);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);

        menuHome.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        menuTravel.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, TravelActivity.class);
            startActivity(intent);
        });

        menuHistory.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        menuProfile.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
