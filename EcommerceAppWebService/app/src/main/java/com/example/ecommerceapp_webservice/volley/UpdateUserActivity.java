package com.example.ecommerceapp_webservice.volley;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.databinding.ActivityUpdateUserBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateUserActivity extends AppCompatActivity {

    ActivityUpdateUserBinding binding;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        requestQueue = Volley.newRequestQueue(this);
        binding.btnUpdateUser.setOnClickListener(v -> updateUser());
    }

    private void updateUser(){
        JSONObject updateJsonObject = new JSONObject();
        try {

            updateJsonObject.put("name",binding.etUserName.getText().toString());
            updateJsonObject.put("job",binding.etUserJob.getText().toString());
        }catch (Exception e) {

        }
        String url = "https://reqres.in/api/users/2";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, updateJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    binding.txtUpdateTime.setText("Update At: " + jsonObject.getString("updatedAt"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}