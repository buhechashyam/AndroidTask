package com.example.uicomponents.auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        SharedPreferences PREF_USER_DATA = getApplication().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String PREF_EMAIL = PREF_USER_DATA.getString("email", "Not Found");
        String PREF_PASSWORD = PREF_USER_DATA.getString("password", "Not Found");

        btnLogin.setOnClickListener(v -> {
            String mUserEmail = etEmail.getText().toString();
            String mUserPassword = etPassword.getText().toString();
            if (!Patterns.EMAIL_ADDRESS.matcher(mUserEmail).matches()) {
                etEmail.setError("Enter Valid Email Address");
            } else if (mUserPassword.isEmpty()) {
                etPassword.setError("Enter Password");
            } else {
                if (mUserEmail.equals(PREF_EMAIL) && mUserPassword.equals(PREF_PASSWORD)) {
                    Toast.makeText(getApplicationContext(), "User Login Successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Auth failed! try again..", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}