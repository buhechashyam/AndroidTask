package com.example.uicomponents.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class AlertDialogActivity extends AppCompatActivity {

    Button btnCustomAlertWithList;
    Button btnCustomAlertWithCheckBoxes;
    Button btnCustomAlertWithRadioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btnCustomAlertWithList = findViewById(R.id.btn_alert_dialog_with_list);
        btnCustomAlertWithCheckBoxes = findViewById(R.id.btn_alert_dialog_with_checkboxes);
        btnCustomAlertWithRadioButtons = findViewById(R.id.btn_alert_dialog_with_radio);

        String[] planets = getResources().getStringArray(R.array.planets_array);

        //alert dialog
        btnCustomAlertWithList.setOnClickListener(v -> showAlertDialog(planets));

        //alert dialog with CheckBoxes
        btnCustomAlertWithCheckBoxes.setOnClickListener(v -> showAlertDialogWithCheckboxes(planets));

        //alert dialog with Radio Buttons
        btnCustomAlertWithRadioButtons.setOnClickListener(v -> showAlertDialogWithRadioButtons(planets));
    }

    private void showAlertDialogWithCheckboxes(String[] planets) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);
        dialog.setTitle("alert dialog with CheckBoxes")
                .setMultiChoiceItems(planets, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {

                        } else {

                        }
                    }
                }).setPositiveButton("Yes", (dialog1, which) -> {
                })
                .setNegativeButton("No", (dialog1, which) -> {
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private void showAlertDialogWithRadioButtons(String[] planets) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);
        dialog.setTitle("alert dialog with CheckBoxes")
                .setSingleChoiceItems(planets, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Yes", (dialog1, which) -> {
                })
                .setNegativeButton("No", (dialog1, which) -> {
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    public void showAlertDialog(String[] planets) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);
        dialog.setTitle("Title")
                .setItems(planets, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast(AlertDialogActivity.this, planets[which]);
                    }
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}