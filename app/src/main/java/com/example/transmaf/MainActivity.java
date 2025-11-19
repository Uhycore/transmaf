package com.example.transmaf;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));

        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuTravel = findViewById(R.id.menuTravel);
        LinearLayout menuHistory = findViewById(R.id.menuHistory);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);


        replaceFragment(new DashboardFragment());

        menuHome.setOnClickListener(v -> replaceFragment(new DashboardFragment()));
        menuTravel.setOnClickListener(v -> replaceFragment(new TravelFragment()));
        menuHistory.setOnClickListener(v -> replaceFragment(new HistoryFragment()));
        menuProfile.setOnClickListener(v -> replaceFragment(new ProfileFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .commit();
    }
}
