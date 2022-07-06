package com.example.pe_assignment.initialFragment.profile;

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

import com.example.pe_assignment.DigitalCertAdapter;
import com.example.pe_assignment.DigitalCertHelper;
import com.example.pe_assignment.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView digitalCert;
    RecyclerView.Adapter adapter;

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
