package com.example.materialuicomponent.recyclerview.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.recyclerview.OnClickListener;
import com.example.materialuicomponent.recyclerview.adapter.ProductAdapter;
import com.example.materialuicomponent.recyclerview.model.Product;

import java.util.ArrayList;

public class CustomRVActivity extends AppCompatActivity implements OnClickListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerViewProducts;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_rvactivity);

        mRecyclerViewProducts = findViewById(R.id.recyclerview);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        products = getData();
        ProductAdapter adapter = new ProductAdapter(products, CustomRVActivity.this, this::onClick);
        mRecyclerViewProducts.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        mRecyclerViewProducts.setAdapter(adapter);
        mRecyclerViewProducts.setHasFixedSize(true);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(){
                products.add(new Product(R.drawable.img1, "Men's Regular Fit Graphic T-Shirt", 499));
                products.add(new Product(R.drawable.img2, "Men T-Shirt", 499));
                products.add(new Product(R.drawable.img3, "Men's Regular Fit Brand Logo T-Shirt", 499));

                adapter.notifyDataSetChanged();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public ArrayList<Product> getData() {
        ArrayList<Product> data = new ArrayList<Product>();

        data.add(new Product(R.drawable.img1, "Men's Regular Fit Graphic T-Shirt", 435));
        data.add(new Product(R.drawable.img2, "Men T-Shirt", 2));
        data.add(new Product(R.drawable.img3, "Men's Regular Fit Brand Logo T-Shirt", 654));
        data.add(new Product(R.drawable.img4, "Men's Regular Fit Brand Logo T-Shirt", 499));
        data.add(new Product(R.drawable.img6, "Men's Regular Fit Polo Shirt", 549));
        data.add(new Product(R.drawable.img7, "Abstract Print Cotton Polo Shirt", 999));
        data.add(new Product(R.drawable.img8, "Men Yellow Tartan Check Cotton Casual Shirt", 879));
        data.add(new Product(R.drawable.img1, "Men Dark Blue Tartan Check Manhattan Slim Fit Casual Shirt", 749));
        data.add(new Product(R.drawable.img2, "Men's Slim Fit Shirt", 599));
        data.add(new Product(R.drawable.img3, "Men Navy Striped Collar Solid Cotton Polo Shirt", 1299));
        data.add(new Product(R.drawable.img4, "Men Button Down Shirt", 849));
        data.add(new Product(R.drawable.img5, "Men's Regular Fit Brand Logo T-Shirt", 599));
        data.add(new Product(R.drawable.img1, "Men's Regular Fit Graphic T-Shirt", 435));
        data.add(new Product(R.drawable.img2, "Men T-Shirt", 2));
        data.add(new Product(R.drawable.img3, "Men's Regular Fit Brand Logo T-Shirt", 654));
        data.add(new Product(R.drawable.img4, "Men's Regular Fit Brand Logo T-Shirt", 499));
        data.add(new Product(R.drawable.img6, "Men's Regular Fit Polo Shirt", 549));
        data.add(new Product(R.drawable.img7, "Abstract Print Cotton Polo Shirt", 999));
        data.add(new Product(R.drawable.img8, "Men Yellow Tartan Check Cotton Casual Shirt", 879));
        data.add(new Product(R.drawable.img1, "Men Dark Blue Tartan Check Manhattan Slim Fit Casual Shirt", 749));
        data.add(new Product(R.drawable.img2, "Men's Slim Fit Shirt", 599));
        data.add(new Product(R.drawable.img3, "Men Navy Striped Collar Solid Cotton Polo Shirt", 1299));
        data.add(new Product(R.drawable.img4, "Men Button Down Shirt", 849));
        data.add(new Product(R.drawable.img5, "Men's Regular Fit Brand Logo T-Shirt", 599));
        return data;
    }

    @Override
    public void onClick(Product product) {

        Intent intent = new Intent(this, ProductActivity.class);
        Log.d("MAIN", product.toString());
        intent.putExtra("product_name", product.getProductName());
        intent.putExtra("product_img", product.getProductImg());
        intent.putExtra("product_price", product.getProductPrice());
        startActivity(intent);
    }
}