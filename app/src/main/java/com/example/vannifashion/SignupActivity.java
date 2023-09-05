package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    TextInputEditText username;
    TextInputEditText email;
    TextInputEditText fullname;
    TextInputEditText password;
    AppCompatButton button;
    String flag = "0";

    @SuppressLint("Missinginflatdid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username =findViewById(R.id.signupusername);
        email =findViewById(R.id.email);
        fullname =findViewById(R.id.name);
        password =findViewById(R.id.signuppassword);
        TextInputLayout passwordLayout =findViewById(R.id.passowrdLayout);
        button = (AppCompatButton) findViewById(R.id.b_signup);


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass = s.toString();
                if (pass.length() >= 8){
                    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                    Matcher matcher = pattern.matcher(pass);
                    boolean isPwdContainSpeChar =matcher.find();
                    if(isPwdContainSpeChar){
                        passwordLayout.setHelperText("Strong Password");
                        passwordLayout.setError("");
                    } else {
                        passwordLayout.setHelperText("");
                        passwordLayout.setError("Week password,Include minimum one Special char ");
                    }
                }else{
                    passwordLayout.setHelperText("Enter Minimum 8 char");
                    passwordLayout.setError((""));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Intent i2 = new Intent(this, SigninActivity.class);
        button.setOnClickListener(v -> {
            if(fullname.getText().toString().isEmpty()){
                fullname.setError("Enter Your Name");
            }
            if(username.getText().toString().isEmpty()){
                username.setError("Enter Your Username");
            }if(password.getText().toString().isEmpty()){
                password.setError("Enter Password");
            }
            if(!fullname.getText().toString().isEmpty()&&!username.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()) {
                if (password.getText().toString().length() >= 8) {
                    i2.putExtra("usernameS", username.getText().toString());
                    i2.putExtra("passwordS", password.getText().toString());
                    startActivity(i2);
                    finish();
                }else{
                    password.setError("At-least 8 Character Require");
                }
            }


        });

        /**button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkDataEntered();
                String text = Objects.requireNonNull(username.getText()).toString();
                if (!text.isEmpty()){
                    openActivity2();
                }

                if (Objects.equals(flag, "0")){
                    openActivity2();
                }
            }
        });
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isValidPassword(EditText pass){
        CharSequence s = pass.getText().toString();
        Pattern PASSWORD_PATTERN
                = Pattern.compile("[a-zA-Z0-9!@#$]{8,24}");
        return (!TextUtils.isEmpty(s)) && PASSWORD_PATTERN.matcher(s).matches();
    }
    void checkDataEntered() {
        if (isEmpty(username)) {
            Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT).show();
            username.setError("Username is required!");
            flag = "1";
        }

        if (isEmpty(fullname)) {
            fullname.setError("Last name is required!");
            flag = "1";
        }

        if (!isEmail(email)) {
            email.setError("Enter valid email!");
            flag = "1";
        }
        /**if(!isValidPassword(password)){
            password.setError("Enter valid Password!");
        }

    }

    public void openActivity2(){
        String usernameS = Objects.requireNonNull(username.getText()).toString();
        String passwordS = Objects.requireNonNull(password.getText()).toString();

        Intent intent = new Intent(this, SigninActivity.class);
        intent.putExtra("username", usernameS);
        intent.putExtra("password", passwordS);
        startActivity(intent);
    }*/
    }
}