package com.georges.android.firstapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.georges.android.firstapplication.R;
import com.georges.android.firstapplication.models.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewWelcome;
    private Button mButtonSearch;
    private Context mContext;
    private ArrayList<Movie> mMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "MainActivity: onCreate()");

        mTextViewWelcome = findViewById(R.id.text_view_welcome);
        mTextViewWelcome.setText(R.string.main_title_welcome);
        Toast.makeText(this, R.string.main_title_welcome, Toast.LENGTH_SHORT).show();

        mContext = this;
        mButtonSearch = findViewById(R.id.btn_search);
        View.OnClickListener onClickListenerBtnSearch = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, R.string.app_name, Toast.LENGTH_SHORT).show();
                Log.d("histo_log","Click sur le btn rechercher");
            }};
        mButtonSearch.setOnClickListener(onClickListenerBtnSearch);

        mMovies = new ArrayList<>();


    }

    public void onClickMovie(View view) {
        String nameView = getResources().getResourceEntryName(view.getId());
        switch(nameView){
            case "line_movie1":
                //Toast.makeText(this, "film 1 cliqué ...", Toast.LENGTH_SHORT).show();
                Log.d("histo_log","cliqué "+ nameView + " ok");
                break;
            case "line_movie2":
                //Toast.makeText(this, "film 2 cliqué ...", Toast.LENGTH_SHORT).show();
                Log.d("histo_log","cliqué "+ nameView +" ok");
                break;
        }
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("movie", nameView);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "MainActivity: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "MainActivity: onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "MainActivity: onStop()");
    }
}
