package com.example.taller_27_basedato_con_alertdialog_20;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//Integrantes
//Lara, Julio - Batista, Joseph - González Jorge

public class MainActivity extends AppCompatActivity {
    BaseDatos g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNom = findViewById(R.id.etNom);
        EditText etCor = findViewById(R.id.etCor);
        EditText etCon = findViewById(R.id.etCon);
        Button btnInse = findViewById(R.id.btnInse);
        Button btnModi = findViewById(R.id.btnModi);
        Button btnElim = findViewById(R.id.btnElim);
        Button btnActu = findViewById(R.id.btnActu);
        Button btnLimp = findViewById(R.id.btnLimp);
        etNom.requestFocus();

        g = new BaseDatos(this);

        btnInse.setOnClickListener(v -> {
            String nom = etNom.getText().toString();
            String cor = etCor.getText().toString();
            String con = etCon.getText().toString();
            if (nom.equals("") || cor.equals("") || con.equals(""))
                Toast.makeText(MainActivity.this, "Llene Todo los Campos", Toast.LENGTH_SHORT).show();
            else {
                Boolean i = g.Insertar(nom, cor, con);
                if (i)
                    Toast.makeText(MainActivity.this, "Datos Ingresados", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
            }
        });

        btnModi.setOnClickListener(v -> {
            String nom = etNom.getText().toString();
            String cor = etCor.getText().toString();
            String con = etCon.getText().toString();
            Boolean m = g.Modificar(nom, cor, con);
            if (m)
                Toast.makeText(MainActivity.this, "Datos Modificados", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Datos no Modificados", Toast.LENGTH_SHORT).show();
        });

        btnElim.setOnClickListener(v -> {
            String cor = etCor.getText().toString();
            Boolean e = g.Eliminar(cor);
            if (e)
                Toast.makeText(MainActivity.this, "Datos Eliminados", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Datos no Eliminados", Toast.LENGTH_SHORT).show();
        });

        btnActu.setOnClickListener(v -> {
            Cursor a = g.getinfo();
            if (a.getCount() == 0) {
                Toast.makeText(MainActivity.this, "No hay Datos", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while (a.moveToNext()) {
                buffer.append("Nombre: " + a.getString(0) + "\n");
                buffer.append("Correo: " + a.getString(1) + "\n");
                buffer.append("Contraseña: " + a.getString(2) + "\n\n");
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog);
            builder.setCancelable(true);
            builder.setTitle("Datos Registrados");
            builder.setMessage(buffer.toString());
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Salio del Alert dialog", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();



        });

        btnLimp.setOnClickListener(v -> {
            etNom.setText("");
            etCor.setText("");
            etCon.setText("");
            etNom.requestFocus();
        });
    }
}