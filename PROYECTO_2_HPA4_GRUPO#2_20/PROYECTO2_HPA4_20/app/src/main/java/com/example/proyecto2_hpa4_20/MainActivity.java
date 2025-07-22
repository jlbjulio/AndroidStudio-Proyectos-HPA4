package com.example.proyecto2_hpa4_20;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


//Proyecto1 Grupo 2 Integrantes
//Lara Julio 20, González Jorge 15, Batista Joseph 7, Arcilla Angel 4

public class MainActivity extends AppCompatActivity {

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

        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(500);
        animation.setStartOffset(20);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        image.startAnimation(animation);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        Animation animation1 = new AlphaAnimation(0.0f,1.0f);
        animation1.setDuration(500);
        animation1.setStartOffset(20);
        animation1.setRepeatMode(Animation.REVERSE);
        animation1.setRepeatCount(Animation.INFINITE);
        tv1.startAnimation(animation1);

        TextView tv2= (TextView) findViewById(R.id.tv2);
        Animation animation2 = new AlphaAnimation(0.0f,1.0f);
        animation2.setDuration(500);
        animation2.setStartOffset(20);
        animation2.setRepeatMode(Animation.REVERSE);
        animation2.setRepeatCount(Animation.INFINITE);
        tv2.startAnimation(animation2);
    }
}