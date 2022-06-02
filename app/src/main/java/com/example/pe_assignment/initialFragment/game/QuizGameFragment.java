package com.example.pe_assignment.initialFragment.game;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.pe_assignment.AboutFragment;
import com.example.pe_assignment.R;

public class QuizGameFragment extends Fragment {


    private AppCompatButton btn_quizAnswer1;

    public QuizGameFragment() {
        // Required empty public constructor
    }

    public static QuizGameFragment newInstance(String param1, String param2) {
        QuizGameFragment fragment = new QuizGameFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_quiz_game, container, false);

        btn_quizAnswer1 = root.findViewById(R.id.btn_quizAnswer1);

        btn_quizAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment_activity_Quiz, new QuizEndFragment());
                fr.commit();
            }
        });

        return root;
    }
}