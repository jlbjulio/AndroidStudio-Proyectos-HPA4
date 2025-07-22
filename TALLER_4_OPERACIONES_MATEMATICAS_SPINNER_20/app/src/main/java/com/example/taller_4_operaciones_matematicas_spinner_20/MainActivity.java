package com.example.taller_4_operaciones_matematicas_spinner_20;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Integrantes
//Lara Julio, Batista Joseph, González Jorge

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv2;
    private Spinner sp1;



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
        sp1 = (Spinner) findViewById(R.id.sp1);
        et1.requestFocus();

        String[] opciones = {"Seleccionar Opción","Sumar", "Restar", "Multiplicación", "División"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner, opciones);
        sp1.setAdapter(adaptador);

    }

    public void Calcular (View view){
        int num1, num2;
        String sele, res = "";

        sele = sp1.getSelectedItem().toString();

        try {
            num1 = Integer.parseInt(et1.getText().toString());
            num2 = Integer.parseInt(et2.getText().toString());

            if (sele.equals("Sumar"))
                res = "La Suma de" + "(" + num1 + ")"+ "+" + "(" + num2 + ")" + "es: " + (num1 + num2);

            if (sele.equals("Restar"))
                res = "La Resta de" + "(" + num1 + ")"+ "-" + "(" + num2 + ")" + "es: " + (num1 - num2);

            if (sele.equals("Multiplicación"))
                res = "La Multiplicación de" + "(" + num1 + ")"+ "*" + "(" + num2 + ")" + "es: " + (num1 * num2);

            if (sele.equals("División"))
                if (num2 == 0)
                    res = "Error Divisioón por 0";
                else
                    res = "La División de" + "(" + num1 + ")"+ "/" + "(" + num2 + ")" + "es: " + (num1 / num2);

            tv2.setText(res);

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Error Dato Incorrecto", Toast.LENGTH_SHORT).show();

        }

    }

    public void Limpiar (View view) {
        et1.setText("");
        et2.setText("");
        sp1.setSelection(0);
        tv2.setText("");
        et1.requestFocus();
    }

}