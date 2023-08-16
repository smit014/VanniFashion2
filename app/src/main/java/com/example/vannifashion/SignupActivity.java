package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        password =findViewById(R.id.signuppassword);
        AppCompatButton button = (AppCompatButton) findViewById(R.id.b_signup);
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