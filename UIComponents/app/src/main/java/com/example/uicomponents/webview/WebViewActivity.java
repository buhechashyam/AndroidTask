package com.example.uicomponents.webview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    private EditText mEditTextURL;
    private Button mButtonSearch;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.webview);
        mEditTextURL = findViewById(R.id.et_url);
        mButtonSearch = findViewById(R.id.btn_search);

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = mEditTextURL.getText().toString();
                mWebView.loadUrl(url);
                mWebView.setWebViewClient(new WebViewClient());

                WebSettings webSettings = mWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
            }
        });
    }
}