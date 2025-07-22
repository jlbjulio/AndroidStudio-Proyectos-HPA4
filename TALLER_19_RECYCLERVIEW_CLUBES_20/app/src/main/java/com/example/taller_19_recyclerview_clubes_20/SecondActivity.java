package com.example.taller_19_recyclerview_clubes_20;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView1;
    TextView tv2, tv3;

    String data1, data2;

    int images;


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

        imageView1 = findViewById(R.id.imageView1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        getData();
        setData();
    }

    private void setData() {
        tv2.setText(data1);
        tv3.setText(data2);
        imageView1.setImageResource(images);

    }

    private void getData() {
        if (getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("images")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("images", 1);
        }
        else {
            Toast.makeText(this, "No hay DATA", Toast.LENGTH_SHORT).show();
        }
    }
}