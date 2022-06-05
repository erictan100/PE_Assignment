package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class RegisterActivity extends AppCompatActivity {

    EditText email, name, ic, dob, address, state, phoneNo, pwd;
    AppCompatButton register;
    CheckBox checkbox;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.edittxt_email);
        name = findViewById(R.id.edittxt_name);
        ic = findViewById(R.id.edittxt_ic);
        dob = findViewById(R.id.edittxt_dob);
        address = findViewById(R.id.edittxt_address);
        state = findViewById(R.id.edittxt_state);
        phoneNo = findViewById(R.id.edittxt_phone);
        pwd = findViewById(R.id.edittxt_password);

        back = findViewById(R.id.btn_back);

        checkbox = findViewById(R.id.checkBox);

        register = findViewById(R.id.btn_register);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
