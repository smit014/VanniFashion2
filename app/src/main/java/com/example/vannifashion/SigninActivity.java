package com.example.vannifashion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SigninActivity extends AppCompatActivity {
    EditText susername, pass;
    AppCompatButton b_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        susername = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        b_signin = findViewById(R.id.bt_signin);
        b_signin.setOnClickListener(v -> {

            startActivity(intent);
        });
    }
}