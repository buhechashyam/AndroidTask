package com.example.uicomponents.storage;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorageActivity extends AppCompatActivity {

    private Button mButtonWriteData, mButtonReadData, mButtonSaveImageToInternal, mButtonReadImageFromInternal;
    private EditText mEditTextWriteData, mEditTextFileName;
    private ImageView mImageViewFirst, mImageViewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        initView();

        mButtonWriteData.setOnClickListener(v -> writeData());
        mButtonReadData.setOnClickListener(v -> readData());

        mButtonSaveImageToInternal.setOnClickListener(v -> saveImageToInternalStorage());
        mButtonReadImageFromInternal.setOnClickListener(v -> readImageFromInternalStorage());
    }
    //write img in internal storage
    private void saveImageToInternalStorage() {
       Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img2);

       ContextWrapper cw= new ContextWrapper(getApplicationContext());
       File dir = cw.getDir("MyImages",Context.MODE_PRIVATE);

       File file = new File(dir,"myimg.jpg");

       try {
           FileOutputStream fos = new FileOutputStream(file);
           bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos);
           Toast.makeText(InternalStorageActivity.this, "Image saved", Toast.LENGTH_SHORT).show();
           fos.close();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    //read image from internal storage
    private void readImageFromInternalStorage() {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File dir = cw.getDir("MyImages", Context.MODE_PRIVATE);
        File filePath = new File(dir, "img.jpg");
        mImageViewSecond.setImageDrawable(Drawable.createFromPath(filePath.toString()));
    }

    private void writeData() {
        String filename = mEditTextFileName.getText().toString();
        String data = mEditTextWriteData.getText().toString();
        try {
         //MODE_PRIVATE - override a data, MODE_APPEND - append new data with old data
            FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(this, "filename: " + filename + " data: " + data, Toast.LENGTH_LONG).show();
        } catch (IOException ioException) {
            Toast.makeText(this, "Data not stored. try Again...", Toast.LENGTH_LONG).show();
        }
    }

    private void readData() {
        String filename = mEditTextFileName.getText().toString();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                    openFileInput(filename)));
            String inputString;

            while ((inputString = inputReader.readLine()) != null) {
                stringBuilder.append(inputString + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        // Log.d("DATA",stringBuffer.toString());
        Toast.makeText(getApplicationContext(), stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }

    private void initView() {
        mButtonReadData = findViewById(R.id.btn_data_read);
        mButtonWriteData = findViewById(R.id.btn_data_write);
        mEditTextWriteData = findViewById(R.id.et_input_data);
        mEditTextFileName = findViewById(R.id.et_input_filename);

        mButtonSaveImageToInternal = findViewById(R.id.btn_save_image);
        mButtonReadImageFromInternal = findViewById(R.id.btn_read_image);
        mImageViewFirst = findViewById(R.id.img1);
        mImageViewSecond = findViewById(R.id.img2);
    }
}