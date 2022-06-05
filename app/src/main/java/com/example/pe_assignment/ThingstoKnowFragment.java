package com.example.pe_assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThingstoKnowFragment extends Fragment {

    RecyclerView thingstoKnow;
    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.things_to_know_tab_fragment, container, false);

        thingstoKnow = root.findViewById(R.id.things_to_know);
        thingstoKnow();
        return root;
    }

    private void thingstoKnow() {

        thingstoKnow.setHasFixedSize(true);
        thingstoKnow.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        ArrayList<ThingstoKnowHelperClass> thingstoKnows = new ArrayList<>();

        thingstoKnows.add(new ThingstoKnowHelperClass(R.drawable.covidnews, R.drawable.logo_kkm, "KKM","Official Website","The official Malaysia government website for data and insights on COVID-19."));
        thingstoKnows.add(new ThingstoKnowHelperClass(R.drawable.covidnews, R.drawable.logo_kkm, "KKM","Official Website","The official Malaysia government website for data and insights on COVID-19."));

        adapter = new ThingstoKnowAdapter(thingstoKnows);
        thingstoKnow.setAdapter(adapter);
    }
}
