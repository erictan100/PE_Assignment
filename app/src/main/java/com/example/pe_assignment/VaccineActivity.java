package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class VaccineActivity extends AppCompatActivity {

    CardView schedule, status, info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        schedule = findViewById(R.id.schedule_vaccine);
        status = findViewById(R.id.vaccine_status);
        info = findViewById(R.id.vaccine_info);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ScheduleVaccinationActivity.class);
                startActivity(intent);
                finish();

            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VaccineStatusActivity.class);
                startActivity(intent);
                finish();

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VaccineInformationActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
