package com.example.materialuicomponent.snackbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.materialuicomponent.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private Button mButtonDefaultSnackbar;
    private Button mButtonActionCallSnackbar;
    private Button mButtonCustomSnackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        initView();

        mButtonDefaultSnackbar.setOnClickListener(v -> showDefaultSnackBar());

        mButtonActionCallSnackbar.setOnClickListener(v -> showActionCallSnackbar());

        mButtonCustomSnackbar.setOnClickListener(v -> showCustomSnackbar());
    }

    private void showCustomSnackbar() {
        Snackbar customSnackbar = Snackbar.make(coordinatorLayout, "Image is deleted", Snackbar.LENGTH_LONG);
        customSnackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Images Restored Successfully.", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        customSnackbar.setActionTextColor(getColor(R.color.red));
        View view = getLayoutInflater().inflate(R.layout.cusom_snackbar,null);
        @SuppressLint("RestrictedApi") Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) customSnackbar.getView();

        TextView textView = view.findViewById(R.id.tv_message);

        textView.setText("This is custom snackbar");

        snackbarLayout.addView(view);

        customSnackbar.show();
    }

    private void showActionCallSnackbar() {
        Snackbar actionCallSnackbar = Snackbar.make(coordinatorLayout, "Image is deleted", Snackbar.LENGTH_LONG);
        actionCallSnackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Images Restored Successfully.", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        actionCallSnackbar.setActionTextColor(getColor(R.color.red));
        actionCallSnackbar.show();
    }

    private void showDefaultSnackBar() {
        Snackbar defaultSnackbar = Snackbar.make(coordinatorLayout, "Image saved to gallery.", Snackbar.LENGTH_SHORT);
        defaultSnackbar.setTextColor(getColor(R.color.green));
        defaultSnackbar.show();
    }

    private void initView() {
        coordinatorLayout = findViewById(R.id.main);
        mButtonDefaultSnackbar = findViewById(R.id.btn_default_snack_bar);
        mButtonActionCallSnackbar = findViewById(R.id.btn_action_call_snackbar);
        mButtonCustomSnackbar = findViewById(R.id.btn_custom_snackbar);
    }
}