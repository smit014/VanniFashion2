package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {
    EditText susername;
    EditText pass;
    AppCompatButton b_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        susername =findViewById(R.id.username);
        pass = findViewById(R.id.password);
        b_signin =(AppCompatButton) findViewById(R.id.bt_signin);
        b_signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}