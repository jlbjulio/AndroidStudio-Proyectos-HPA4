package com.example.taller_13_activity_enviar_20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


//Integrantes
//Lara Julio, González Jorge, Batista Joseph
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

        EditText et1 = (EditText) findViewById(R.id.et1);
        EditText et2 = (EditText) findViewById(R.id.et2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        et1.requestFocus();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et1.getText().toString();
                String correo = et2.getText().toString();
                if (nombre.equals("") || correo.equals("")) {
                    Toast.makeText(MainActivity.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Nombre", nombre);
                    intent.putExtra("Correo", correo);
                    startActivity(intent);
                    et1.setText("");
                    et2.setText("");
                    et1.requestFocus();
                    Toast.makeText(MainActivity.this, "Datos enviados", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}