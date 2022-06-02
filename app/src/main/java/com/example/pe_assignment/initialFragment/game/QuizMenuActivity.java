package com.example.pe_assignment.initialFragment.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.pe_assignment.MainActivity;
import com.example.pe_assignment.R;
import com.example.pe_assignment.SettingSelectionFragment;

public class QuizMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.nav_host_fragment_activity_Quiz, QuizInstructionFragment.class,null)
                    .commit();
        }
    }
}