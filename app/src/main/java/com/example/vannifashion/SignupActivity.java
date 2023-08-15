package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private AppCompatButton button;
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
        button =(AppCompatButton) findViewById(R.id.b_signup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }
}