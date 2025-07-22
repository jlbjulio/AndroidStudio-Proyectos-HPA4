package com.example.taller20_audioplayer;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.TimeUnit;

//Integrantes
//Lara Julio 20, González Jorge 15, Batista Joseph 7

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    TextView nomcan, tiecan, durcan;
    MediaPlayer mediaPlayer;
    Handler updateHandler = new Handler();
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnplay = findViewById(R.id.btnplay);
        Button btnstop = findViewById(R.id.btnstop);
        Button btnpause = findViewById(R.id.btnpause);

        nomcan = findViewById(R.id.nomcan);
        nomcan.setText("Sam Gellaitry - Assumptions");
        nomcan.setSelected(true);

        mediaPlayer = MediaPlayer.create(this, R.raw.sam_gellaitry_assumptions);

        durcan = findViewById(R.id.durcan);
        int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(mediaPlayer.getDuration());
        int seconds = (int) (TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration()) -
                TimeUnit.MINUTES.toSeconds(minutes));
        durcan.setText(String.format("%02d:%02d", minutes, seconds));

        tiecan = findViewById(R.id.tiecan);

        seekBar = findViewById(R.id.seekbar);
        seekBar.setMax((int) mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(this);

        updateHandler.postDelayed(update, 100);

        ObjectAnimator animator1 = ObjectAnimator.ofArgb(
            btnplay,
            "backgroundColor",
            Color.parseColor("#FF0000"), // Red
            Color.parseColor("#00FF00"), // Green
            Color.parseColor("#0000FF")  // Blue
        );
        animator1.setDuration(2000);
        animator1.setRepeatCount(ObjectAnimator.INFINITE);
        animator1.setRepeatMode(ObjectAnimator.RESTART);
        animator1.start();


        ObjectAnimator animator2 = ObjectAnimator.ofArgb(
            btnpause,
            "backgroundColor",
            Color.parseColor("#FFFF00"), // Yellow
            Color.parseColor("#00FFFF"), // Cyan
            Color.parseColor("#FF00FF")  // Magenta
        );
        animator2.setDuration(2000);
        animator2.setRepeatCount(ObjectAnimator.INFINITE);
        animator2.setRepeatMode(ObjectAnimator.RESTART);
        animator2.start();


        ObjectAnimator animator3 = ObjectAnimator.ofArgb(
            btnstop,
            "backgroundColor",
            Color.parseColor("#FF7F00"), // Orange
            Color.parseColor("#4B0082"), // Indigo
            Color.parseColor("#8B00FF")  // Violet
        );
        animator3.setDuration(2000);
        animator3.setRepeatCount(ObjectAnimator.INFINITE);
        animator3.setRepeatMode(ObjectAnimator.RESTART);
        animator3.start();

        // Fading animation for ImageView
        ImageView imageView = findViewById(R.id.image);
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
        fadeAnim.setDuration(1500);
        fadeAnim.setRepeatCount(ObjectAnimator.INFINITE);
        fadeAnim.setRepeatMode(ObjectAnimator.REVERSE);
        fadeAnim.start();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (b) {
            mediaPlayer.seekTo(i);

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Empty implementation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Empty implementation
    }

    private Runnable update = new Runnable() {
        @Override
        public void run() {
            long currentTime = mediaPlayer.getCurrentPosition();
            seekBar.setProgress((int) currentTime);
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(currentTime);
            int seconds = (int) (TimeUnit.MILLISECONDS.toSeconds(currentTime) -
                    TimeUnit.MINUTES.toSeconds(minutes));
            tiecan.setText(String.format("%02d:%02d", minutes, seconds));
            updateHandler.postDelayed(this, 100);
        }
    };

    public void Play(View view) {
        mediaPlayer.start();
    }

    public void Pause(View view) {
        mediaPlayer.pause();

    }

    public void Stop(View view) {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.sam_gellaitry_assumptions);
    }
}