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

public class DomParsingActivity extends AppCompatActivity {

    TextView mTextViewResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom_parsing);

        mTextViewResult = findViewById(R.id.text_op);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputStream inputStream = getAssets().open("library.xml");

            //it represent entire XML Docs
            Document document = builder.parse(inputStream);

            //element return the XML tag
            Element element = document.getDocumentElement();
            element.normalize();

            //return the list of books objects
            NodeList nodeList = element.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                //access one node from nodelist
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element1 = (Element) node;
                    mTextViewResult.setText(mTextViewResult.getText() + "\nTitle : " + getValue("title", element1) + "\n");
                    mTextViewResult.setText(mTextViewResult.getText() + "Author : " + getValue("author", element1) + "\n");
                    mTextViewResult.setText(mTextViewResult.getText() + "Genre : " + getValue("genre", element1) + "\n");
                    mTextViewResult.setText(mTextViewResult.getText() + "Year : " + getValue("year", element1) + "\n");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private String getValue(String tag, Element element1) {
        NodeList nodeList = element1.getElementsByTagName(tag).item(0).getChildNodes();

        Node node = nodeList.item(0);

        return node.getNodeValue();
    }
}