package com.example.uicomponents.storage;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.uicomponents.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Android11Activity extends AppCompatActivity {
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(Android11Activity.this, "Write External Permission Granted.", Toast.LENGTH_SHORT).show();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android11);

        Button mButtonReadImagePermission = findViewById(R.id.btn_access_image_permission);
        Button mButtonWriteExternalPermission = findViewById(R.id.btn_access_write_permission);
        Button mButtonWriteTextFile = findViewById(R.id.btn_write_txt_file);
        Button mButtonSaveImage = findViewById(R.id.btn_save_image);


        mButtonWriteExternalPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (!Environment.isExternalStorageManager()) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse(String.format("package:%s", getApplicationContext().getPackageName())));
                        activityResultLauncher.launch(intent);
                    } else {
                        Toast.makeText(Android11Activity.this, "Write External Permission Already Granted.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mButtonReadImagePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(Android11Activity.this, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        ActivityCompat.requestPermissions(Android11Activity.this, new String[]{Manifest.permission.READ_MEDIA_IMAGES}, 10);
                    }
                } else {
                    Toast.makeText(Android11Activity.this, "Permission is already granted..", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //write external storage permission in Android 13
        mButtonWriteTextFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeTextFile();
            }
        });

        mButtonSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Android14
                saveImageTOExternalStorage();
            }
        });

    }

    private void saveImageTOExternalStorage() {
        String fileName = "img2.jpg";
        Context context = getApplicationContext();
        File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imageFile = new File(directory, fileName);

        // Load the image from resources
        Bitmap imageBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.img2);

        try {
            // Write the bitmap to the file
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void writeTextFile() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "sample2.txt");
        String data = "My Name is Shyam";
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data.getBytes());
            Toast.makeText(Android11Activity.this, "DATA IS STORED", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission is granted..", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission is not granted..", Toast.LENGTH_SHORT).show();

            }
        }
    }
}