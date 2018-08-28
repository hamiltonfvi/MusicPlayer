package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button playbutton, pausebutton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views
        playbutton = findViewById(R.id.play_button);
        pausebutton = findViewById(R.id.pause_button);
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        pausebutton.setEnabled(false);

    //play song when clicked
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.playing),Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                pausebutton.setEnabled(true);
                playbutton.setEnabled(false);
            }
        });

    //pause song when clicked
        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.pausing),Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                pausebutton.setEnabled(false);
                playbutton.setEnabled(true);
            }
        });
    }
}
