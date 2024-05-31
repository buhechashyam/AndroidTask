package com.example.ecommerceapp_webservice.volley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecommerceapp_webservice.databinding.ActivityVollyBinding;
import com.example.ecommerceapp_webservice.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    ActivityVollyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVollyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        requestQueue = Volley.newRequestQueue(this);

        binding.btnStrRequest.setOnClickListener(v -> stringRequest());

        binding.btnJsonRequest.setOnClickListener(v -> jsonRequest());

        binding.btnImageRequest.setOnClickListener(v -> imageRequest());

        binding.btnJsonArrayRequest.setOnClickListener(v -> jsonArrayRequest());

    }

    private void stringRequest() {
        String url = "https://reqres.in/api/users/2";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Utils.showToast(VolleyActivity.this, "Request Completed Successfully!");
                binding.txtResponse.setText(s.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Utils.showToast(VolleyActivity.this, "Request Failed.Try Again!");
            }
        });
        stringRequest.setTag("STR_REQUEST");
        requestQueue.add(stringRequest);
    }

    private void jsonRequest() {
        String url = "https://reqres.in/api/users/2";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                String mUserName;
                try {
                    mUserName = "Full Name : " + jsonObject.getJSONObject("data").getString("first_name") + " " + jsonObject.getJSONObject("data").getString("last_name");
                    binding.txtResponse.setText(mUserName);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                binding.txtResponse.setText("Request Failed. Try again!");

            }
        });
        jsonObjectRequest.setTag("STR_REQUEST");
        requestQueue.add(jsonObjectRequest);
    }

    private void imageRequest() {
        String url = "https://reqres.in/img/faces/2-image.jpg";

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {

                binding.imgResponse.setImageBitmap(bitmap);
            }
        }, 1000, 1000, ImageView.ScaleType.FIT_XY, Bitmap.Config.ALPHA_8, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Utils.showToast(VolleyActivity.this, "Image Request Failed. Try Again!");
            }
        });
        requestQueue.add(imageRequest);
    }

    private void jsonArrayRequest() {
        String url = "https://fakestoreapi.com/products";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                binding.txtResponse.setText(jsonArray.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                binding.txtResponse.setText(volleyError.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();

        requestQueue.cancelAll("STR_REQUEST");
    }
}