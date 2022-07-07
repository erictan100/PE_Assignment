package com.example.pe_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout ic, pwd;
    ImageView register;
    Button login;
    ProgressBar progressBar;
    AppCompatButton twitter, facebook;

    public static String scanName;

    public static String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ic = findViewById(R.id.login_IC);
        pwd = findViewById(R.id.loginPass);
        register = findViewById(R.id.nav_userPhoto);
        progressBar = findViewById(R.id.progressBar);

        login = findViewById(R.id.btn_login);
        twitter = findViewById(R.id.btn_twitter);
        facebook = findViewById(R.id.btn_facebook);

        progressBar.setVisibility(View.INVISIBLE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void LoginUser(View view){

        if (!validateIC() | !validatePassword()) {
            return;
        }
        else{
            Login();
        }

    }

    private void Login() {

        final String userIC = ic.getEditText().getText().toString().trim();
        final String userPassword = pwd.getEditText().getText().toString().trim();

        progressBar.setVisibility(View.VISIBLE);
        login.setVisibility(View.INVISIBLE);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");


        Query checkUser = reference.orderByChild("ic").equalTo(userIC);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    ic.setError(null);
                    ic.setErrorEnabled(false);

                    userID = userIC;

                    scanName = snapshot.child(userIC).child("name").getValue(String.class);

                    String passwordFromDB = snapshot.child(userIC).child("pwd").getValue(String.class);

                    if(passwordFromDB.equals(userPassword)){

                        ic.setError(null);
                        ic.setErrorEnabled(false);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);


                        startActivity(intent);
                        finish();
                    }
                    else{
                        login.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                        pwd.setError("Wrong Password");
                        pwd.requestFocus();

                    }
                }
                else{

                    ic.setError("No suc User exist");
                    ic.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private boolean validatePassword() {
        String value = pwd.getEditText().getText().toString();

        if (value.isEmpty()) {
            pwd.setError("Field cannot be empty");
            return false;
        }
        else {
            pwd.setError(null);
            pwd.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateIC() {
        String value = ic.getEditText().getText().toString();

        if (value.isEmpty()) {
            ic.setError("Field cannot be empty");
            return false;
        }
        else {
            ic.setError(null);
            ic.setErrorEnabled(false);
            return true;
        }
    }

}

