package com.example.ecommerceapp_webservice.xmlparsing.domparser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.MovieModel;
import com.example.ecommerceapp_webservice.view.adapter.MovieAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class PracticeDOMActivity extends AppCompatActivity {

RecyclerView mRecyclerViewMovies;
ArrayList<MovieModel> mMovieList = new ArrayList<>();
    MovieModel mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_domactivity);

        mRecyclerViewMovies = findViewById(R.id.recyclerview_movie);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputStream inputStream = getAssets().open("movies.xml");

            Document document = builder.parse(inputStream);

            Element element = document.getDocumentElement();
            element.normalize();

            NodeList nodeList = element.getElementsByTagName("movie");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element1 = (Element) node;

                    mMovie = new MovieModel();
                    mMovie.setTitle(getValue("title", element1));
                    mMovie.setDirector(getValue("director", element1));
                    mMovie.setGenre(getValue("genre", element1));
                    mMovie.setYear(Integer.parseInt(getValue("year", element1)));
                    mMovie.setRating(Double.parseDouble(getValue("rating", element1)));

                    mMovieList.add(mMovie);
                }
            }
            mRecyclerViewMovies.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerViewMovies.setAdapter(new MovieAdapter(mMovieList, this));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

    }

    public String getValue(String tagName, Element element){

        NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
        Node node = nodeList.item(0);

        return node.getNodeValue();
    }
}