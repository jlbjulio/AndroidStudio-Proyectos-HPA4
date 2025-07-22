package com.example.investigacion_2_semestral_grupo2_20;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.niqdev.mjpeg.DisplayMode;
import com.github.niqdev.mjpeg.Mjpeg;
import com.github.niqdev.mjpeg.MjpegSurfaceView;

//Investigación 2 e Semestral Grupo 2 Integrantes
//Lara Julio 20, González Jorge 15, Batista Joseph 7, Arcilla Angel 4

public class MainActivity extends AppCompatActivity {

    MjpegSurfaceView ipcamView;

    TextView tv1, tv2;

    ImageView imageView;

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

        ipcamView = findViewById(R.id.ipcamView);
        Mjpeg.newInstance()
                .open("http://172.20.10.3:8080/video", 5) // URL y timeout
                .subscribe(
                        inputStream -> runOnUiThread(() -> {
                            ipcamView.setSource(inputStream);
                            ipcamView.setDisplayMode(DisplayMode.BEST_FIT); // Ajuste visual
                            ipcamView.showFps(true); // Mostrar FPS
                        }),
                        throwable -> throwable.printStackTrace()
                );

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        imageView = findViewById(R.id.imageView);

        ObjectAnimator blink1 = ObjectAnimator.ofFloat(tv1, "alpha", 1f, 0f);
        blink1.setDuration(500);
        blink1.setRepeatMode(ValueAnimator.REVERSE);
        blink1.setRepeatCount(ValueAnimator.INFINITE);
        blink1.start();

        ObjectAnimator blink2 = ObjectAnimator.ofFloat(tv2, "alpha", 1f, 0f);
        blink2.setDuration(500);
        blink2.setRepeatMode(ValueAnimator.REVERSE);
        blink2.setRepeatCount(ValueAnimator.INFINITE);
        blink2.start();

        ObjectAnimator blink3 = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
        blink3.setDuration(500);
        blink3.setRepeatMode(ValueAnimator.REVERSE);
        blink3.setRepeatCount(ValueAnimator.INFINITE);
        blink3.start();
    }
}