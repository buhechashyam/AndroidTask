package com.example.uicomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private CheckBox mCheckBoxFirst, mCheckBoxSecond, mCheckBoxThird, mCheckBoxFourth;
    private RadioGroup mRadioGroup;
    private SwitchCompat mSwitchMode;
    private Spinner mSpinnerPlanet;
    private Button mButtonShowSelectedRadio, mButtonClearRadio;
    private TextView mTextViewSelectedCheckBoxes;
    private CheckedTextView mCheckedTextView;

    ArrayList<String> selectedCheckboxes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //For Spinner
        setSpinner();

        //Perform Switch Operation
        performSwitch();

        //Perform Checkboxes
        chooseCategory();

        //Perform RadioButton and RadioGroup
        selectStack();

    }

    private void selectStack() {
        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {

        });

        mButtonShowSelectedRadio.setOnClickListener(v -> {
            int radioId = mRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(radioId);
            if (radioId == -1) {
                Toast.makeText(MainActivity.this, "Please Select Radio Button", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mButtonClearRadio.setOnClickListener(v -> {
            mRadioGroup.clearCheck();
        });
    }

    private void chooseCategory() {
        mCheckBoxFirst.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedCheckboxes.add("Clothes");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());
            } else {
                selectedCheckboxes.remove("Clothes");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());
            }
        });

        mCheckBoxSecond.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedCheckboxes.add("Electronics");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());

            } else {
                selectedCheckboxes.remove("Electronics");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());

            }
        });

        mCheckBoxThird.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedCheckboxes.add("Stationary");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());

            } else {
                selectedCheckboxes.remove("Stationary");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());

            }
        });

        mCheckBoxFourth.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedCheckboxes.add("Foods");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());

            } else {
                selectedCheckboxes.remove("Foods");
                mTextViewSelectedCheckBoxes.setText(selectedCheckboxes.toString());
            }
        });
    }

    private void performSwitch() {
        mSwitchMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {

        mSwitchMode = (SwitchCompat) findViewById(R.id.switch_mode);

        mButtonShowSelectedRadio = (Button) findViewById(R.id.btn_show_radio);
        mButtonClearRadio = (Button) findViewById(R.id.btn_clear_radio);

        mSpinnerPlanet = (Spinner) findViewById(R.id.spinner_planets);
        mSpinnerPlanet.setOnItemSelectedListener(this);

        mCheckBoxFirst = (CheckBox) findViewById(R.id.checkbox1);
        mCheckBoxSecond = (CheckBox) findViewById(R.id.checkbox2);
        mCheckBoxThird = (CheckBox) findViewById(R.id.checkbox3);
        mCheckBoxFourth = (CheckBox) findViewById(R.id.checkbox4);

        mRadioGroup = (RadioGroup) findViewById(R.id.radio_stacks);
        mTextViewSelectedCheckBoxes = (TextView) findViewById(R.id.text_selected_checkboxes);

        mCheckedTextView = (CheckedTextView) findViewById(R.id.checked_tv);
        mCheckedTextView.setCheckMarkDrawable(R.drawable.ic_check);
        mCheckedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckedTextView.isChecked()){
                    mCheckedTextView.setChecked(false);
                }else {
                    mCheckedTextView.setChecked(true);
                }
            }
        });
    }

    private void setSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        mSpinnerPlanet.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] planets = getResources().getStringArray(R.array.planets_array);
        Toast.makeText(this, planets[position], Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }
}