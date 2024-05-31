package com.example.ecommerceapp_webservice.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.Product;
import com.example.ecommerceapp_webservice.view.activity.ProductActivity;


import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> products;
    Context context;

     public ProductAdapter(ArrayList<Product> lists, Context c ) {
         this.products = lists;
         this.context = c;
     }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product,parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);


        Glide.with(context).load(product.getImage()).fitCenter().into(holder.productImg);
         holder.setProductName(product.getTitle());
         holder.setProductPrice("$." + product.getPrice());

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Toast.makeText(context, product.getTitle() + " Clicked...", Toast.LENGTH_SHORT).show();

                 Intent intent = new Intent(context, ProductActivity.class);
                 intent.putExtra("name",product.getTitle());
                 intent.putExtra("desc",product.getDescription());
                 intent.putExtra("price", String.valueOf(product.getPrice()));
                 intent.putExtra("image_url",product.getImage());
                 intent.putExtra("category",product.getCategory());
                 context.startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImg;
         TextView productName;
         TextView productPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = (ImageView) itemView.findViewById(R.id.img_product);
            productName = (TextView) itemView.findViewById(R.id.tv_product_name);
            productPrice = (TextView) itemView.findViewById(R.id.tv_product_price);
        }

        private void setProductImg(int img) {
            productImg.setImageResource(img);
        }
        private void setProductName(String name) {
            productName.setText(name);
        }
        private void setProductPrice(String price) {
            productPrice.setText(price);
        }
    }
}
