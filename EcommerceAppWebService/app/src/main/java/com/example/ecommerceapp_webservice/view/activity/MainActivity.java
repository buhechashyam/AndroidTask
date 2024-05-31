package com.example.ecommerceapp_webservice.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.UserModel;
import com.example.ecommerceapp_webservice.viewmodel.ProductViewModel;
import com.example.ecommerceapp_webservice.utils.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mButtonGetUsers;
    Button mButtonDeleteUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mButtonDeleteUser = findViewById(R.id.btn_delete_user);
        mButtonGetUsers = findViewById(R.id.btn_get_users);


        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        mButtonGetUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getUsers(5).observe(MainActivity.this, new Observer<List<UserModel>>() {
                    @Override
                    public void onChanged(List<UserModel> userModels) {
                        Log.d("TAG", String.valueOf(userModels.size()));
                        Utils.showToast(MainActivity.this,"User count : " +  String.valueOf(userModels.size()));
                    }
                });
            }
        });

        mButtonDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteUser(6).observe(MainActivity.this, new Observer<UserModel>() {
                    @Override
                    public void onChanged(UserModel userModel) {
                        Log.d("TAG", String.valueOf(userModel.getName()) + " is Deleted");
                    }
                });
            }
        });
    }
}