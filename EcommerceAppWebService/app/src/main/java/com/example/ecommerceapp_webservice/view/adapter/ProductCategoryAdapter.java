package com.example.ecommerceapp_webservice.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.Product;
import com.example.ecommerceapp_webservice.view.fragments.ProductFragment;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {

    Context context;
    List<Product> mListProductCategories;

    public ProductCategoryAdapter(Context context, List<Product> mListProductCategories) {
        this.context = context;
        this.mListProductCategories = mListProductCategories;
    }

    @NonNull
    @Override
    public ProductCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product_category, parent, false);
        return new ProductCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryViewHolder holder, int position) {
        Product productCategory =mListProductCategories.get(position);
//        holder.mImageViewCategory.setImageResource(productCategory.getmCategoryImage());
        holder.mTextViewCategoryName.setText(productCategory.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category",productCategory.getTitle());
                ProductFragment productFragment = new ProductFragment();
                productFragment.setArguments(bundle);
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,productFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListProductCategories.size();
    }

    public class ProductCategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageViewCategory;
        TextView mTextViewCategoryName;
        public ProductCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewCategory = itemView.findViewById(R.id.image_category);
            mTextViewCategoryName = itemView.findViewById(R.id.text_category_name);
        }
    }
}
