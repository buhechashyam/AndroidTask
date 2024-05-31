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
import com.example.ecommerceapp_webservice.databinding.ActivityRegisterUserBinding;
import com.example.ecommerceapp_webservice.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterUserActivity extends AppCompatActivity {

    private ActivityRegisterUserBinding binding;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        requestQueue = Volley.newRequestQueue(this);

        binding.btnRegisterUser.setOnClickListener(v -> userRegistration());
    }

    private void userRegistration() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", binding.etUserEmail.getText().toString());
            jsonObject.put("password", binding.etUserPassword.getText().toString());

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        String url = "https://reqres.in/api/register";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, (JSONObject) jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    binding.txtResponseId.setText("Id : " + jsonObject.getInt("id"));
                    binding.txtResponseToken.setText("Token : "  + jsonObject.getString("token"));
                }catch (Exception e) {
                    Utils.showToast(RegisterUserActivity.this, "User Data not fetched. Try again!");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError){
                binding.txtResponseToken.setText("Error");
                Utils.showToast(RegisterUserActivity.this, "Registration Failed. Try again!");
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}