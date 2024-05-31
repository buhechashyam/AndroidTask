package com.example.ecommerceapp_webservice.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.ProductModel;
import com.example.ecommerceapp_webservice.utils.Utils;
import com.example.ecommerceapp_webservice.view.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductFragment extends Fragment {

    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

//        RecyclerView mRecyclerViewProducts = view.findViewById(R.id.recyclerview_products);
//        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
//
//        Bundle bundle = getArguments();
//        String argument = bundle.getString("category");
//        Log.d("MAIN",argument);
//
//        Utils utils = new Utils();
//        List<ProductModel> allProducts = utils.getmProducts();
//
//        List<ProductModel> products = allProducts.stream().filter(productModel -> productModel.getmCategoryName() == argument).collect(Collectors.toList());
//        Log.d("MAIN", String.valueOf(products.size()));
//
//        ProductAdapter adapter = new ProductAdapter((ArrayList<ProductModel>) products,getContext());
//
//        mRecyclerViewProducts.setAdapter(adapter);
//        mRecyclerViewProducts.setLayoutManager(new GridLayoutManager(getContext(),2));
//
//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                adapter.notifyDataSetChanged();
//                mSwipeRefreshLayout.setRefreshing(false);
//            }
//        });
        return view;
    }
}