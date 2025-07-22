package com.example.taller_19_recyclerview_clubes_20;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//Integrantes
//Lara, Julio - Batista, Joseph -

public class MainActivity extends AppCompatActivity {

    String s1[], s2[];

    int images[] = {
            R.drawable.arsenal,
            R.drawable.barcelona,
            R.drawable.bayern_munich,
            R.drawable.chelsea,
            R.drawable.liverpool,
            R.drawable.manchester_city,
            R.drawable.manchester_united,
            R.drawable.psg,
            R.drawable.real_madrid,
            R.drawable.tottenham
    };

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.Clubes);
        s2 = getResources().getStringArray(R.array.Costo);
        Adapter adapter = new Adapter(this, s1, s2, images);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}