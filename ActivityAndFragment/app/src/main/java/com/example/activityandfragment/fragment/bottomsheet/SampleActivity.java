package com.example.activityandfragment.fragment.bottomsheet;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activityandfragment.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class SampleActivity extends AppCompatActivity {

    MaterialToolbar mToolbar;
    MaterialButton btnOpenBottomSheet;
    TextView mTextViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        initView();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if (getIntent() != null) {
            mTextViewData.setText("Receive Data : " + getIntent().getStringExtra("EXTRA_NAME"));
        }

        btnOpenBottomSheet.setOnClickListener(v -> {
            BottomSheetFragment bottomSheet = new BottomSheetFragment();
            bottomSheet.show(getSupportFragmentManager(), "");
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_simple, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_cart) {
            Toast.makeText(SampleActivity.this, "Cart item Clicked..", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_login) {
            Toast.makeText(SampleActivity.this, "Login item Clicked..", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(SampleActivity.this, "Setting item Clicked..", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private void initView() {
        mToolbar = findViewById(R.id.materialToolbar);
        btnOpenBottomSheet = findViewById(R.id.btn_open_bottom_sheet);
        mTextViewData = findViewById(R.id.txt_data);
    }
}