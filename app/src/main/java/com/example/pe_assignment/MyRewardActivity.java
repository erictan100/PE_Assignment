package com.example.pe_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pe_assignment.initialFragment.game.QuizGameFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MyRewardActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager2 viewpager2;
    FragmentStateAdapter pagerAdapter;

    private ImageButton backButtonReward;
    public static TextView totalPoint;

    public static int  points = 500;
    public int quizPoint = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reward);

        viewpager2 = findViewById(R.id.viewpager2);
        tab_layout = findViewById(R.id.tab_layout);

        pagerAdapter = new RewardVoucherAdapter(this);
        viewpager2.setAdapter(pagerAdapter);

        String titles[] = {"Active","Expired"};

        new TabLayoutMediator(tab_layout, viewpager2,
                (tab, position) -> tab.setText(titles[position])
        ).attach();

        backButtonReward = findViewById(R.id.backButtonReward);
        backButtonReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MyRewardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        totalPoint = findViewById(R.id.tv_points);
        quizPoint = QuizGameFragment.getQuizPoint();
        points = points + quizPoint;
        QuizGameFragment.setPoints(0);

        totalPoint.setText(String.valueOf(points));
    }

    public static int getTotalPoints(){
        return points;
    }

    public static void setTotalPoint(int newTotalPoints)
    {
        points = newTotalPoints;
        totalPoint.setText(String.valueOf(points));
    }

}