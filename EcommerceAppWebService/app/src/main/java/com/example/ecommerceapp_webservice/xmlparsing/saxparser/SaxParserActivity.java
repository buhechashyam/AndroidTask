package com.example.ecommerceapp_webservice.xmlparsing.saxparser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.MovieModel;
import com.example.ecommerceapp_webservice.view.adapter.MovieAdapter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParserActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewMovies;
    ArrayList<MovieModel> mListOfMovies = new ArrayList<>();
    MovieModel mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax_parser);

        mRecyclerViewMovies = findViewById(R.id.recyclerview_movies_list);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();

            DefaultHandler defaultHandler = new DefaultHandler() {

                boolean title = false;
                boolean director = false;
                boolean year= false;
                boolean genre = false;
                boolean rating = false;


                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);

                    if (localName == "movie") {
                        mMovie = new MovieModel();
                    }

                    if (qName.equalsIgnoreCase("title")) {
                        title = true;
                    } else if (qName.equalsIgnoreCase("director")){
                        director = true;
                    } else if (qName.equalsIgnoreCase("year")) {
                        year = true;
                    } else if (qName.equalsIgnoreCase("genre")) {
                        genre = true;
                    } else if (qName.equalsIgnoreCase("rating")) {
                        rating = true;
                    }

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    super.characters(ch, start, length);

                    if (title) {
                        mMovie.setTitle(new String(ch, start, length));
                        title = false;
                    }

                    if (director) {
                        mMovie.setDirector(new String(ch, start, length));
                        director = false;
                    }

                    if (year) {
                        mMovie.setYear(Integer.parseInt(new String(ch, start, length)));
                        year = false;
                    }

                    if (genre) {
                        mMovie.setGenre(new String(ch, start, length));
                        genre = false;
                    }

                    if (rating) {
                        mMovie.setRating(Double.parseDouble(new String(ch, start, length)));
                        rating = false;
                    }

                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    super.endElement(uri, localName, qName);

                    if (localName.equalsIgnoreCase("movie")){
                        mListOfMovies.add(mMovie);
                    }
                }
            };

            InputStream inputStream = getAssets().open("movies.xml");
            parser.parse(inputStream, defaultHandler);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        mRecyclerViewMovies.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewMovies.setAdapter(new MovieAdapter(mListOfMovies,this));

    }
}