package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText fullname;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username =findViewById(R.id.signupusername);
        email =findViewById(R.id.email);
        fullname =findViewById(R.id.name);
        TextInputEditText password =findViewById(R.id.signuppassword);
        TextInputLayout passwordLayout =findViewById(R.id.passowrdLayout);
        AppCompatButton button = (AppCompatButton) findViewById(R.id.b_signup);

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
                }else{
                    passwordLayout.setHelperText("Enter Minimum 8 char");
                    passwordLayout.setError((""));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                checkDataEntered();
                openActivity2();
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

    void checkDataEntered() {
        if (isEmpty(username)) {
            Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT).show();
            
        }

        if (isEmpty(fullname)) {
            fullname.setError("Last name is required!");
        }

        if (!isEmail(email)) {
            email.setError("Enter valid email!");
        }

    }
    public void openActivity2(){
        String usernameS = username.getText().toString();
        String passwordS = password.getText().toString();

        Intent intent = new Intent(this, SigninActivity.class);
        intent.putExtra("username", usernameS);
        intent.putExtra("password", passwordS);
        startActivity(intent);
    }
}