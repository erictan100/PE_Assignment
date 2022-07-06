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

import com.example.pe_assignment.HelperClass.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout regEmail, regName, regIC, regDob, regAddress, regState, regPhoneNo, regPwd;
    AppCompatButton register;
    CheckBox checkbox;
    ImageView back;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regEmail = findViewById(R.id.reg_email);
        regName = findViewById(R.id.reg_name);
        regIC = findViewById(R.id.reg_ic);
        regDob = findViewById(R.id.reg_dob);
        regAddress = findViewById(R.id.reg_address);
        regState = findViewById(R.id.reg_state);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPwd = findViewById(R.id.reg_pwd);

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
    }

    private Boolean validateName(){

        String value = regName.getEditText().getText().toString();

        if(value.isEmpty()){
            regName.setError("Field cannot be empty");
            return false;
        }
        else{
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail(){

        String value = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            regEmail.setError("Field cannot be empty");
            return false;
        }
        else if(!value.matches(emailPattern)){
            regEmail.setError("Invalid Email Address");
            return false;
        }
        else{
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo(){

        String value = regPhoneNo.getEditText().getText().toString();

        if(value.isEmpty()){
            regPhoneNo.setError("Field cannot be empty");
            return false;
        }
        else{
            regPhoneNo.setError(null);
            regPhoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateAddress(){

        String value = regAddress.getEditText().getText().toString();

        if(value.isEmpty()){
            regAddress.setError("Field cannot be empty");
            return false;
        }
        else{
            regAddress.setError(null);
            regAddress.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateState(){

        String value = regState.getEditText().getText().toString();

        if(value.isEmpty()){
            regState.setError("Field cannot be empty");
            return false;
        }
        else{
            regState.setError(null);
            regState.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateIC(){

        String value = regIC.getEditText().getText().toString();

        if(value.isEmpty()){
            regIC.setError("Field cannot be empty");
            return false;
        }
        else{
            regIC.setError(null);
            regIC.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateDOB(){

        String value = regDob.getEditText().getText().toString();

        if(value.isEmpty()){
            regDob.setError("Field cannot be empty");
            return false;
        }
        else{
            regDob.setError(null);
            regDob.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String value = regPwd.getEditText().getText().toString();
        String passwordvalidate = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (value.isEmpty()) {
            regPwd.setError("Field cannot be empty");
            return false;
        }
        else if (!value.matches(passwordvalidate)) {
            regPwd.setError("Password is too weak");
            return false;
        }
        else {
            regPwd.setError(null);
            regPwd.setErrorEnabled(false);
            return true;
        }
    }

    public void RegisterUser(View view){

        if(!validateEmail() | !validateName() | !validateIC() | !validateDOB() | !validateAddress() | !validateState() | !validatePhoneNo() | !validatePassword()){
            return;
        }

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("users");

        String name = regName.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String ic = regIC.getEditText().getText().toString();
        String dob = regDob.getEditText().getText().toString();
        String address = regAddress.getEditText().getText().toString();
        String state = regState.getEditText().getText().toString();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String pwd = regPwd.getEditText().getText().toString();

        UserHelperClass helperClass = new UserHelperClass(email, name, ic, dob, address, state, phoneNo, pwd);

        reference.child(ic).setValue(helperClass);
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();

    }
}
