package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VaccineStatusActivity extends AppCompatActivity {

    RelativeLayout rl_vaccineStatus, rl_vaccineStatusTitle;

    TextView nameTxt, icTxt, dateTxt, vaccineLocationTxt, vaccineDoseTxt;
    TextView name, ic, date, vaccineLocation, vaccineDose;
    ImageView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_status);

        //Relative Layout
        rl_vaccineStatus = findViewById(R.id.rl_vaccine_status);
        rl_vaccineStatusTitle = findViewById(R.id.rl_vaccine_status_title);

        //title textView
        nameTxt = findViewById(R.id.name_txt);
        icTxt = findViewById(R.id.ic_txt);
        dateTxt = findViewById(R.id.date_txt);
        vaccineLocationTxt = findViewById(R.id.vaccine_location_txt);
        vaccineDoseTxt = findViewById(R.id.vaccine_dose_txt);

        //user info textView
        name = findViewById(R.id.name);
        ic = findViewById(R.id.ic);
        date = findViewById(R.id.date);
        vaccineLocation = findViewById(R.id.vaccine_location);
        vaccineDose = findViewById(R.id.vaccine_dose);

        //Button
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
