package com.example.taller_7_incre_decre_reset_20;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Integrantes
//Lara Julio, Batista Joseph, González Jorge
public class MainActivity extends AppCompatActivity {

    private TextView tv2;
    int cont =0;

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

        tv2 = (TextView) findViewById(R.id.tv2);
        ImageView incre = (ImageView) findViewById(R.id.incre);
        ImageView decre = (ImageView) findViewById(R.id.decre);
        ImageView reset = (ImageView) findViewById(R.id.reset);

        tv2.setText(Integer.toString(cont));

        incre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                tv2.setText(Integer.toString(cont));
            }
        });
        decre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont--;
                tv2.setText(Integer.toString(cont));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont = 0;
                tv2.setText(Integer.toString(cont));
            }

        });


    }
}