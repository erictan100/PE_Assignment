package com.example.pe_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class LanguageFragment extends Fragment {

    private ImageButton backButtonLanguage;

    public LanguageFragment() {
        // Required empty public constructor
    }

    public static LanguageFragment newInstance(String param1, String param2) {
        LanguageFragment fragment = new LanguageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_language, container, false);

        backButtonLanguage = root.findViewById(R.id.backButtonLanguage);
        backButtonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment_activity_setting, new SettingSelectionFragment());
                fr.commit();
            }
        });

        return root;
    }
};