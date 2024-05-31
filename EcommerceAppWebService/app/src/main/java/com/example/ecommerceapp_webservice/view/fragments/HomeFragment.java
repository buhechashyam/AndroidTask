package com.example.ecommerceapp_webservice.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.Categories;
import com.example.ecommerceapp_webservice.model.CategoryModel;
import com.example.ecommerceapp_webservice.model.Product;
import com.example.ecommerceapp_webservice.view.adapter.ProductAdapter;
import com.example.ecommerceapp_webservice.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    List<CategoryModel> mCateforyProductsList = new ArrayList<>();
    List<Product> mProducts = new ArrayList<>();
    List<Categories> mCategories = new ArrayList<>();
    ProductViewModel viewModel;

    RecyclerView mRecyclerViewProducts;
    SwipeRefreshLayout mSwipeRefreshLayout;

    ProductAdapter adapter;
    Toolbar mToolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerViewProducts = view.findViewById(R.id.recyclerview_home);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mToolbar = view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);


        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        adapter = new ProductAdapter(new ArrayList<>(), getContext());

        mCategories.add(new Categories("electronics"));
        mCategories.add(new Categories("jewelery"));
        mCategories.add(new Categories("men's clothing"));
        mCategories.add(new Categories("women's clothing"));

        mRecyclerViewProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));

        viewModel.getProductsList().observe(getViewLifecycleOwner(), products -> {
            mProducts = products;
            mRecyclerViewProducts.setAdapter(new ProductAdapter((ArrayList<Product>) mProducts, getContext()));

        });
        Log.d("MAIN", String.valueOf(mProducts.size()));


        viewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> categories) {
                mCategories = categories;
            }
        });


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.getProductsList().observe(getViewLifecycleOwner(), products -> {
                    mProducts = products;
                    mRecyclerViewProducts.setAdapter(new ProductAdapter((ArrayList<Product>) mProducts, getContext()));
                });
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.activity_home_toolbar,menu);

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String newText) {
        ArrayList<Product> filterProducts = new ArrayList<>();

        for (Product product : mProducts) {
            if (product.getTitle().contains(newText)){
                filterProducts.add(product);
            }
        }

        adapter = new ProductAdapter(filterProducts, getContext());
        mRecyclerViewProducts.setAdapter(adapter);
    }
}