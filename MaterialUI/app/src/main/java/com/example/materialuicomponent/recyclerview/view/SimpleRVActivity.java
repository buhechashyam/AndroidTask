package com.example.materialuicomponent.recyclerview.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.recyclerview.adapter.SimpleAdapter;
import com.example.materialuicomponent.recyclerview.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleRVActivity extends AppCompatActivity {
    List<Product> myListData;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;

    RadioGroup radioGroup;
    RadioButton setLinearRadio;
    RadioButton setGridRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_rvactivity);

        myListData = new ArrayList<Product>();

        Log.d("DATA", myListData.toString());
        recyclerView = findViewById(R.id.recyclerview);
        radioGroup = findViewById(R.id.radio_select_orientation);
        setLinearRadio = findViewById(R.id.radio_linear);
        setGridRadio = findViewById(R.id.radio_grid);

        String[] data = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        SimpleAdapter adapter = new SimpleAdapter(data);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);

        setLinearRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setLinearLayout();
                }
            }
        });

        setGridRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setGridLayoutManager();
                }
            }
        });

        setLinearRadio.setChecked(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setLinearLayout() {
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setGridLayoutManager() {
        recyclerView.setLayoutManager(gridLayoutManager);
    }


}