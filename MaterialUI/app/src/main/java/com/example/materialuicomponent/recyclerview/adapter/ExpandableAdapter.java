package com.example.materialuicomponent.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.databinding.ItemExpandableBinding;
import com.example.materialuicomponent.recyclerview.model.ExpandableData;

import java.util.ArrayList;

public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableAdapter.ExpandableViewHolder> {

    ArrayList<ExpandableData> langData;

    public ExpandableAdapter(ArrayList<ExpandableData> langData) {
        this.langData = langData;
    }

    public void setFilerList(ArrayList<ExpandableData> filerList) {
        this.langData = filerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExpandableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemExpandableBinding binding = ItemExpandableBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);

        return new ExpandableViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpandableViewHolder holder, int position) {
        ExpandableData data = langData.get(position);
        holder.bind(data);

        holder.binding.btnExpandview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.isVisible()) {
                    holder.binding.btnExpandview.setImageResource(R.drawable.ic_up_arrow);
                    holder.binding.linearlayoutBody.setVisibility(View.GONE);
                    data.setVisible(false);

                }else {
                    holder.binding.btnExpandview.setImageResource(R.drawable.ic_down_arrow);
                    holder.binding.linearlayoutBody.setVisibility(View.VISIBLE);
                    data.setVisible(true);
                }

                holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.rv_item_animation));
            }
        });
    }

    @Override
    public int getItemCount() {
        return langData.size();
    }

     class ExpandableViewHolder extends RecyclerView.ViewHolder {
        ItemExpandableBinding binding;
        public ExpandableViewHolder(ItemExpandableBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
        public void bind(ExpandableData data) {
            binding.imgLanguage.setImageResource(data.getImage());
            binding.tvLangName.setText(data.getTitle());
            binding.tvDescription.setText(data.getDescription());
            binding.linearlayoutBody.setVisibility(View.GONE);
        }
    }
}
