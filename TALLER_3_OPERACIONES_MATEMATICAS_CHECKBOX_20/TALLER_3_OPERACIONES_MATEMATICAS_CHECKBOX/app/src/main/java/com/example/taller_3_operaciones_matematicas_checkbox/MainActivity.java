package com.example.taller_3_operaciones_matematicas_checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//INTEGRANTES
//LARA JULIO, GONZÁLEZ JORGE, BATISTA JOSEPH

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private CheckBox chb1, chb2, chb3, chb4;
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
        chb1 = (CheckBox) findViewById(R.id.chb1);
        chb2 = (CheckBox) findViewById(R.id.chb2);
        chb3 = (CheckBox) findViewById(R.id.chb3);
        chb4 = (CheckBox) findViewById(R.id.chb4);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1.requestFocus();

    }

    public void Calcular(View view){
        int n1, n2;
        String res = "";

        try {
            n1 = Integer.parseInt(et1.getText().toString());
            n2 = Integer.parseInt(et2.getText().toString());

            if (chb1.isChecked())
                res = "La suma de " + " (" + n1 + ") " + " + " + " (" + n2 + ") " + "es: " + (n1 + n2);

            if (chb2.isChecked())
                res = "La resta de " + " (" + n1 + ") " + " - " + " (" + n2 + ") " + "es: " + (n1 - n2);

            if (chb3.isChecked())
                res = "La multiplicación de " + " (" + n1 + ") " + " * " + " (" + n2 + ") " + "es: " + (n1 * n2);

            if (chb4.isChecked()) {
                if (n2 == 0)
                    res = "Error división";
                else
                    res = "La división de " + " (" + n1 + ") " + " / " + " (" + n2 + ") " + "es: " + (n1 / n2);
            }

            tv2.setText(res);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error dato incorrecto", Toast.LENGTH_SHORT).show();

        }
    }

    public void Limpiar(View view){
        et1.setText("");
        et2.setText("");
        chb1.setChecked(false);
        chb2.setChecked(false);
        chb3.setChecked(false);
        chb4.setChecked(false);
        tv2.setText("");
        et1.requestFocus();

    }

}