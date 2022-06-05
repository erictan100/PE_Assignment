package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    EditText ic, pwd;
    TextView register;
    AppCompatButton login, twitter, facebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ic = findViewById(R.id.edittxt_ic);
        pwd = findViewById(R.id.edittxt_password);
        register = findViewById(R.id.txt_register);

        login = findViewById(R.id.btn_login);
        twitter = findViewById(R.id.btn_twitter);
        facebook = findViewById(R.id.btn_facebook);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
