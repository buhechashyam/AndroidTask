package com.example.androiddatabase.view.room;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.androiddatabase.databinding.ActivityAddProductBinding;
import com.example.androiddatabase.roomdb.entity.ProductEntity;
import com.example.androiddatabase.viewmodel.MainViewModel;

public class AddProductActivity extends AppCompatActivity {

    ActivityAddProductBinding binding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("ADD PRODUCT");

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductEntity mProduct = new ProductEntity(binding.etProductName.getText().toString(),binding.etProductDesc.getText().toString(),binding.etProductPrice.getText().toString());

                viewModel.addProduct(mProduct);

                binding.etProductDesc.setText("");
                binding.etProductName.setText("");
                binding.etProductPrice.setText("");
            }
        });
    }
}

////Executer Thread
//ExecutorService service = Executors.newSingleThreadExecutor();
//
//Handler handler = new Handler(Looper.getMainLooper());

//             service.execute(new Runnable() {
//    @Override
//    public void run() {
//
////                        runOnUiThread(new Runnable() {
////                            @Override
////                            public void run() {
////                                productDao.addProduct(product);
////
////                            }
////                        });
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                productDao.addProduct(product);
//
//            }
//        });
//    }
//});