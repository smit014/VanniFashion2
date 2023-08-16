package com.example.vannifashion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SignupActivity extends AppCompatActivity {
    private AppCompatButton button;
    EditText username, fullname, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
        username = findViewById(R.id.signupusername);
        email = findViewById(R.id.email);
        fullname = findViewById(R.id.name);
        password = findViewById(R.id.signuppassword);
        button = findViewById(R.id.b_signup);
        button.setOnClickListener(v -> {

            startActivity(intent);
        });
    }

}