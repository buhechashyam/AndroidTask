package com.example.materialuicomponent.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialuicomponent.R;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ProductViewHolder> {

   String[] listOfProduct;

    public SimpleAdapter(String[] lists) {
        this.listOfProduct = lists;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple,parent,false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.tv.setText(listOfProduct[position]);
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.rv_item_animation));


    }

    @Override
    public int getItemCount() {
        return listOfProduct.length;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tv ;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.product_name);


        }
    }
}
