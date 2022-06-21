package com.georges.android.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewWelcome;
    private Button mButtonSearch;
    private Button mLineViewMovie1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewWelcome = findViewById(R.id.text_view_welcome);
        mTextViewWelcome.setText(R.string.main_title_welcome);
        Toast.makeText(this, R.string.main_title_welcome, Toast.LENGTH_SHORT).show();

        mButtonSearch = findViewById(R.id.btn_search);
        View.OnClickListener onClickListenerBtnSearch = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("histo_log","Click sur le btn rechercher");
            }};
        mButtonSearch.setOnClickListener(onClickListenerBtnSearch);
    }

    public void onClickMovie(View view) {
        String nameView = getResources().getResourceEntryName(view.getId());

        switch(nameView){
            case "line_movie1":
                Toast.makeText(this, "film 1 cliqué ...", Toast.LENGTH_SHORT).show();
                Log.d("histo_log","cliqué "+ nameView + " ok");
                break;
            case "line_movie2":
                Toast.makeText(this, "film 2 cliqué ...", Toast.LENGTH_SHORT).show();
                Log.d("histo_log","cliqué "+ nameView +" ok");
                break;
        }


    }


}