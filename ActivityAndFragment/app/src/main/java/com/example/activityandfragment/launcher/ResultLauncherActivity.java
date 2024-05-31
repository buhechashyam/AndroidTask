package com.example.activityandfragment.launcher;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.activityandfragment.R;
import com.example.activityandfragment.SecondActivity;

public class ResultLauncherActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mButtonPickImage, mButtonGetUserName, mButtonTakeImage;
    private TextView mTextViewUserName;



    ActivityResultLauncher<String> mPickImageLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri uri) {
            //set image using uri
            mImageView.setImageURI(uri);
        }
    });

    ActivityResultLauncher<Intent> mTakeImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                Bundle bundle = result.getData().getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                mImageView.setImageBitmap(bitmap);
            }
        }
    });
  ActivityResultLauncher<Intent> mGetProfileInformationLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
      @Override
      public void onActivityResult(ActivityResult result) {
          if (result.getResultCode() == Activity.RESULT_OK) {
              Intent data = result.getData();
              String USER_NAME = "UserName : " + data.getStringExtra("username");
              mTextViewUserName.setText(USER_NAME);
          }
      }
  });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_launcher);

        initView();

        mButtonPickImage.setOnClickListener(v -> {
            mPickImageLauncher.launch("image/*");
        });

        mButtonTakeImage.setOnClickListener(v -> {
            Intent takeImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            mTakeImageLauncher.launch(takeImageIntent);
        });

        mButtonGetUserName.setOnClickListener( v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            mGetProfileInformationLauncher.launch(intent);
        });
    }

    private void initView() {
        mImageView = findViewById(R.id.img);
        mButtonPickImage = findViewById(R.id.btn_pick_image);
        mTextViewUserName = findViewById(R.id.text_username);
        mButtonGetUserName = findViewById(R.id.btn_get_username);
        mButtonTakeImage = findViewById(R.id.btn_take_image);
    }
}