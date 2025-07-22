package com.example.taller_16_fragments_imagenes;

import static android.icu.text.Transliterator.REVERSE;
import static android.view.animation.Animation.INFINITE;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//Integrantes
//Lara, Julio - Batista, Joseph - González Jorge

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6;

    Fragment inicio, ima_1, ima_2, ima_3, ima_4, ima_5, ima_6;

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

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);

        inicio = new InicioFragment();
        ima_1 = new Imagen_1Fragment();
        ima_2 = new Imagen_2Fragment();
        ima_3 = new Imagen_3Fragment();
        ima_4 = new Imagen_4Fragment();
        ima_5 = new Imagen_5Fragment();
        ima_6 = new Imagen_6Fragment();

        ObjectAnimator animator1 = ObjectAnimator.ofInt(btn1, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator1.setDuration(500);
        animator1.setEvaluator(new ArgbEvaluator());
        animator1.setRepeatCount(REVERSE);
        animator1.setRepeatCount(INFINITE);
        animator1.start();

        ObjectAnimator animator2 = ObjectAnimator.ofInt(btn2, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator2.setDuration(500);
        animator2.setEvaluator(new ArgbEvaluator());
        animator2.setRepeatCount(REVERSE);
        animator2.setRepeatCount(INFINITE);
        animator2.start();

        ObjectAnimator animator3 = ObjectAnimator.ofInt(btn3, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator3.setDuration(500);
        animator3.setEvaluator(new ArgbEvaluator());
        animator3.setRepeatCount(REVERSE);
        animator3.setRepeatCount(INFINITE);
        animator3.start();

        ObjectAnimator animator4 = ObjectAnimator.ofInt(btn4, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator4.setDuration(500);
        animator4.setEvaluator(new ArgbEvaluator());
        animator4.setRepeatCount(REVERSE);
        animator4.setRepeatCount(INFINITE);
        animator4.start();

        ObjectAnimator animator5 = ObjectAnimator.ofInt(btn5, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator5.setDuration(500);
        animator5.setEvaluator(new ArgbEvaluator());
        animator5.setRepeatCount(REVERSE);
        animator5.setRepeatCount(INFINITE);
        animator5.start();

        ObjectAnimator animator6 = ObjectAnimator.ofInt(btn6, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator6.setDuration(500);
        animator6.setEvaluator(new ArgbEvaluator());
        animator6.setRepeatCount(REVERSE);
        animator6.setRepeatCount(INFINITE);
        animator6.start();



        getSupportFragmentManager().beginTransaction().replace(R.id.conteFragment, inicio).commit();


        }

    public void onclick(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (view.getId() == R.id.btn1) {
            transaction.replace(R.id.conteFragment, ima_1).commit();
            transaction.addToBackStack(null);
        }
        if (view.getId() == R.id.btn2) {
            transaction.replace(R.id.conteFragment, ima_2).commit();
            transaction.addToBackStack(null);
        }
        if (view.getId() == R.id.btn3) {
            transaction.replace(R.id.conteFragment, ima_3).commit();
            transaction.addToBackStack(null);
        }
        if (view.getId() == R.id.btn4) {
            transaction.replace(R.id.conteFragment, ima_4).commit();
            transaction.addToBackStack(null);
        }
        if (view.getId() == R.id.btn5) {
            transaction.replace(R.id.conteFragment, ima_5).commit();
            transaction.addToBackStack(null);
        }
        if (view.getId() == R.id.btn6) {
            transaction.replace(R.id.conteFragment, ima_6).commit();
            transaction.addToBackStack(null);
        }
    }
}