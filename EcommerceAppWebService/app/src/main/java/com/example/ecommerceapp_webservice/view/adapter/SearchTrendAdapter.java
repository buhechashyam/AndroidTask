package com.example.ecommerceapp_webservice.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.xmlmodel.TrendingSearchItem;

import java.util.List;

public class SearchTrendAdapter extends RecyclerView.Adapter<SearchTrendAdapter.TrendSearchViewHolder> {

    List<TrendingSearchItem> mTrendSearchItems;
    Context mContext;

    public void setNewList(List<TrendingSearchItem> mList) {
        this.mTrendSearchItems = mList;
        notifyDataSetChanged();
    }
    public SearchTrendAdapter(List<TrendingSearchItem> mTrendSearchItems, Context mContext) {
        this.mTrendSearchItems = mTrendSearchItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TrendSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_trend, parent, false);
        return new TrendSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendSearchViewHolder holder, int position) {
        TrendingSearchItem item = mTrendSearchItems.get(position);
        holder.mTitle.setText(item.getTitle());
        holder.mDescription.setText(item.getDescription());
        holder.mButtonReadArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(item.getLink()));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTrendSearchItems.size();
    }

    public class TrendSearchViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle, mDescription;
        Button mButtonReadArticle;
        public TrendSearchViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.text_trend_title);
            mDescription = itemView.findViewById(R.id.text_trend_desc);
            mButtonReadArticle = itemView.findViewById(R.id.btn_read_article);
        }
    }
}
