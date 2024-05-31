package com.example.androiddatabase.view.room;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.androiddatabase.databinding.ActivityEditProductBinding;
import com.example.androiddatabase.viewmodel.MainViewModel;

public class EditProductActivity extends AppCompatActivity {
    ActivityEditProductBinding binding;
    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Edit Product");

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        String mProductName = getIntent().getStringExtra("name");
        int mId = getIntent().getIntExtra("id",0);
        String mProductDesc = getIntent().getStringExtra("desc");
        String mProductPrice = getIntent().getStringExtra("price");

        binding.etProductName.setText(mProductName);
        binding.etProductDesc.setText(mProductDesc);
        binding.etProductPrice.setText(mProductPrice);

        binding.btnEditProduct.setOnClickListener(v -> {

            String mProductName1 = binding.etProductName.getText().toString();
            String mProductDesc1 = binding.etProductDesc.getText().toString();
            String mProductPrice1 = binding.etProductPrice.getText().toString();

            viewModel.updateProductById(mId, mProductName1, mProductDesc1, mProductPrice1);

            startActivity(new Intent(EditProductActivity.this, ProductsActivity.class));
        });
    }
}