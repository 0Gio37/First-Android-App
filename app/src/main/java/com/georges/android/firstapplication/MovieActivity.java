package com.georges.android.firstapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MovieActivity extends AppCompatActivity {

    //private ActivityMovieBinding binding;
    private TextView mdescriptionMovie;
    private Movie mMovie;
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Log.d("TAG", "MovieActivity: onCreate()");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        //mdescriptionMovie = (TextView)findViewById(R.id.description_msg);
        //Bundle extras = getIntent().getExtras();
        //if(extras != null){
        //   String strMessage = extras.getString("movie");
        //  Log.d("log", strMessage);
        //mdescriptionMovie.setText(strMessage);
        //}
//
        mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.omdbapi.com/?i=tt0076759&apikey=bf4e1adb&plot=full").build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //TODO
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String stringJson = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateUI(stringJson);
                            findViewById(R.id.content_scrolling_layout_information).setVisibility(View.VISIBLE);
                            findViewById(R.id.content_scrolling_layout_progress_bar).setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });
    }

    private void updateUI(String stringJson){
        Gson gson = new Gson();
        mMovie = gson.fromJson(stringJson, Movie.class);

        ((TextView)findViewById(R.id.text_view_movie_title)).setText(mMovie.getTitle());
        ((TextView)findViewById(R.id.text_view_movie_released)).setText(mMovie.getReleased());
        ((TextView)findViewById(R.id.text_view_movie_genre)).setText(mMovie.getGenre());
        ((TextView)findViewById(R.id.text_view_movie_actors)).setText(mMovie.getActors());
        ((TextView)findViewById(R.id.text_view_movie_plot)).setText(mMovie.getPlot());
        ((TextView)findViewById(R.id.text_view_movie_plot)).setMaxLines(3);
        ((TextView)findViewById(R.id.text_view_movie_awards)).setText(mMovie.getAwards());
        ((TextView)findViewById(R.id.text_view_movie_director)).setText(mMovie.getDirector());

        Picasso.get().load(mMovie.getPoster()).into(((ImageView) findViewById(R.id.image_view_movie_picture)));
    }

    @SuppressLint("SetTextI18n")
    public void onClickReadMore(View view) {
        TextView textViewReadMore = (TextView) view;
        TextView textViewPlot = findViewById(R.id.text_view_movie_plot);

        if(textViewPlot.getMaxLines() == 3){
            textViewPlot.setMaxLines(1000);
            textViewReadMore.setText("Lire moins");
        } else {
            textViewPlot.setMaxLines(3);
            textViewReadMore.setText("Lire la suite");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "MovieActivity: onDestroy()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "MovieActivity: onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "MovieActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "MovieActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "MovieActivity: onStop()");
    }


}