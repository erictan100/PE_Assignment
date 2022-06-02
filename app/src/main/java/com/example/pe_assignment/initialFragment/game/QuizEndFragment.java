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

import com.example.pe_assignment.AboutFragment;
import com.example.pe_assignment.EditProfileActivity;
import com.example.pe_assignment.MainActivity;
import com.example.pe_assignment.R;

public class QuizEndFragment extends Fragment {

    private AppCompatButton btn_tryAgain;
    private ImageButton backButtonQuizEnd;

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

        btn_tryAgain = root.findViewById(R.id.btn_tryAgain);
        backButtonQuizEnd = root.findViewById(R.id.backButtonQuizEnd);

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