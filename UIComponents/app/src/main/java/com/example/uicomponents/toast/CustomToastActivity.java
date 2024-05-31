package com.example.uicomponents.toast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class CustomToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_view);

        Button mButtonShowCustomToast = findViewById(R.id.btn_show_custom_toast);

        mButtonShowCustomToast.setOnClickListener(v -> createCustomToast());
    }

    private void createCustomToast() {

        Toast toast = new Toast(CustomToastActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);

        View view = getLayoutInflater().inflate(R.layout.custom_toast,null);

        TextView tv = view.findViewById(R.id.text_toast);
        ImageView toastIcon = view.findViewById(R.id.toast_icon);

        tv.setText(R.string.title_custom_toast);
        toastIcon.setImageResource(R.drawable.btn_focused);
        toast.setView(view);
        toast.show();
    }
}