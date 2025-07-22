package com.example.taller_13_activity_enviar_20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Integrantes
//Lara Julio, González Jorge, Batista Joseph

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();

        TextView tv4 = (TextView) findViewById(R.id.tv4);
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        Button btn2 = (Button) findViewById(R.id.btn2);

        tv4.setText("Nombre :" + intent.getStringExtra("Nombre"));
        tv5.setText("Correo :" + intent.getStringExtra("Correo"));

        //String nombre = getIntent().getStringExtra("Nombre");
        //String correo = getIntent().getStringExtra("Correo");
        //tv4.setText("Nombre: " + nombre);
        //tv5.setText("Correo: " + correo);

        btn2.setOnClickListener(v -> {
            Intent volver = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(volver);
        });
    }
}