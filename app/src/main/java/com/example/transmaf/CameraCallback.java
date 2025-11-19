package com.example.transmaf;

import android.graphics.Bitmap;

public interface CameraCallback {
    void onCameraCaptured(Bitmap bitmap, String time);
}
