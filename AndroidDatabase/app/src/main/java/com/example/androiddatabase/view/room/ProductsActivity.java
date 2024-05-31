package com.example.androiddatabase.view.room;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androiddatabase.adapter.ProductAdapter;
import com.example.androiddatabase.databinding.ActivityProductsBinding;
import com.example.androiddatabase.roomdb.entity.ProductEntity;
import com.example.androiddatabase.viewmodel.MainViewModel;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private ActivityProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("PRODUCTS");

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.recyclerviewProducts.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getAllProducts().observe(this, new Observer<List<ProductEntity>>() {
            @Override
            public void onChanged(List<ProductEntity> productEntities) {
                binding.recyclerviewProducts.setAdapter(new ProductAdapter(productEntities, ProductsActivity.this,viewModel));
            }
        });

        binding.btnAdd.setOnClickListener(v -> startActivity(new Intent(ProductsActivity.this, AddProductActivity.class)));
    }
}