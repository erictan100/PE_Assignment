package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView appfeature;
    RecyclerView.Adapter appFeature_adapter;

    TabLayout tabLayout;
    ViewPager2 viewPager;

    ImageView vaccine, self_assessment, faq, reward, comingsoon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        //ImageView button
        vaccine = root.findViewById(R.id.img_vaccine);
        self_assessment = root.findViewById(R.id.img_selfassessment);
        faq = root.findViewById(R.id.img_faq);
        reward = root.findViewById(R.id.img_reward);
        comingsoon = root.findViewById(R.id.img_comingsoon);

        //RecyclerView
        appfeature = root.findViewById(R.id.app_features);
        appfeature();

        //ViewPager
        tabLayout = root.findViewById(R.id.tab_layout);
        viewPager = root.findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Things to Know"));
        tabLayout.addTab(tabLayout.newTab().setText("Things to Do"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FragmentManager fragmentManager = getParentFragmentManager();
        final HomeTabAdapter adapter = new HomeTabAdapter(fragmentManager, getLifecycle(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), VaccineActivity.class);
                startActivity(intent);

            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), FAQActivity.class);
                startActivity(intent);
            }
        });

        self_assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), SelfAssessmentActivity.class);
                startActivity(intent);
            }
        });

        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MyRewardActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    private void appfeature() {

        appfeature.setHasFixedSize(true);
        appfeature.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ArrayList<AppFeaturesHelperClass> appFeatures = new ArrayList<>();

        appFeatures.add(new AppFeaturesHelperClass(R.drawable.statistics, "Statistics"));
        appFeatures.add(new AppFeaturesHelperClass(R.drawable.vaccination, "Vaccine"));
        appFeatures.add(new AppFeaturesHelperClass(R.drawable.statistics, "Statistics"));
        appFeatures.add(new AppFeaturesHelperClass(R.drawable.vaccination, "Vaccine"));


        appFeature_adapter = new AppFeaturesAdapter(appFeatures);
        appfeature.setAdapter(appFeature_adapter);
    }
}
