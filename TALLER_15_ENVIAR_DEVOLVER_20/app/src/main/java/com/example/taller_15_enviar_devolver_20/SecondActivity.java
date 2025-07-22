package com.example.taller_15_enviar_devolver_20;

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
//Lara Julio , Batista Joseph, González Jorge

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
        int n1 = intent.getIntExtra("n1", 0);
        int n2 = intent.getIntExtra("n2", 0);

        TextView tv5 = (TextView) findViewById(R.id.tv5);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);

        tv5.setText("Numeros ingresados \n" + "Numero 1: " + n1 +"\n" + "Numero 2: " + n2);

        btn3.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("resultado", n1 + n2);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        btn4.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("resultado", n1 - n2);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}