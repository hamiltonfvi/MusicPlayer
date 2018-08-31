package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.media.MediaPlayer.OnCompletionListener;

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

        //Pause button gotta start disable by default
        pausebutton.setEnabled(false);

        //play song when play button is clicked
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Display a Toast message
                Toast.makeText(getApplicationContext(), getString(R.string.playing), Toast.LENGTH_SHORT).show();

                //Start Playing the audio file
                mediaPlayer.start();

                //Pop up a message when the reproduction of the music has finished
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(getApplicationContext(), getString(R.string.ended), Toast.LENGTH_SHORT).show();

                        //Disable Pause Button after reproduction of the audio is finished
                        pausebutton.setEnabled(false);

                        //Enable Play Button after reproduction of the audio is finished
                        playbutton.setEnabled(true);
                    }
                });

                //Enable Pause Button while playing the audio file
                pausebutton.setEnabled(true);

                //Disable Play Button until media player has finished reproducing
                playbutton.setEnabled(false);
            }
        });

        //pause song when pause button is clicked
        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.pausing), Toast.LENGTH_SHORT).show();

                //Pause the reproduction of the audio file
                mediaPlayer.pause();

                //Disable Pause Button after clicked
                pausebutton.setEnabled(false);

                //Enable Play Button after unpause the audio
                playbutton.setEnabled(true);
            }
        });
    }
}
