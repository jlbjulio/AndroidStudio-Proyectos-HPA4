package com.example.taller_14_activitydevolver_20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Integrantes
//Lara Julio, González Jorge, Batista Joseph
public class SecondActivity extends AppCompatActivity {

    private String color;
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

        RadioGroup colores = (RadioGroup) findViewById(R.id.colores);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Intent selector = new Intent();

        colores.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (R.id.rb1 == checkedId)
                    color = "#FF0000"; //Rojo
                if (R.id.rb2 == checkedId)
                    color = "#2196F3"; //Azul
                if (R.id.rb3 == checkedId)
                    color = "#4CAF50"; //Verde
                if (R.id.rb4 == checkedId)
                    color = "#936445"; //Chocolate
                if (R.id.rb5 == checkedId)
                    color = "#FFEB3B"; //Amarillo

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the result to be returned to MainActivity
                selector.putExtra("Selector", color);
                setResult(RESULT_OK, selector);
                finish(); // Close SecondActivity
            }
        });
    }
}