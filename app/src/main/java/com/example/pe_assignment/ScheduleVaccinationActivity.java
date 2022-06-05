package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ScheduleVaccinationActivity extends AppCompatActivity {

    RelativeLayout rl_schedule_vaccine;

    TextView name_txt, ic_txt, date_txt, location_txt;
    ImageView back;
    CardView name_card, ic_card, date_card, location_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_vaccination);

        rl_schedule_vaccine = findViewById(R.id.rl_schedule_form);

        name_txt = findViewById(R.id.name_txt);
        ic_txt = findViewById(R.id.ic_txt);
        date_txt = findViewById(R.id.date_txt);
        location_txt = findViewById(R.id.location_txt);

        name_card = findViewById(R.id.name_card);
        ic_card = findViewById(R.id.ic_card);
        date_card = findViewById(R.id.date_card);
        location_card = findViewById(R.id.location_card);

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VaccineActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}