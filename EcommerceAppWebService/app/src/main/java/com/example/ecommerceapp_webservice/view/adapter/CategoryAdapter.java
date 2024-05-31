package com.example.ecommerceapp_webservice.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.CategoryModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public CategoryAdapter(Context context, List<CategoryModel> mListOfCategory) {
        this.context = context;
        this.mListOfCategory = mListOfCategory;
    }

    Context context;
    List<CategoryModel> mListOfCategory;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categoty,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel mCategory = mListOfCategory.get(position);
        holder.mTextViewCategoryName.setText(mCategory.getmCategory());

        ProductCategoryAdapter adapter = new ProductCategoryAdapter(context, mCategory.getmCategoryList());
        holder.mRecyclerViewCategories.setLayoutManager(new GridLayoutManager(context, 3));
        holder.mRecyclerViewCategories.setAdapter(adapter);


    }

    @Override
    public int getItemCount() {
        return mListOfCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewCategoryName;
        RecyclerView mRecyclerViewCategories;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewCategoryName = itemView.findViewById(R.id.text_category_name);
            mRecyclerViewCategories = itemView.findViewById(R.id.recyclerview_product_categories);
        }
    }
}
