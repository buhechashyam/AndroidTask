package com.example.ecommerceapp_webservice.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommerceapp_webservice.databinding.FragmentCartBinding;
import com.example.ecommerceapp_webservice.model.PostProductModel;
import com.example.ecommerceapp_webservice.viewmodel.ProductViewModel;

import java.util.Arrays;
import java.util.List;


public class CartFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    FragmentCartBinding binding;
    String mSpinnerSelectedItem = "";
    List<String> list = Arrays.asList("Men", "Women", "electronics","jewelery");
    ProductViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(getLayoutInflater());

        String mProductName = binding.etProductName.getText().toString();
        String mProductPrice = binding.etPrice.getText().toString();
        String mProductDesc = binding.etDescription.getText().toString();
        String mProductCategory = mSpinnerSelectedItem;

        binding.spnCategory.setOnItemSelectedListener(this);

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        binding.spnCategory.setAdapter(adapter);

        binding.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mProductName != null && mProductDesc != null && mProductCategory != null & mProductPrice != null) {
                    PostProductModel product = new PostProductModel(mProductName,"1222.0",mProductDesc,"image",mProductCategory);
                    addProduct(product);
                }else {
                    Toast.makeText(getContext(),"Please add products details",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerSelectedItem = list.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addProduct(PostProductModel product) {
        viewModel.addProduct(product).observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Toast.makeText(getContext(), "Product Added Successfully!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(),"Try again!....",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}