package com.example.materialuicomponent.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.recyclerview.OnClickListener;
import com.example.materialuicomponent.recyclerview.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> products;
    Context context;
    OnClickListener onClickListener;

     public ProductAdapter(ArrayList<Product> lists, Context c, OnClickListener onClickListener) {
         this.products = lists;
         this.context = c;
         this.onClickListener = onClickListener;
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
         holder.setProductImg(product.getProductImg());
         holder.setProductName(product.getProductName());
         holder.setProductPrice("Rs." + product.getProductPrice());

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onClickListener.onClick(product);
                 Toast.makeText(context,  product.getProductName() +" Clicked...",Toast.LENGTH_SHORT).show();
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
