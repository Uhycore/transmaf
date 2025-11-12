package com.example.transmaf;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HistoryActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));


        tvResult = findViewById(R.id.tvResult);

        new Thread(this::fetchUsers).start();

        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuTravel = findViewById(R.id.menuTravel);
        LinearLayout menuHistory = findViewById(R.id.menuHistory);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);

        menuHome.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        menuTravel.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryActivity.this, TravelActivity.class);
            startActivity(intent);
        });

        menuHistory.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        menuProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }

    private void fetchUsers() {
        try {
            URL url = new URL("https://api-mobile.tpqaril.co-id.id/api/v1/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            runOnUiThread(() -> tvResult.setText(response.toString()));

        } catch (Exception e) {
            Log.e("API_ERROR", e.toString());
            runOnUiThread(() ->
                    tvResult.setText("Gagal mengambil data 😭\n" + e.getMessage())
            );
        }
    }
}
