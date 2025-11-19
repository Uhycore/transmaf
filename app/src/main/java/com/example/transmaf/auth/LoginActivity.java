package com.example.transmaf.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.transmaf.DashboardActivity;
import com.example.transmaf.R;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi View
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin    = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);

        // Tombol Login
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty()) {
                etUsername.setError("Username wajib diisi");
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Password wajib diisi");
                return;
            }

            // Login sederhana (contoh)
            if (username.equals("admin") && password.equals("12345")) {

                Toast.makeText(LoginActivity.this,
                        "Login berhasil!", Toast.LENGTH_SHORT).show();

                // Pindah ke halaman utama
                Intent intent = new Intent(LoginActivity.this,
                        DashboardActivity.class);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(LoginActivity.this,
                        "Username atau password salah",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Tombol Daftar
        txtRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,
                    RegisterActivity.class);
            startActivity(intent);
        });
    }
}
