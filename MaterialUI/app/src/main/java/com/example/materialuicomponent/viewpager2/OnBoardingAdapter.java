package com.example.materialuicomponent.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.materialuicomponent.R;

import java.util.ArrayList;

public class OnBoardingAdapter extends PagerAdapter {
    ArrayList<ScreenItemModel> screens;
    Context context;

    public OnBoardingAdapter(ArrayList<ScreenItemModel> screens, Context context) {
        this.screens = screens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return screens.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_viewpager, null);

        ImageView imgSlide = view.findViewById(R.id.img_onboarding);
        TextView title = view.findViewById(R.id.text_title);
        TextView description = view.findViewById(R.id.text_desc);

        imgSlide.setImageResource(screens.get(position).getItemImg());
        title.setText(screens.get(position).getItemTitle());
        description.setText(screens.get(position).getDescription());

        //After creating view. it add to container
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
