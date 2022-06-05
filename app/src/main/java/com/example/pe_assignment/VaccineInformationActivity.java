package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class VaccineInformationActivity extends AppCompatActivity {

    VaccineInfoAdapter vaccineInfoAdapter;
    LinearLayout onBoardingIndicator;
    MaterialButton proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_information);

        onBoardingIndicator = findViewById(R.id.ll_onBoardingIndicator);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.vaccine_info_ViewPager);
        onboardingViewPager.setAdapter(vaccineInfoAdapter);

        setupOnboardingIndicator();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        //Button
        proceed = findViewById(R.id.buttonOnboardingAction);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < vaccineInfoAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), VaccineActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnboardingItems() {

        List<VaccineInfoItem> vaccineInfoItems = new ArrayList<>();

        VaccineInfoItem info_1 = new VaccineInfoItem();
        info_1.setTitle("Pfizer");
        info_1.setManufacturer("Pfizer, Inc., and BioNTech");
        info_1.setDescription("Number of Shots: 2 doses in the primary series, given 3–8 weeks apart.\n" +
                "People ages 5 years and older who are moderately or severely immunocompromised should get a third dose at least 4 weeks after their second dose.\n" +
                "\n" +
                "Booster Shot: People ages 12 years and older who received a Pfizer-BioNTech primary series should get a booster. Some people can also choose to receive a second booster.");
        info_1.setImage(R.drawable.pfizer);

        VaccineInfoItem info_2 = new VaccineInfoItem();
        info_2.setTitle("AstraZeneca");
        info_2.setManufacturer("AstraZeneca, University of Oxford");
        info_2.setDescription("Number of Shots: 2 doses of the AstraZeneca vaccine, given 4 to 12 weeks apart. \n" +
                "You may not be fully protected against COVID-19 until 7 to 14 days after your second dose. \n" +
                "Most people have their second dose 12 weeks after their first, but it can be less time in certain situations.\n" +
                "ATAGI recommends a shorter interval of 4 to 8 weeks between the first and second doses in an outbreak so that maximal protection against COVID-19 can be achieved earlier\n" +
                "\n");
        info_2.setImage(R.drawable.az);

        VaccineInfoItem info_3 = new VaccineInfoItem();
        info_3.setTitle("Sinovac");
        info_3.setManufacturer("Sinovac BioTech");
        info_3.setDescription("The vaccine is given by intramuscular injection into the deltoid muscle. The initial course consists of two doses. The World Health Organization (WHO) recommends an interval of 4 weeks between doses, with data from Chile suggesting that a longer interval provides more robust immunity.\n" +
                "\n" +
                "Early evidence suggests that immunity wanes rapidly, so a booster dose after the initial course might be needed.");
        info_3.setImage(R.drawable.sinovac);

        vaccineInfoItems.add(info_1);
        vaccineInfoItems.add(info_2);
        vaccineInfoItems.add(info_3);

        vaccineInfoAdapter = new VaccineInfoAdapter(vaccineInfoItems);
    }

    private void setupOnboardingIndicator() {
        ImageView[] indicators = new ImageView[vaccineInfoAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 0, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));

            indicators[i].setLayoutParams(layoutParams);
            onBoardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index) {

        int childCount = onBoardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) onBoardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
//        if (index == vaccineInfoAdapter.getItemCount() - 1){
//            proceed.setText("Back");
//        }
//        else{
//            proceed.setText("Next");
//        }
    }

}
