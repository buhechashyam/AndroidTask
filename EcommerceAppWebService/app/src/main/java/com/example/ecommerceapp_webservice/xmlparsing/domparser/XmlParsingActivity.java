package com.example.ecommerceapp_webservice.xmlparsing.domparser;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceapp_webservice.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParsingActivity extends AppCompatActivity {

    TextView mTextViewOutput;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parsing);

        mTextViewOutput = findViewById(R.id.text_output);

        //DOM Model
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("student.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Document document = null;
        try {
            document = builder.parse(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        Element element = document.getDocumentElement();
        element.normalize();

        NodeList nodeList = document.getElementsByTagName("student");


        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) node;

                mTextViewOutput.setText(mTextViewOutput.getText() + "\nName : " + getValue("name", element1) + "\n");
                mTextViewOutput.setText(mTextViewOutput.getText() + "Age : " + getValue("age", element1) + "\n");
                mTextViewOutput.setText(mTextViewOutput.getText() + "Gender : " + getValue("gender", element1) + "\n");
                mTextViewOutput.setText(mTextViewOutput.getText() + "Grade : " + getValue("grade", element1) + "\n");
            }
        }


    }

    private String getValue(String tag, Element element) {

        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}