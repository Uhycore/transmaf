package com.example.transmaf.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transmaf.R;

public class RegisterActivity extends AppCompatActivity {

    EditText etNewUsername, etNewEmail, etNewPassword, etConfirmPassword;
    Button btnSave;
    TextView tvBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etNewUsername = findViewById(R.id.etNewUsername);
        etNewEmail = findViewById(R.id.etNewEmail);
        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSave = findViewById(R.id.btnSave);
        tvBackToLogin = findViewById(R.id.tvBackToLogin);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etNewUsername.getText().toString().trim();
                String email = etNewEmail.getText().toString().trim();
                String pass = etNewPassword.getText().toString().trim();
                String confirm = etConfirmPassword.getText().toString().trim();

                if (user.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Lengkapi semua kolom!", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(confirm)) {
                    Toast.makeText(RegisterActivity.this, "Password tidak cocok!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Akun berhasil dibuat untuk " + user + " 🎉", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        tvBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
