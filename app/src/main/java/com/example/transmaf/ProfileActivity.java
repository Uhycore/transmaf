package com.example.transmaf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtNamaPetugas;
    private TextView txtShiftPetugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Bind views
        txtNamaPetugas = findViewById(R.id.txtNamaPetugas);
        txtShiftPetugas = findViewById(R.id.txtShiftPetugas);

        // Safety check
        if (txtNamaPetugas == null || txtShiftPetugas == null) {
            Toast.makeText(this, "TextView tidak ditemukan. Periksa XML.", Toast.LENGTH_LONG).show();
            return;
        }

        // Set data petugas
        txtNamaPetugas.setText("Maria Yesinta");
        txtShiftPetugas.setText("Shift Pagi");

        // Navigation bar
        LinearLayout menuHome = findViewById(R.id.menuHome);
        LinearLayout menuTravel = findViewById(R.id.menuTravel);
        LinearLayout menuHistory = findViewById(R.id.menuHistory);
        LinearLayout menuProfile = findViewById(R.id.menuProfile);

        menuHome.setOnClickListener(v -> startActivity(new Intent(this, DashboardActivity.class)));
        menuTravel.setOnClickListener(v -> startActivity(new Intent(this, TravelActivity.class)));
        menuHistory.setOnClickListener(v -> startActivity(new Intent(this, HistoryActivity.class)));

        // Profile sendiri, beri toast
        menuProfile.setOnClickListener(v ->
                Toast.makeText(this, "Anda sudah di halaman Profile", Toast.LENGTH_SHORT).show());
    }
}
