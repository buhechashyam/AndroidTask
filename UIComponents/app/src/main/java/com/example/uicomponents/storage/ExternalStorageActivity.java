package com.example.uicomponents.storage;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.uicomponents.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorageActivity extends AppCompatActivity {
    EditText mEditTextInputText;
    TextView mTextViewResponse;
    Button mButtonSave, mButtonRead;
    Button mButtonSaveImgToExternalStorage, mButtonReadImgToExternalStorage;

    ImageView mImageViewReadImg;
    StringBuilder myData = new StringBuilder("");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        mEditTextInputText = (EditText) findViewById(R.id.myInputText);
        mTextViewResponse = (TextView) findViewById(R.id.response);
        mButtonSaveImgToExternalStorage = findViewById(R.id.saveImgExternalStorage);
        mButtonReadImgToExternalStorage = findViewById(R.id.getImgExternalStorage);
        mImageViewReadImg = findViewById(R.id.img_read);

        mButtonSaveImgToExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExternalStorageActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ExternalStorageActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    // Save image to external storage
                    String fileName = "img2.png";
                    boolean success = saveImageToExternalStorage(getApplicationContext(), R.drawable.img2, fileName);
                    if (success) {
                        Toast.makeText(ExternalStorageActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ExternalStorageActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mButtonReadImgToExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File imageFile = new File(directory, "img2.png");

                try {
                    FileInputStream fis = new FileInputStream(imageFile);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    mImageViewReadImg.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonSave = (Button) findViewById(R.id.saveExternalStorage);
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a file in external directory
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                File file = new File(dir, "hello.txt");
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(mEditTextInputText.getText().toString().getBytes());
                    fos.close();
                    mTextViewResponse.setText("Text file saved to External Storage.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mEditTextInputText.setText("");

            }
        });

        mButtonRead = (Button) findViewById(R.id.getExternalStorage);

        //read file
        mButtonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                File file = new File(dir, "hello.txt");

                try {
                    FileInputStream fis = new FileInputStream(file);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        myData.append(strLine);
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mTextViewResponse.setText(myData);
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            mButtonSave.setEnabled(false);
        } else {
        }
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Save image to external storage
                String fileName = "img4.png"; // Name for the image file
                boolean success = saveImageToExternalStorage(getApplicationContext(), R.drawable.img4, fileName);
                if (success) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Permission is Required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean saveImageToExternalStorage(Context context, int imageResourceId, String fileName) {
        // Check if external storage is available and writable
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return false;
        }

        File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imageFile = new File(directory, fileName);

        // Load the image from resources
        Bitmap imageBitmap = BitmapFactory.decodeResource(context.getResources(), imageResourceId);

        try {
            // Write the bitmap to the file
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}