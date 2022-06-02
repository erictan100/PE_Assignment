package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingSelectionFragment extends Fragment {

    private TextView tv_language, tv_about, tv_account;
    private ImageButton backButtonSetting;

    public SettingSelectionFragment () {
        // Required empty public constructor
    }

    public static SettingSelectionFragment newInstance (String param1, String param2) {
        SettingSelectionFragment fragment = new SettingSelectionFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_setting_selection, container, false);

        backButtonSetting = root.findViewById(R.id.backButtonSetting);
        tv_about = root.findViewById(R.id.tv_about);
        tv_language = root.findViewById(R.id.tv_language);
        tv_account = root.findViewById(R.id.tv_account);

        backButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        tv_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        tv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment_activity_setting, new AboutFragment());
                fr.commit();
            }
        });

        tv_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment_activity_setting, new AboutFragment());
                fr.commit();
            }
        });

        return root;
    }
}