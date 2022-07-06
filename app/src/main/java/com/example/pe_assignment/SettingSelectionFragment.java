package com.example.pe_assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingSelectionFragment extends Fragment {

    private SwitchCompat darkModeSw;
    private TextView tv_language, tv_about, tv_account;
    private ImageButton backButtonSetting;
    AppCompatButton logout;


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

        darkModeSw = root.findViewById(R.id.darkModeSw);
        backButtonSetting = root.findViewById(R.id.backButtonSetting);
        tv_about = root.findViewById(R.id.tv_about);
        tv_language = root.findViewById(R.id.tv_language);
        tv_account = root.findViewById(R.id.tv_account);

        logout = root.findViewById(R.id.btn_logout);

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
                fr.replace(R.id.nav_host_fragment_activity_setting, new LanguageFragment());
                fr.commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("save", Context.MODE_PRIVATE);
        darkModeSw.setChecked(sharedPreferences.getBoolean("value",false));

        darkModeSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){

                    SharedPreferences.Editor editor = getContext().getSharedPreferences("save", Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    darkModeSw.setChecked(true);
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else
                {
                    SharedPreferences.Editor editor = getContext().getSharedPreferences("save",Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    darkModeSw.setChecked(false);
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });


        return root;
    }
}