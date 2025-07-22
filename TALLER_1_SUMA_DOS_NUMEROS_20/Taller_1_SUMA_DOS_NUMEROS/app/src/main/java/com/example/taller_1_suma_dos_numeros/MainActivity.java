package com.example.taller_1_suma_dos_numeros;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Integrantes
// Lara Julio, Batista Joseph, González Jorge

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv2;




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

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv2 = (TextView) findViewById(R.id.tv2);

        et1.requestFocus();

    }

    public void Sumar(View view) {
        int n1, n2;
        String res = "";
        try {
            n1 = Integer.parseInt(et1.getText().toString());
            n2 = Integer.parseInt(et2.getText().toString());
            res = "La suma de " + "(" + n1 + ") " + " + " + "(" + n2 + ")" + " = " + (n1 + n2);
            tv2.setText(res);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error Dato Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        et1.setText("");
        et2.setText("");
        tv2.setText("");
        et1.requestFocus();
    }
}