package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    OnBoardingAdapter onBoardingAdapter;
    LinearLayout onBoardingIndicator;
    MaterialButton proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        onBoardingIndicator = findViewById(R.id.ll_onBoardingIndicator);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onBoardingViewPager);
        onboardingViewPager.setAdapter(onBoardingAdapter);

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
                if (onboardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnboardingItems() {

        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem intro_1 = new OnBoardingItem();
        intro_1.setTitle("Welcome to WEP Tracing Application");
        intro_1.setImage(R.drawable.introduction_1);

        OnBoardingItem intro_2 = new OnBoardingItem();
        intro_2.setTitle("Your Health, We Care");
        intro_2.setImage(R.drawable.introduction_2);

        OnBoardingItem intro_3 = new OnBoardingItem();
        intro_3.setTitle("Let’s get started!");
        intro_3.setImage(R.drawable.weplogo);

        onBoardingItems.add(intro_1);
        onBoardingItems.add(intro_2);
        onBoardingItems.add(intro_3);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setupOnboardingIndicator() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
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
//        if (index == onBoardingAdapter.getItemCount() - 1){
//            proceed.setText("Start");
//        }
//        else{
//            proceed.setText("Next");
//        }
    }

}
