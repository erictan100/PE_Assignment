package com.example.pe_assignment;

import static com.example.pe_assignment.LoginActivity.userID;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelfAssessmentActivity extends AppCompatActivity {

    ConstraintLayout frame;
    ScrollView scrollView;
    LinearLayout linearLayout;

    RadioButton r1,r2,r3,r4;
    RadioGroup q1, q2, q3,q4;

    DatabaseReference reference;

    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);

        frame = findViewById(R.id.frameLayout);
        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.LinearLayout);


        q1 = findViewById(R.id.radioQ1);
        q2 = findViewById(R.id.radioQ2);
        q3 = findViewById(R.id.radioQ3);
        q4 = findViewById(R.id.radioQ4);

        reference = FirebaseDatabase.getInstance().getReference("assessment");

        submit = findViewById(R.id.self_assessment_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get selected radio button from radioGroup
                int selectedIdQ1 = q1.getCheckedRadioButtonId();
                int selectedIdQ2 = q2.getCheckedRadioButtonId();
                int selectedIdQ3 = q3.getCheckedRadioButtonId();
                int selectedIdQ4 = q4.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                r1 = findViewById(selectedIdQ1);
                r2 = findViewById(selectedIdQ2);
                r3 = findViewById(selectedIdQ3);
                r4 = findViewById(selectedIdQ4);;

                reference.child(userID).child("q1").setValue(r1.getText().toString());
                reference.child(userID).child("q2").setValue(r2.getText().toString());
                reference.child(userID).child("q3").setValue(r3.getText().toString());
                reference.child(userID).child("q4").setValue(r4.getText().toString());

                if(r1.getText().toString().equals("Yes") && r2.getText().toString().equals("Yes") && r3.getText().toString().equals("Yes") && r4.getText().toString().equals("Yes")){

                    String RiskStatus = "High";
                }
                else if (r1.getText().toString().equals("Yes") && r2.getText().toString().equals("Yes") && r3.getText().toString().equals("Yes") && r4.getText().toString().equals("No")){

                    String RiskStatus = "High";
                }
                else if (r1.getText().toString().equals("Yes") && r2.getText().toString().equals("Yes") && r3.getText().toString().equals("No") && r4.getText().toString().equals("Yes")){

                    String RiskStatus = "High";
                }
                else if (r1.getText().toString().equals("Yes") && r2.getText().toString().equals("No") && r3.getText().toString().equals("Yes") && r4.getText().toString().equals("Yes")){

                    String RiskStatus = "High";
                }
                else if (r1.getText().toString().equals("No") && r2.getText().toString().equals("Yes") && r3.getText().toString().equals("Yes") && r4.getText().toString().equals("Yes")){

                    String RiskStatus = "High";
                }
                else if(r1.getText().toString().equals("Yes") && r2.getText().toString().equals("Yes") && r3.getText().toString().equals("No") && r4.getText().toString().equals("No")){
                    String RiskStatus = "Medium";
                }
                else if(r1.getText().toString().equals("No") && r2.getText().toString().equals("No") && r3.getText().toString().equals("Yes") && r4.getText().toString().equals("Yes")){
                    String RiskStatus = "Medium";
                }

                else if(r1.getText().toString().equals("Yes") && r2.getText().toString().equals("No") && r3.getText().toString().equals("Yes") && r4.getText().toString().equals("No")){
                    String RiskStatus = "Medium";
                }

                else if(r1.getText().toString().equals("No") && r2.getText().toString().equals("Yes") && r3.getText().toString().equals("No") && r4.getText().toString().equals("Yes")){
                    String RiskStatus = "Medium";
                }
                else
                {
                    String RiskStatus = "Low";
                }

                Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
