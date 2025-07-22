package com.example.proyecto2_hpa4_20;



import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

//Proyecto1 Grupo 2 Integrantes
//Lara Julio 20, González Jorge 15, Batista Joseph 7, Arcilla Angel 4

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrimerFragment extends Fragment {

    private HashMap<String, String> estudiantes = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PrimerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrimerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PrimerFragment newInstance(String param1, String param2) {
        PrimerFragment fragment = new PrimerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_primer, container, false);
        EditText et1 = view.findViewById(R.id.et1);
        EditText et2 = view.findViewById(R.id.et2);
        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);

        estudiantes.put("Julio Lara", "8-997-2325");
        estudiantes.put("Jorge González", "8-1002-2167");
        estudiantes.put("Joseph Batista", "8-1009-1500");
        estudiantes.put("Angel Arcilla", "8-1004-1553");

        int color1 = Color.parseColor("#A0F1D1");
        int color2 = Color.parseColor("#B2C6FF");
        int color3 = Color.parseColor("#FFD8A9");

        ObjectAnimator animator1 = ObjectAnimator.ofInt(btn1, "backgroundColor", color1, color2, color3);
        animator1.setDuration(2000);
        animator1.setEvaluator(new ArgbEvaluator());
        animator1.setRepeatCount(ObjectAnimator.INFINITE);
        animator1.setRepeatMode(ObjectAnimator.REVERSE);
        animator1.start();

        ObjectAnimator animator2 = ObjectAnimator.ofInt(btn2, "backgroundColor", color1, color2, color3);
        animator2.setDuration(2000);
        animator2.setEvaluator(new ArgbEvaluator());
        animator2.setRepeatCount(ObjectAnimator.INFINITE);
        animator2.setRepeatMode(ObjectAnimator.REVERSE);
        animator2.start();



        btn1.setOnClickListener(v -> {
            String nombre = et1.getText().toString().trim();
            String cedula = et2.getText().toString().trim();

            if (nombre.isEmpty() || cedula.isEmpty()) {
                Toast.makeText(getContext(), "Completa ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!estudiantes.containsKey(nombre)) {
                Toast.makeText(getContext(), "Nombre no registrado", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!estudiantes.get(nombre).equals(cedula)) {
                Toast.makeText(getContext(), "Cédula incorrecta para el nombre", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView tv1 = getActivity().findViewById(R.id.tv1);
            TextView tv2 = getActivity().findViewById(R.id.tv2);
            ImageView imageView1 = getActivity().findViewById(R.id.imageView1);

            tv1.setText("Nombre: " + nombre);
            tv2.setText("Cédula: " + cedula);

            int imagenId = 0;
            switch (nombre) {
                case "Julio Lara":
                    imagenId = R.drawable.julio;
                    break;
                case "Jorge González":
                    imagenId = R.drawable.jorge;
                    break;
                case "Joseph Batista":
                    imagenId = R.drawable.joseph;
                    break;
                case "Angel Arcilla":
                    imagenId = R.drawable.angel;
                    break;
            }
            imageView1.setImageResource(imagenId);
        });

        btn2.setOnClickListener(v -> {
            et1.setText("");
            et2.setText("");
            et1.requestFocus();

            TextView tv1 = getActivity().findViewById(R.id.tv1);
            TextView tv2 = getActivity().findViewById(R.id.tv2);
            ImageView imageView1 = getActivity().findViewById(R.id.imageView1);

            if (tv1 != null) tv1.setText("");
            if (tv2 != null) tv2.setText("");
            if (imageView1 != null) imageView1.setImageResource(0);
        });

        return view;
    }
}