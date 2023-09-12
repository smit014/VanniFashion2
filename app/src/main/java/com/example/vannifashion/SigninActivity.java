package com.example.vannifashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SigninActivity extends AppCompatActivity {
    TextInputEditText user,pass;
    AppCompatButton lbtn;
    TextView rbtn;
    int i=2;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        lbtn = findViewById(R.id.bt_signin);
        rbtn = findViewById(R.id.CreateNew);
        Intent intent = getIntent();
        String sEmail =intent.getStringExtra("email");
        String sPass = intent.getStringExtra("pass");
        Intent i3 = new Intent(this,MainActivity.class);
        Intent i1 = new Intent(this,SignupActivity.class);
        lbtn.setOnClickListener(v -> {
            if(user.getText().toString().equals("")){
                user.setError("Enter Enter Email ");
            }
            if(pass.getText().toString().equals("")){
                pass.setError("Enter Enter Password ");
            }
            if(user.getText().toString().equals("smit")&&pass.getText().toString().equals("1234")){
                startActivity(i3);
                finish();
            }
            else if(user.getText().toString().equals(sEmail) && pass.getText().toString().equals(sPass)){
                startActivity(i3);
                finish();
            }
            else{
                user.setError("Invalid Email ");
                pass.setError("Invalid Password ");
                if(i!=0){
                    Toast.makeText(this, "Wrong username or Pass , Only " + i + " attempts left", Toast.LENGTH_SHORT).show();
                    i--;
                }else{
                    lbtn.setEnabled(false);
                }
            }
        });
        rbtn.setOnClickListener(v -> {
                    startActivity(i1);
                    finish();
                }
              );


}

}