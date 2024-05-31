package com.example.materialuicomponent.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product);

        ImageView imgProductImg = findViewById(R.id.img);
        TextView tvProductName = findViewById(R.id.tv_name);
        TextView tvProductPrice = findViewById(R.id.tv_price);

        Intent intent = getIntent();

        String productName = intent.getStringExtra("product_name");
        int productImg = intent.getIntExtra("product_img", R.drawable.img1);
        int productPrice = intent.getIntExtra("product_price", 0);

        imgProductImg.setImageResource(productImg);
        tvProductName.setText(productName.toString());
        tvProductPrice.setText("Rs." + productPrice);


    }
}