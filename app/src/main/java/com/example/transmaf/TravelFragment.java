package com.example.transmaf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TravelFragment extends Fragment {

    private ImageView imgCameraResult;
    private TextView txtCameraTime;
    private Button btnCameraFragment;

    private TextView txtWaktuBerangkat;
    private Button btnUpdateBerangkat;

    private TextView txtWaktuSampai;
    private Button btnSampaiBalai;

    private ActivityResultLauncher<Intent> cameraLauncher;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        // === AMBIL VIEW DARI XML ===
        imgCameraResult = view.findViewById(R.id.imgCameraResult);
        txtCameraTime = view.findViewById(R.id.txtCameraTime);
        btnCameraFragment = view.findViewById(R.id.btnCameraFragment);

        txtWaktuBerangkat = view.findViewById(R.id.txtWaktuBerangkat);
        btnUpdateBerangkat = view.findViewById(R.id.btnUpdateBerangkat);

        txtWaktuSampai = view.findViewById(R.id.txtWaktuSampai);
        btnSampaiBalai = view.findViewById(R.id.btnSampaiBalai);

        // === CAMERA LAUNCHER ===
        setupCameraLauncher();

        btnCameraFragment.setOnClickListener(v -> openCamera());
        btnUpdateBerangkat.setOnClickListener(v -> updateWaktuBerangkat());
        btnSampaiBalai.setOnClickListener(v -> updateWaktuSampai());

        return view;
    }


    // ============================================
    //              UPDATE WAKTU SAMPAI
    // ============================================
    private void updateWaktuSampai() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());

        txtWaktuSampai.setText("Waktu: " + currentTime);
        btnSampaiBalai.setEnabled(false);
        btnSampaiBalai.setText("Selesai ✔");

        Toast.makeText(getContext(), "Perjalanan selesai, waktu tersimpan!", Toast.LENGTH_SHORT).show();
    }


    // ============================================
    //              UPDATE WAKTU BERANGKAT
    // ============================================
    private void updateWaktuBerangkat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());

        txtWaktuBerangkat.setText("Waktu: " + currentTime);

        btnUpdateBerangkat.setEnabled(false);
        btnUpdateBerangkat.setText("Berangkat ✔");

        Toast.makeText(getContext(), "Waktu berangkat diperbarui!", Toast.LENGTH_SHORT).show();
    }


    // ============================================
    //                  CAMERA
    // ============================================
    private void setupCameraLauncher() {
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();
                        Bitmap photo = (Bitmap) data.getExtras().get("data");

                        imgCameraResult.setImageBitmap(photo);

                        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                                .format(new Date());

                        txtCameraTime.setText("Waktu: " + time);

                        Toast.makeText(getContext(), "Foto berhasil diambil!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(intent);
    }
}

