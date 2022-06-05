package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SelfAssessmentActivity extends AppCompatActivity {

    ConstraintLayout frame;
    ScrollView scrollView;
    LinearLayout linearLayout;

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8;

    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);

        frame = findViewById(R.id.frameLayout);
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.LinearLayout);

        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);
        t8 = findViewById(R.id.textView8);
        t9 = findViewById(R.id.textView9);
        t10 = findViewById(R.id.textView10);

        r1 = findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        r3 = findViewById(R.id.radio3);
        r4 = findViewById(R.id.radio4);
        r5 = findViewById(R.id.radio5);
        r6 = findViewById(R.id.radio6);
        r7 = findViewById(R.id.radio7);
        r8 = findViewById(R.id.radio8);

        submit = findViewById(R.id.self_assessment_submit);

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
