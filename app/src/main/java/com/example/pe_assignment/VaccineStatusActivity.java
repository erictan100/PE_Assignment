package com.example.pe_assignment;

import static com.example.pe_assignment.LoginActivity.userID;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class VaccineStatusActivity extends AppCompatActivity {

    private DatabaseReference refProfile, refSchedule;
    String statusName, statusIC, statusDate, statusLocation;
    TextView name, ic, date, vaccineLocation, vaccineDose;
    ImageView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_status);


        //user info textView
        name = findViewById(R.id.name);
        ic = findViewById(R.id.ic);
        date = findViewById(R.id.date);
        vaccineLocation = findViewById(R.id.vaccine_location);
        vaccineDose = findViewById(R.id.vaccine_dose);

        refProfile = FirebaseDatabase.getInstance().getReference("users");
        refSchedule = FirebaseDatabase.getInstance().getReference("schedule").child(userID);

        refProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                statusIC  = snapshot.child(userID).child("ic").getValue(String.class);
                statusName = snapshot.child(userID).child("name").getValue(String.class);

                ic.setText(statusIC);
                name.setText(statusName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refSchedule.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                statusDate = snapshot.child("date").getValue(String.class);
                statusLocation = snapshot.child("location").getValue(String.class);

                date.setText(statusDate);
                vaccineLocation.setText(statusLocation);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


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
