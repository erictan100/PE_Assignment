package com.example.pe_assignment;

import static com.example.pe_assignment.LoginActivity.userID;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.pe_assignment.HelperClass.ScheduleVaccineHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScheduleVaccinationActivity extends AppCompatActivity {

    RelativeLayout rl_schedule_vaccine;

    EditText etName, etDate, etIC, etLocaiton;
    ImageView back;
    CardView name_card, ic_card, date_card, location_card;


    private String name, ic, date, location;

    DatabaseReference refProfile, refSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_vaccination);

        rl_schedule_vaccine = findViewById(R.id.rl_schedule_form);

        etName = findViewById(R.id.schedule_et_name);
        etIC = findViewById(R.id.schedule_et_ic);
        etDate = findViewById(R.id.schedule_et_date);
        etLocaiton = findViewById(R.id.schedule_et_location);

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

        refProfile = FirebaseDatabase.getInstance().getReference("users");

        refProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ic = snapshot.child(userID).child("ic").getValue(String.class);
                name = snapshot.child(userID).child("name").getValue(String.class);

                etIC.setText(ic);
                etName.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void ScheduleVaccine(View view){

        if(!etName.getText().toString().isEmpty() && !etIC.getText().toString().isEmpty() &&  !etDate.getText().toString().isEmpty() && !etLocaiton.getText().toString().isEmpty()){

            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();

            ScheduleVaccineHelperClass scheduleVaccineHelperClass = new ScheduleVaccineHelperClass(etName.getText().toString(), etIC.getText().toString(), etDate.getText().toString(), etLocaiton.getText().toString());

            refSchedule = FirebaseDatabase.getInstance().getReference("schedule").child(userID);
            refSchedule.setValue(scheduleVaccineHelperClass);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Please Verify all the fields", Toast.LENGTH_SHORT).show();
        }

    }
}