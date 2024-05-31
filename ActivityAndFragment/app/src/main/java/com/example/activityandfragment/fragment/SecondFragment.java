package com.example.activityandfragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityandfragment.R;
import com.example.activityandfragment.fragment.viewmodel.MyViewModel;

public class SecondFragment extends Fragment {

    MyViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_second, container, false);

//        TextView mTextView = view.findViewById(R.id.fragment_second);
//
//        Bundle bundle = getArguments();
////        Log.d("Main",bundle.getString("a"));
//        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
//
//        viewModel.getData().observe(getViewLifecycleOwner(), s -> {
//            mTextView.setText(s.toString());
//        });

        return view;
    }
}