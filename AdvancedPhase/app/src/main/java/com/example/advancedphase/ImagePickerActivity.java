package com.example.advancedphase;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedphase.databinding.ActivityImagePickerBinding;

import java.util.List;

public class ImagePickerActivity extends AppCompatActivity {
    ActivityImagePickerBinding binding;
    //Pick A Video and Set in VideoView
    ActivityResultLauncher<PickVisualMediaRequest> pickVideoMediaLauncher = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    binding.videoView.setVideoURI(uri);

                    binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                }
            });
    //Pick A Single Image and Set in ImageView
    ActivityResultLauncher<PickVisualMediaRequest> pickImageMediaLauncher = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri uri) {
            binding.imgUser.setImageURI(uri);
        }
    });
    //Pick A Multiple Images and set into multiple ImagesViews
    ActivityResultLauncher<PickVisualMediaRequest> pickMultipleImagesLauncher = registerForActivityResult(new ActivityResultContracts.PickMultipleVisualMedia(3), new ActivityResultCallback<List<Uri>>() {
        @Override
        public void onActivityResult(List<Uri> uris){
            binding.imageFirst.setImageURI(uris.get(0));
            binding.imageSecond.setImageURI(uris.get(1));
            binding.imageThird.setImageURI(uris.get(2));
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityImagePickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPickImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageMediaLauncher.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            }
        });
        binding.btnPickVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pickVideoMediaLauncher.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE).build());
            }
        });

        binding.btnSelectMultipleImages.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              pickMultipleImagesLauncher.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            }
        });
    }
}