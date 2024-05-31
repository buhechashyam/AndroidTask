package com.example.ecommerceapp_webservice.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.PostProductModel;
import com.example.ecommerceapp_webservice.model.Product;
import com.example.ecommerceapp_webservice.viewmodel.ProductViewModel;


public class CategoryFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        Button mButtonPutRequest = view.findViewById(R.id.btn_put_request);

        mButtonPutRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.updateProduct(7,new PostProductModel("test product","13.5","This is Product","'https://i.pravatar.cc","electronic")).observe(getViewLifecycleOwner(), new Observer<Product>() {
                    @Override
                    public void onChanged(Product product) {
                        Log.d("TAG", product.getTitle());
                        Log.d("TAG", String.valueOf(product.getid()));
                        Log.d("TAG", product.getCategory());
                        Log.d("TAG", String.valueOf(product.getPrice()));
                    }
                });
            }
        });

        return view;
    }
}