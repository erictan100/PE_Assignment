package com.example.pe_assignment.initialFragment.game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.pe_assignment.EditProfileActivity;
import com.example.pe_assignment.MainActivity;
import com.example.pe_assignment.R;

public class QuizInstructionFragment extends Fragment {

    private ImageButton backButtonQuizInstruction;
    private AppCompatButton btn_startQuizGame;

    public QuizInstructionFragment () {
        // Required empty public constructor
    }

    public static QuizInstructionFragment newInstance (String param1, String param2) {
        QuizInstructionFragment fragment = new QuizInstructionFragment();

        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_quiz_instruction, container, false);

        backButtonQuizInstruction = root.findViewById(R.id.backButtonQuizInstruction);
        btn_startQuizGame = root.findViewById(R.id.btn_startQuizGame);

        backButtonQuizInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_startQuizGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment_activity_Quiz, new QuizGameFragment());
                fr.commit();
            }
        });

        return root;
    }
}