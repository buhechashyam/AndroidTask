package com.example.ecommerceapp_webservice.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.xmlmodel.TrendingSearchItem;
import com.example.ecommerceapp_webservice.view.adapter.SearchTrendAdapter;
import com.example.ecommerceapp_webservice.viewmodel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;


public class AuthorsActivity extends AppCompatActivity {

    SearchViewModel viewModel;
    SearchTrendAdapter mSearchTrendAdapter;
    RecyclerView mRecyclerviewSearches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);

         mRecyclerviewSearches = findViewById(R.id.recyclerview_trend_searches);

         viewModel = new ViewModelProvider(AuthorsActivity.this).get(SearchViewModel.class);
         mSearchTrendAdapter = new SearchTrendAdapter(new ArrayList<TrendingSearchItem>(),this);

         mRecyclerviewSearches.setLayoutManager(new LinearLayoutManager(this));
         mRecyclerviewSearches.setAdapter(mSearchTrendAdapter);

         viewModel.getTrendSearchItems().observe(AuthorsActivity.this, new Observer<List<TrendingSearchItem>>() {
             @Override
             public void onChanged(List<TrendingSearchItem> trendingSearchItems) {
                 mSearchTrendAdapter.setNewList(trendingSearchItems);
             }
         });

    }
}