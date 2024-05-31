package com.example.materialuicomponent.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.materialuicomponent.tablayout.fragments.CallFragment;
import com.example.materialuicomponent.tablayout.fragments.ChatFragment;
import com.example.materialuicomponent.tablayout.fragments.StatusFragment;

public class TabsAdapter extends FragmentStateAdapter {

    public TabsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
              fragment = new ChatFragment();
            break;
            case 1:
                fragment = new StatusFragment();
            break;
            case 2:
                fragment = new CallFragment();
            break;

        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
