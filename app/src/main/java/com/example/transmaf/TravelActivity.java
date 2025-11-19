package com.example.transmaf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TravelActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 101;
    private TravelFragment travelFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));

        // == Bottom Menu ==
        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuTravel = findViewById(R.id.menuTravel);
        LinearLayout menuHistory = findViewById(R.id.menuHistory);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);

        // Explicit Intent
        menuHome.setOnClickListener(v -> startActivity(new Intent(this, DashboardActivity.class)));
        menuHistory.setOnClickListener(v -> startActivity(new Intent(this, HistoryActivity.class)));
        menuProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        menuTravel.setOnClickListener(v -> Toast.makeText(this, "Kamu sudah di halaman Travel", Toast.LENGTH_SHORT).show());

        // == Load Fragment ==
        travelFragment = new TravelFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerTravel, travelFragment)
                .commit();


    }


}
