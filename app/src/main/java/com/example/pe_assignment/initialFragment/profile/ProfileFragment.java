package com.example.pe_assignment.initialFragment.profile;

import static com.example.pe_assignment.LoginActivity.scanName;
import static com.example.pe_assignment.LoginActivity.userID;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pe_assignment.DigitalCertAdapter;
import com.example.pe_assignment.DigitalCertHelper;
import com.example.pe_assignment.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView digitalCert;
    RecyclerView.Adapter adapter;
    private TextView ic, dob, email, state, phoneNo, nameProfile;
    private TextView certName, certIC;

    String emailDB, phoneNoDB, stateDB, dobDB, icDB;

    DatabaseReference reference;

    public ProfileFragment(){

    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_profile, container, false);

        ic = root.findViewById(R.id.profile_icNumber);
        dob = root.findViewById(R.id.profile_DOB);
        email = root.findViewById(R.id.profile_email);
        state = root.findViewById(R.id.profile_state);
        phoneNo = root.findViewById(R.id.profile_phoneNumber);
        nameProfile = root.findViewById(R.id.profilename_txt);

        certIC =  root.findViewById(R.id.tv_certIc);
        certName = root.findViewById(R.id.tv_certName);

        nameProfile.setText(scanName);
        certName.setText(scanName);

        reference = FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                icDB = snapshot.child(userID).child("ic").getValue(String.class);
                emailDB = snapshot.child(userID).child("email").getValue(String.class);
                phoneNoDB = snapshot.child(userID).child("phoneNo").getValue(String.class);
                stateDB = snapshot.child(userID).child("state").getValue(String.class);
                dobDB = snapshot.child(userID).child("dob").getValue(String.class);

                email.setText(emailDB);
                state.setText(stateDB);
                dob.setText(dobDB);
                phoneNo.setText(phoneNoDB);
                ic.setText(icDB);

                certIC.setText(icDB);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        digitalCert = root.findViewById(R.id.recycleView_DigitalCert);
        digitalCert();

        return root;
    }

    private void digitalCert(){

        digitalCert.setHasFixedSize(true);

        digitalCert.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        ArrayList<DigitalCertHelper> digitalCertInfo = new ArrayList<>();

        digitalCertInfo.add(new DigitalCertHelper("Dose 1:", "Date: 12/05/2021", "Time: 13:55","Vaccination Type: Sinovac","Facility: Clinic","Batch Number: 01234567"));
        digitalCertInfo.add(new DigitalCertHelper("Dose 2:", "Date: 15/08/2021", "Time: 15:30","Vaccination Type: Sinovac","Facility: Clinic","Batch Number: 52123456"));
        digitalCertInfo.add(new DigitalCertHelper("Dose 3:", "Date: 25/11/2021", "Time: 10:30","Vaccination Type: Pfizer","Facility: Clinic","Batch Number: 45682349"));

        adapter = new DigitalCertAdapter(digitalCertInfo);

        digitalCert.setAdapter(adapter);
    }
}
