package com.example.ecommerceapp_webservice.xmlparsing.pullparser;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.Student;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParsingActivity extends AppCompatActivity {

    TextView mTextViewResult;
    Student mStudent;
    String text;

    List<Student> mListOfStudents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_pull_parsing);

        mTextViewResult = findViewById(R.id.textView);

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            InputStream inputStream = getAssets().open("student.xml");
            parser.setInput(inputStream, "UTF-8");

            //return the current type of event, START_TAG,END_TAG, TEXT
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG: {
                        if (tagName.equalsIgnoreCase("student")) {
                            mStudent = new Student();
                        }
                    }
                    break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase("student")) {
                            mListOfStudents.add(mStudent);
                        } else if (tagName.equalsIgnoreCase("name")) {
                            mStudent.setName(text);
                        } else if (tagName.equalsIgnoreCase("age")) {
                            mStudent.setAge(Integer.parseInt(text));
                        } else if (tagName.equalsIgnoreCase("gender")) {
                            mStudent.setGender(text);
                        } else if (tagName.equalsIgnoreCase("grade")) {
                            mStudent.setGrade(text);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (IOException | XmlPullParserException e) {
            throw new RuntimeException(e);
        }
        mTextViewResult.setText(mListOfStudents.toString());

    }
}