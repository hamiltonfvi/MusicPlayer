package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playbutton, pausebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views
    playbutton = findViewById(R.id.play_button);
    pausebutton = findViewById(R.id.pause_button);
    }

    //play or pause song when clicked

    public void play(View view) {
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer ring = MediaPlayer.create(this,R.raw.song);
            }
        });
    }

}
