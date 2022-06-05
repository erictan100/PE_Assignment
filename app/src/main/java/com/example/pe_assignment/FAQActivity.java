package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class FAQActivity extends AppCompatActivity {

    ConstraintLayout frame;
    ScrollView scrollView;
    LinearLayout linearLayout;
    TextView q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);

        frame = findViewById(R.id.frameLayout);

        scrollView = findViewById(R.id.scrollView);

        linearLayout = findViewById(R.id.LinearLayout);

        q1 = findViewById(R.id.textView);
        q2 = findViewById(R.id.textView2);
        q3 = findViewById(R.id.textView3);
        q4 = findViewById(R.id.textView4);
        q5 = findViewById(R.id.textView5);
        q6 = findViewById(R.id.textView6);
        q7 = findViewById(R.id.textView7);
        q8 = findViewById(R.id.textView8);
        q9 = findViewById(R.id.textView9);
        q10 = findViewById(R.id.textView10);
        q11 = findViewById(R.id.textView11);
        q12 = findViewById(R.id.textView12);

        submit = findViewById(R.id.faq_submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}
