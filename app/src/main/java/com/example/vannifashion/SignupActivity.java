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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
   TextInputEditText user,pwd,conpwd,email;
    AppCompatButton rbtn;


    @SuppressLint("Missinginflatdid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user =findViewById(R.id.signupusername);
        email =findViewById(R.id.email);
        pwd =findViewById(R.id.signuppassword);
        TextInputLayout passwordLayout =findViewById(R.id.passowrdLayout);
        rbtn = (AppCompatButton) findViewById(R.id.b_signup);
        conpwd=findViewById(R.id.confirmpasstext);


        pwd.addTextChangedListener(new TextWatcher() {
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
        user = findViewById(R.id.signupusername);
        pwd = findViewById(R.id.signuppassword);
        conpwd = findViewById(R.id.confirmpasstext);
        rbtn = findViewById(R.id.b_signup);

        rbtn.setOnClickListener(v -> {
            if(email.getText().toString().isEmpty()){
                email.setError("Enter Your Email");
            }
            if(user.getText().toString().isEmpty()){
                user.setError("Enter Your Username");
            }if(pwd.getText().toString().isEmpty()){
                pwd.setError("Enter Password");
            }
            if(!email.getText().toString().isEmpty()&&!user.getText().toString().isEmpty()&&!pwd.getText().toString().isEmpty()) {
                if (pwd.getText().toString().length() >= 8) {
                    if (pwd.getText().toString().equals(conpwd.getText().toString())) {
                        i2.putExtra("email", user.getText().toString());
                        i2.putExtra("pass", pwd.getText().toString());
                        startActivity(i2);
                        finish();

                    } else {
                        conpwd.setError("Confirm Password Not Match");
                    }
                }else{
                    pwd.setError("At-least 8 Character Require");
                }
            }


});

}


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
