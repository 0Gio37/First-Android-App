package com.georges.android.firstapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.georges.android.firstapplication.R;
import com.georges.android.firstapplication.models.Movie;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ArrayList<Movie> mMovies;
    private Movie mMovie1;
    private Movie mMovie2;
    private Movie mMovie3;
    private Movie mMovie4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String sMovie1 = "{\"Title\":\"film1\",\"Year\":\"1977\",\"Rated\":\"PG\",\"Released\":\"25 May 1977\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Fantasy\",\"Director\":\"George Lucas\",\"Writer\":\"George Lucas\",\"Actors\":\"Mark Hamill, Harrison Ford, Carrie Fisher\",\"Plot\":\"The Imperial Forces, under orders from cruel Darth Vader, hold Princess Leia hostage in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker and Han Solo, captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 and C-3PO to rescue the beautiful princess, help the Rebel Alliance and restore freedom and justice to the Galaxy.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 6 Oscars. 63 wins & 29 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzg4MjQxNTQtZmI5My00YjMwLWJlMjUtMmJlY2U2ZWFlNzY1XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"93%\"},{\"Source\":\"Metacritic\",\"Value\":\"90/100\"}],\"Metascore\":\"90\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"1,323,906\",\"imdbID\":\"tt0076759\",\"Type\":\"movie\",\"DVD\":\"06 Dec 2005\",\"BoxOffice\":\"$460,998,507\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        String sMovie2 = "{\"Title\":\"film2\",\"Year\":\"1977\",\"Rated\":\"PG\",\"Released\":\"25 May 1977\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Fantasy\",\"Director\":\"George Lucas\",\"Writer\":\"George Lucas\",\"Actors\":\"Mark Hamill, Harrison Ford, Carrie Fisher\",\"Plot\":\"The Imperial Forces, under orders from cruel Darth Vader, hold Princess Leia hostage in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker and Han Solo, captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 and C-3PO to rescue the beautiful princess, help the Rebel Alliance and restore freedom and justice to the Galaxy.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 6 Oscars. 63 wins & 29 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzg4MjQxNTQtZmI5My00YjMwLWJlMjUtMmJlY2U2ZWFlNzY1XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"93%\"},{\"Source\":\"Metacritic\",\"Value\":\"90/100\"}],\"Metascore\":\"90\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"1,323,906\",\"imdbID\":\"tt0076759\",\"Type\":\"movie\",\"DVD\":\"06 Dec 2005\",\"BoxOffice\":\"$460,998,507\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        String sMovie3 = "{\"Title\":\"film3\",\"Year\":\"1977\",\"Rated\":\"PG\",\"Released\":\"25 May 1977\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Fantasy\",\"Director\":\"George Lucas\",\"Writer\":\"George Lucas\",\"Actors\":\"Mark Hamill, Harrison Ford, Carrie Fisher\",\"Plot\":\"The Imperial Forces, under orders from cruel Darth Vader, hold Princess Leia hostage in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker and Han Solo, captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 and C-3PO to rescue the beautiful princess, help the Rebel Alliance and restore freedom and justice to the Galaxy.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 6 Oscars. 63 wins & 29 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzg4MjQxNTQtZmI5My00YjMwLWJlMjUtMmJlY2U2ZWFlNzY1XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"93%\"},{\"Source\":\"Metacritic\",\"Value\":\"90/100\"}],\"Metascore\":\"90\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"1,323,906\",\"imdbID\":\"tt0076759\",\"Type\":\"movie\",\"DVD\":\"06 Dec 2005\",\"BoxOffice\":\"$460,998,507\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        String sMovie4 = "{\"Title\":\"film4\",\"Year\":\"1977\",\"Rated\":\"PG\",\"Released\":\"25 May 1977\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Fantasy\",\"Director\":\"George Lucas\",\"Writer\":\"George Lucas\",\"Actors\":\"Mark Hamill, Harrison Ford, Carrie Fisher\",\"Plot\":\"The Imperial Forces, under orders from cruel Darth Vader, hold Princess Leia hostage in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker and Han Solo, captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 and C-3PO to rescue the beautiful princess, help the Rebel Alliance and restore freedom and justice to the Galaxy.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 6 Oscars. 63 wins & 29 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzg4MjQxNTQtZmI5My00YjMwLWJlMjUtMmJlY2U2ZWFlNzY1XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"93%\"},{\"Source\":\"Metacritic\",\"Value\":\"90/100\"}],\"Metascore\":\"90\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"1,323,906\",\"imdbID\":\"tt0076759\",\"Type\":\"movie\",\"DVD\":\"06 Dec 2005\",\"BoxOffice\":\"$460,998,507\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";

        Gson gson = new Gson();
        mMovie1 = gson.fromJson(sMovie1, Movie.class);
        mMovie2 = gson.fromJson(sMovie2, Movie.class);
        mMovie3 = gson.fromJson(sMovie3, Movie.class);
        mMovie4 = gson.fromJson(sMovie4, Movie.class);

        mMovies.add(mMovie1);
        mMovies.add(mMovie2);
        mMovies.add(mMovie3);
        mMovies.add(mMovie4);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);






    }


}