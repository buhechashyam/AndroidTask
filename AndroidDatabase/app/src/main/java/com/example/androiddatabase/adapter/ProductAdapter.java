package com.example.androiddatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddatabase.R;
import com.example.androiddatabase.roomdb.entity.ProductEntity;
import com.example.androiddatabase.view.room.EditProductActivity;
import com.example.androiddatabase.viewmodel.MainViewModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductEntity> mListOfProduct;
    Context mContext;
    MainViewModel viewModel;


    public ProductAdapter(List<ProductEntity> mListOfProduct, Context mContext, MainViewModel viewModel) {
        this.mListOfProduct = mListOfProduct;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductEntity product = mListOfProduct.get(position);
        holder.mTextViewProductName.setText(product.getProductName());
        holder.mTextViewProductDesc.setText(product.getProductDescription());
        holder.mTextViewProductPrice.setText(product.getProductPrice());

        holder.mButtonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteProduct(product);
                int p = holder.getAdapterPosition();
                mListOfProduct.remove(p);
                notifyItemRemoved(p);
            }
        });

        holder.mButtonEditItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditProductActivity.class);
                intent.putExtra("name",product.getProductName());
                intent.putExtra("id",product.getId());
                intent.putExtra("desc",product.getProductDescription());
                intent.putExtra("price",product.getProductPrice());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListOfProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewProductName, mTextViewProductDesc, mTextViewProductPrice;
        ImageButton mButtonDeleteItem, mButtonEditItem;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewProductName = itemView.findViewById(R.id.text_product_name);
            mTextViewProductDesc = itemView.findViewById(R.id.text_product_decs);
            mTextViewProductPrice = itemView.findViewById(R.id.text_product_price);
            mButtonDeleteItem = itemView.findViewById(R.id.btn_item_delete);
            mButtonEditItem = itemView.findViewById(R.id.btn_item_edit);

        }
    }

}
