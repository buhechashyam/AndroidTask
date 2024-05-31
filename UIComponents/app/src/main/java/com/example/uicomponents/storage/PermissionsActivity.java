package com.example.uicomponents.storage;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.uicomponents.R;

import java.io.File;
import java.io.FileOutputStream;

public class PermissionsActivity extends AppCompatActivity {
    private static final int READ_STATUS_CODE = 100;
    private static final int WRITE_STATUS_CODE = 101;

    private Button mButtonStoragePermission, mButtonSaveImageToInternal;
    private ImageView mImageView;

    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE, Manifest.permission.INTERNET};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        mButtonStoragePermission = findViewById(R.id.btn_storage_permission);
        mButtonSaveImageToInternal = findViewById(R.id.btn_save_image);
        mImageView = findViewById(R.id.img);

        mButtonStoragePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_STATUS_CODE);
            }
        });

        mButtonSaveImageToInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageToInternalStorage();
            }
        });
    }

    //write image from internal storage
    private void saveImageToInternalStorage() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) mImageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File dir = cw.getDir("MyImages", Context.MODE_PRIVATE);

        File filePath = new File(dir, System.currentTimeMillis() + "jpg");
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();
            Toast.makeText(PermissionsActivity.this, "Image saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkPermission(String permission, int requestCode) {

        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, permissions, requestCode);
        } else {
            Toast.makeText(this, "Permission Aleready Granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_STATUS_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "WRITE Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "WRITE Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == READ_STATUS_CODE) {
            if (grantResults.length > 0 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "READ Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "READ Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}