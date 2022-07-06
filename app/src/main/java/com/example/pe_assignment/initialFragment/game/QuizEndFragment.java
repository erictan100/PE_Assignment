package com.example.pe_assignment.initialFragment.game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pe_assignment.AboutFragment;
import com.example.pe_assignment.EditProfileActivity;
import com.example.pe_assignment.MainActivity;
import com.example.pe_assignment.R;

public class QuizEndFragment extends Fragment {

    private AppCompatButton btn_tryAgain;
    private ImageButton backButtonQuizEnd;
    private TextView correctQuestions, pointEarned;

    private int quizPoints;
    private int quizCorrectNumber;

    public QuizEndFragment() {
        // Required empty public constructor
    }

    public static QuizEndFragment newInstance(String param1, String param2) {
        QuizEndFragment fragment = new QuizEndFragment();
        Bundle args = new Bundle();

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
        View root = inflater.inflate(R.layout.fragment_quiz_end, container, false);

        correctQuestions = (TextView) root.findViewById(R.id.tv_showCorrectQuestionNumEnd);
        pointEarned = (TextView) root.findViewById(R.id.tv_pointEarnedEnd);
        btn_tryAgain = root.findViewById(R.id.btn_tryAgain);
        backButtonQuizEnd = root.findViewById(R.id.backButtonQuizEnd);

//        FragmentManager fm = getParentFragmentManager();
//        QuizGameFragment fragment = (QuizGameFragment) fm.findFragmentById(R.id.quizGameFragment);
//        quizPoints = fragment.getQuizPoint();
        quizPoints = QuizGameFragment.getQuizPoint();
        quizCorrectNumber = QuizGameFragment.getCorrectQuestionNumber();

        correctQuestions.setText("You got " + quizCorrectNumber + "/5 question correct");
        pointEarned.setText(String.valueOf(quizPoints));

        btn_tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment_activity_Quiz, new QuizInstructionFragment());
                fr.commit();
            }
        });

        backButtonQuizEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}