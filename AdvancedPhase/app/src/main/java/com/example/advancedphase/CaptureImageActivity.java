package com.example.advancedphase;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.advancedphase.databinding.ActivityCaptureImageBinding;

public class CaptureImageActivity extends AppCompatActivity {
    ActivityCaptureImageBinding binding;
    ActivityResultLauncher<Intent> mCapturePhoto = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Bundle bundle = result.getData().getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            binding.imageCapture.setImageBitmap(bitmap);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCaptureImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnClickImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CaptureImageActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CaptureImageActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_MEDIA_IMAGES}, 100);
                } else {
                    Toast.makeText(CaptureImageActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    captureImage();
                }
            }
        });
    }

    public void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mCapturePhoto.launch(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(CaptureImageActivity.this, "Camara Permission Granted", Toast.LENGTH_LONG).show();
                captureImage();
            } else {
                Toast.makeText(CaptureImageActivity.this, "Camara Permission Denied", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(CaptureImageActivity.this, "Image Access Permission Granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(CaptureImageActivity.this, "Image Access Permission Denied", Toast.LENGTH_LONG).show();
            }
        }
    }
}