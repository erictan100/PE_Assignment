package com.example.pe_assignment;

import static com.example.pe_assignment.LoginActivity.userID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity {

    private ImageButton backButtonProfile;
    private TextInputLayout etEmail, etName, etAddress, etState, etPhoneNo, etPwd;
    private TextView IC;
    private AppCompatEditText etDob;
    private AppCompatButton update;

    DatabaseReference reference;

    String nameFromDB,emailFromDB, phoneNoFromDB, addressFromDB, stateFromDB, dobFromDB, passwordFromDB, icFromDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        backButtonProfile = (ImageButton) findViewById(R.id.backButtonProfile);
        update = findViewById(R.id.btn_saveProfile);

        etEmail = findViewById(R.id.et_email);
        etName = findViewById(R.id.et_profileName);
        etDob = findViewById(R.id.et_DOB);
        etAddress = findViewById(R.id.et_address);
        etState = findViewById(R.id.state);
        etPhoneNo = findViewById(R.id.et_phoneNumber);
        etPwd = findViewById(R.id.et_password);
        IC = findViewById(R.id.txt_IC);

        reference = FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                icFromDB = snapshot.child(userID).child("ic").getValue(String.class);
                nameFromDB = snapshot.child(userID).child("name").getValue(String.class);
                emailFromDB = snapshot.child(userID).child("email").getValue(String.class);
                phoneNoFromDB = snapshot.child(userID).child("phoneNo").getValue(String.class);
                addressFromDB = snapshot.child(userID).child("address").getValue(String.class);
                stateFromDB = snapshot.child(userID).child("state").getValue(String.class);
                dobFromDB = snapshot.child(userID).child("dob").getValue(String.class);
                passwordFromDB = snapshot.child(userID).child("pwd").getValue(String.class);

                etEmail.getEditText().setText(emailFromDB);
                etAddress.getEditText().setText(addressFromDB);
                etName.getEditText().setText(nameFromDB);
                etState.getEditText().setText(stateFromDB);
                etDob.setText(dobFromDB);
                etPhoneNo.getEditText().setText(phoneNoFromDB);
                etPwd.getEditText().setText(passwordFromDB);

                IC.setText(icFromDB);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        backButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean isPasswordChanged() {
        if(!passwordFromDB.equals(etPwd.getEditText().getText().toString()))
        {
            reference.child(icFromDB).child("pwd").setValue(etPwd.getEditText().getText().toString());
            passwordFromDB = etPwd.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isNameChanged() {
        if(!nameFromDB.equals(etName.getEditText().getText().toString())){
            reference.child(icFromDB).child("name").setValue(etName.getEditText().getText().toString());
            nameFromDB = etName.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmailChanged() {
        if(!emailFromDB.equals(etEmail.getEditText().getText().toString())){
            reference.child(icFromDB).child("email").setValue(etEmail.getEditText().getText().toString());
            emailFromDB = etEmail.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isAddressChanged() {
        if(!addressFromDB.equals(etAddress.getEditText().getText().toString())){
            reference.child(icFromDB).child("address").setValue(etAddress.getEditText().getText().toString());
            addressFromDB = etAddress.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isStateChanged() {
        if(!stateFromDB.equals(etState.getEditText().getText().toString())){
            reference.child(icFromDB).child("state").setValue(etState.getEditText().getText().toString());
            stateFromDB = etState.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isDOBChanged() {
        if(!dobFromDB.equals(etDob.getText().toString())){
            reference.child(icFromDB).child("dob").setValue(etDob.getText().toString());
            dobFromDB = etDob.getText().toString();
            return true;
        }else{
            return false;
        }
    }

    private boolean isPhoneNoChanged() {
        if(!phoneNoFromDB.equals(etPhoneNo.getEditText().getText().toString())){
            reference.child(icFromDB).child("phoneNo").setValue(etPhoneNo.getEditText().getText().toString());
            phoneNoFromDB = etPhoneNo.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

    public void UpdateUserInfo(View view){

        if(!validateEmail() | !validateName() | !validateAddress() | !validateState() | !validatePhoneNo() | !validatePassword()){
            return;
        }
        if(isNameChanged() || isPhoneNoChanged() ||isPasswordChanged() || isStateChanged() || isDOBChanged() || isAddressChanged() || isEmailChanged()){
            Toast.makeText(this, "Data is updated successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data is the same and cannot be updated", Toast.LENGTH_SHORT).show();
        }

    }

    private Boolean validateName(){

        String value = etName.getEditText().getText().toString();

        if(value.isEmpty()){
            etName.setError("Field cannot be empty");
            return false;
        }
        else{
            etName.setError(null);
            etName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail(){

        String value = etEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            etEmail.setError("Field cannot be empty");
            return false;
        }
        else if(!value.matches(emailPattern)){
            etEmail.setError("Invalid Email Address");
            return false;
        }
        else{
            etEmail.setError(null);
            etEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo(){

        String value = etPhoneNo.getEditText().getText().toString();

        if(value.isEmpty()){
            etPhoneNo.setError("Field cannot be empty");
            return false;
        }
        else{
            etPhoneNo.setError(null);
            etPhoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateAddress(){

        String value = etAddress.getEditText().getText().toString();

        if(value.isEmpty()){
            etAddress.setError("Field cannot be empty");
            return false;
        }
        else{
            etAddress.setError(null);
            etAddress.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateState(){

        String value = etState.getEditText().getText().toString();

        if(value.isEmpty()){
            etState.setError("Field cannot be empty");
            return false;
        }
        else{
            etState.setError(null);
            etState.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String value = etPwd.getEditText().getText().toString();
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
            etPwd.setError("Field cannot be empty");
            return false;
        }
        else if (!value.matches(passwordvalidate)) {
            etPwd.setError("Password is too weak");
            return false;
        }
        else {
            etPwd.setError(null);
            etPwd.setErrorEnabled(false);
            return true;
        }
    }

}