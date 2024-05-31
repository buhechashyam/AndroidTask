package com.example.uicomponents.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class IntentsActivity extends AppCompatActivity {
    private Button mButtonDialCall, mButtonSendMail, mButtonSendMessage, mButtonSendPlainText;
    private TextInputEditText mEditTextPhone, mEditTextMail, mEditTextMessage, mEditTextPlainText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        initViews();

        mButtonSendPlainText.setOnClickListener(v -> userSendPlainText());

        mButtonSendMessage.setOnClickListener(v -> userSendMessage());

        mButtonDialCall.setOnClickListener(v -> userDialCall());

        mButtonSendMail.setOnClickListener(v -> userSendMail());
    }

    private void userSendPlainText(){
        Intent iSendText = new Intent();
        iSendText.setAction(Intent.ACTION_SEND);
        iSendText.setType("text/plain");
        iSendText.putExtra(Intent.EXTRA_TEXT, Objects.requireNonNull(mEditTextPlainText.getText()).toString());
        startActivity(Intent.createChooser(iSendText, "Share Data with..."));
    }

    private void userSendMessage() {
        Intent iSendMessage = new Intent();
        iSendMessage.setAction(Intent.ACTION_SENDTO);
        iSendMessage.setData(Uri.parse("smsto:" + Uri.encode("+919510464343")));
        iSendMessage.putExtra("sms_body", Objects.requireNonNull(mEditTextMessage.getText()).toString());
        startActivity(iSendMessage);
    }

    private void userSendMail() {
        Intent iSendMail = new Intent();
        iSendMail.setAction(Intent.ACTION_SEND);
        iSendMail.setType("text/html");
        iSendMail.putExtra(Intent.EXTRA_EMAIL, Objects.requireNonNull(mEditTextMail.getText()).toString());
        iSendMail.putExtra(Intent.EXTRA_SUBJECT, "Welcome to Basecamp \uD83D\uDC4B");
        iSendMail.putExtra(Intent.EXTRA_TEXT, "\n" +
                "Hey there!\n" +
                "Welcome to Basecamp \uD83D\uDC4B\n" +
                "Hey Android7,\n" +
                "\n" +
                "We're glad you're here!  Basecamp is where teams plan, discuss, decide, and deliver great work, every single day. ");
        startActivity(Intent.createChooser(iSendMail, "Choose Mail"));
    }

    private void userDialCall() {
        Intent iDial = new Intent();
        iDial.setAction(Intent.ACTION_DIAL);
        iDial.setData(Uri.parse("tel:" + Objects.requireNonNull(mEditTextPhone.getText())));
        startActivity(iDial);
    }

    private void initViews() {
        mButtonDialCall = findViewById(R.id.btn_dial_call);
        mButtonSendMail = findViewById(R.id.btn_send_mail);
        mEditTextPhone = findViewById(R.id.etPhoneNumber);
        mEditTextMail = findViewById(R.id.et_mail);
        mEditTextMessage = findViewById(R.id.et_text_message);
        mButtonSendMessage = findViewById(R.id.btn_send_message);
        mEditTextPlainText = findViewById(R.id.et_plain_text);
        mButtonSendPlainText = findViewById(R.id.btn_send_plain_text);
    }
}