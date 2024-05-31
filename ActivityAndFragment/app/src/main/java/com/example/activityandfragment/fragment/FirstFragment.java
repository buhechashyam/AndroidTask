package com.example.activityandfragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.activityandfragment.R;
import com.example.activityandfragment.fragment.viewmodel.MyViewModel;
import com.google.android.material.button.MaterialButton;

public class FirstFragment extends Fragment {

    MaterialButton mButtonSendData;
    EditText mEditTextName;
    MyViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        mButtonSendData = view.findViewById(R.id.btn_send_data);
        mEditTextName = view.findViewById(R.id.et_name);

        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        mButtonSendData.setOnClickListener(v -> {
            viewModel.setData(mEditTextName.getText().toString());
            Bundle b = new Bundle();
            b.putString("a","shyam");

            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(b);
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, secondFragment).commit();
        });


        return view;
    }
}