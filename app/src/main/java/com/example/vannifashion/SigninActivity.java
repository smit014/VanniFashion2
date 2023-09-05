package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class SigninActivity extends AppCompatActivity {
    TextInputEditText user;
    TextInputEditText pass;
    AppCompatButton b_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        user =findViewById(R.id.username);
        pass = findViewById(R.id.password);
        b_signin =(AppCompatButton) findViewById(R.id.bt_signin);

        Intent intent =getIntent();
        String sUsername = intent.getStringExtra("usernameS");
        String sPassword = intent.getStringExtra("passwordS");

        Intent i3 = new Intent(this, MainActivity.class);
        b_signin.setOnClickListener(v -> {
            if(user.getText().toString().equals("")){
                user.setError("Enter Username");
            }
            if(pass.getText().toString().equals("")){
                pass.setError("Enter password");
            }
        if(user.getText().toString().equals(sUsername) && pass.getText().toString().equals(sPassword)){
            startActivity(i3);
            finish();
        } else{
            user.setError("Invalid Email");
            pass.setError("Invalid password");
        }

        });

    }

}