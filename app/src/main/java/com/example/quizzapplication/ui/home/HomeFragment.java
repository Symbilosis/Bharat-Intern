package com.example.quizzapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.quizzapplication.Computer_Quizz;
import com.example.quizzapplication.MainActivity3;
import com.example.quizzapplication.Mathematic_quizz;
import com.example.quizzapplication.R;

public class HomeFragment extends Fragment {


    Button Mathematics,Computer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize UI elements
        Mathematics = rootView.findViewById(R.id.Mathematics); // Replace with your button's ID
        Computer = rootView.findViewById(R.id.Computer);


        // Set click listener for the button
        Mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getActivity(), "Your Screen is Loading", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Mathematic_quizz.class);
                startActivity(intent);
            }
        });

        Computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getActivity(), "Your Screen is loading", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), Computer_Quizz.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}