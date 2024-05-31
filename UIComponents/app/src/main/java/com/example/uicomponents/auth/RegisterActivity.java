package com.example.uicomponents.auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUserName, etEmail, etPassword, etConformPassword;
    private Button mButtonRegister;
    private TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        etUserName = (EditText) findViewById(R.id.et_username);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConformPassword = (EditText) findViewById(R.id.et_confirm_password);
        mButtonRegister = (Button) findViewById(R.id.btn_register);
        mTextViewLogin = (TextView) findViewById(R.id.btn_login_now);


        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                String userEmail = etEmail.getText().toString();
                String userPassword = etPassword.getText().toString();
                String userConformPassword = etConformPassword.getText().toString();

                if (etUserName.getText().toString().isEmpty()) {
                    etUserName.setError("Enter Username");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    etEmail.setError("Enter Valid Email Address");
                } else if (!userPassword.equals(userConformPassword)) {
                    etConformPassword.setError("Password are not same");
                } else {
                    storeUserDataTOSharePref(userName, userEmail, userPassword);
                    Toast.makeText(getApplicationContext(), "User Register Successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                }
            }
        });

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void storeUserDataTOSharePref(String userName, String userEmail, String userPassword) {
        SharedPreferences sharedPref = getApplication().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", userName);
        editor.putString("email", userEmail);
        editor.putString("password", userPassword);
        editor.apply();
    }
}