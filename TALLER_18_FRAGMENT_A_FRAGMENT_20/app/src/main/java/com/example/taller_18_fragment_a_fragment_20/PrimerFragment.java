package com.example.taller_18_fragment_a_fragment_20;

import static android.icu.text.Transliterator.REVERSE;
import static android.view.animation.Animation.INFINITE;

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
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrimerFragment extends Fragment {

    private TextView tv;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primer, container, false);
        EditText et = view.findViewById(R.id.et);
        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);

        ObjectAnimator animator1 = ObjectAnimator.ofInt(btn1, "backgroundColor", Color.GREEN, Color.BLUE, Color.RED);
        animator1.setDuration(500);
        animator1.setEvaluator(new ArgbEvaluator());
        animator1.setRepeatCount(REVERSE);
        animator1.setRepeatCount(INFINITE);
        animator1.start();

        ObjectAnimator animator2 = ObjectAnimator.ofInt(btn2, "backgroundColor",Color.GREEN, Color.BLUE, Color.RED);
        animator2.setDuration(500);
        animator2.setEvaluator(new ArgbEvaluator());
        animator2.setRepeatCount(REVERSE);
        animator2.setRepeatCount(INFINITE);
        animator2.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv = getActivity().findViewById(R.id.tv);
                tv.setText(et.getText().toString());

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv = getActivity().findViewById(R.id.tv);
                tv.setText("");
                et.setText("");
                et.requestFocus();
            }
        });

        return view;
    }
}