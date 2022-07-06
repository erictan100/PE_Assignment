package com.example.pe_assignment.initialFragment.game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pe_assignment.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class QuizGameFragment extends Fragment implements View.OnClickListener {

    QuizDatabase quizDatabase;

    private TextView questionNumber, question, currentPoint, counter;
    private AppCompatButton btn1, btn2, btn3, btn4;

    private static int i;
    private static int totalNoQuestion = 5;
    private static int quizPoint;
    private static int correctQuestionNo;
    private String correctAnswer;

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

        quizDatabase = new QuizDatabase(getContext());
        quizDatabase.createQuestion();

        correctQuestionNo = 0;
        quizPoint = 0;
        i = 1;

        counter = (TextView) root.findViewById(R.id.quiz_counter);
        currentPoint = (TextView) root.findViewById(R.id.tv_currentPoint);
        questionNumber = (TextView) root.findViewById(R.id.tv_questionNumber);
        question = (TextView) root.findViewById(R.id.tv_question);

        btn1 = root.findViewById(R.id.btn_quizAnswer1);
        btn1.setOnClickListener(this);
        btn2 = root.findViewById(R.id.btn_quizAnswer2);
        btn2.setOnClickListener(this);
        btn3 = root.findViewById(R.id.btn_quizAnswer3);
        btn3.setOnClickListener(this);
        btn4 = root.findViewById(R.id.btn_quizAnswer4);
        btn4.setOnClickListener(this);

        new CountDownTimer(30000,1000){

            @Override
            public void onTick (long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                int sec = (int) ((millisUntilFinished / 1000) % 60);

                counter.setText(f.format(sec));
            }

            @Override
            public void onFinish () {
                counter.setText("00");
                if(i <= totalNoQuestion){
                    finishQuiz(quizPoint);
                }
            }
        }.start();

        NextQuestion(i);
        return root;
    }

    public void NextQuestion(int id)
    {
        if(id <= totalNoQuestion)
        {
            questionNumber.setText("(Question " + i + "/" + totalNoQuestion + ")");
            currentPoint.setText("Current points : " + quizPoint);

            Cursor res = quizDatabase.getQuestion(id);
            if(res.getCount() == 0)
            {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
            if(res.moveToNext())
            {
                question.setText(res.getString(1));
                btn1.setText(res.getString(2));
                btn2.setText(res.getString(3));
                btn3.setText(res.getString(4));
                btn4.setText(res.getString(5));
                correctAnswer = res.getString(6);
            }
        }
        else
        {
            if(correctQuestionNo == 4)
            {
                quizPoint = quizPoint + 10;
            }
            else if (correctQuestionNo == 5)
            {
                quizPoint = quizPoint + 20;
            }
            finishQuiz(quizPoint);
        }
    }

    @Override
    public void onClick (View view)
    {
        switch (view.getId()){
            case R.id.btn_quizAnswer1:
                if(btn1.getHint().toString().equals(correctAnswer))
                {
                    alertMessage("Congratulation", "You have answer correctly and get 10 points", i);
                    quizPoint = quizPoint + 10;
                    correctQuestionNo = correctQuestionNo + 1;
                }
                else
                {
                    alertMessage("Opps!!", "You select the wrong answer. The correct answer is: " + correctAnswer, i);
                }
                i = i + 1;
                NextQuestion(i);
                break;

            case R.id.btn_quizAnswer2:
                if(btn2.getHint().toString().equals(correctAnswer))
                {
                    alertMessage("Congratulation", "You have answer correctly and get 10 points", i);
                    quizPoint = quizPoint + 10;
                    correctQuestionNo = correctQuestionNo + 1;
                }
                else
                {
                    alertMessage("Opps!!", "You select the wrong answer. The correct answer is: " + correctAnswer, i);
                }
                i = i + 1;
                NextQuestion(i);
                break;

            case R.id.btn_quizAnswer3:
                if(btn3.getHint().toString().equals(correctAnswer))
                {
                    alertMessage("Congratulation", "You have answer correctly and get 10 points", i);
                    quizPoint = quizPoint + 10;
                    correctQuestionNo = correctQuestionNo + 1;
                }
                else
                {
                    alertMessage("Opps!!", "You select the wrong answer. The correct answer is: " + correctAnswer, i);
                }
                i = i + 1;
                NextQuestion(i);
                break;

            case R.id.btn_quizAnswer4:
                if(btn4.getHint().toString().equals(correctAnswer))
                {
                    alertMessage("Congratulation", "You have answer correctly and get 10 points", i);
                    quizPoint = quizPoint + 10;
                    correctQuestionNo = correctQuestionNo + 1;
                }
                else
                {
                    alertMessage("Opps!!", "You select the wrong answer. The correct answer is: " + correctAnswer, i);
                }
                i = i + 1;
                NextQuestion(i);
                break;
        }
    }

    public void alertMessage(String title, String Content, int i)
    {
        if(i != totalNoQuestion){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle(title)
                    .setMessage(Content)
                    .setCancelable(true)
                    .setPositiveButton("Next Question", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick (DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            alertDialog.show();
        }

    }

    private void finishQuiz(int totalPoints)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle("Quiz Completed")
                .setMessage("You have finish the quiz. The total points you get is " + totalPoints)
                .setCancelable(false)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i) {
                        FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                        fr.replace(R.id.nav_host_fragment_activity_Quiz, new QuizEndFragment());
                        fr.commit();
                    }
                });
        alertDialogBuilder.show();
    }

    public static int getQuizPoint()
    {
        return quizPoint;
    }

    public static int getCorrectQuestionNumber()
    {
        return correctQuestionNo;
    }

    public static void setPoints(int newPoints)
    {
        quizPoint = newPoints;
    }
}