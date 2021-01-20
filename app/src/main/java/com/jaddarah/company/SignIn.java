package com.jaddarah.company;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Map;

public class SignIn extends AppCompatActivity {

    TextInputEditText txtUsername;
    TextInputEditText txtPassword;
    String usernameHolder,passwordHolder;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtUsername=findViewById(R.id.username);
        txtPassword=findViewById(R.id.password);

        signIn=findViewById(R.id.btn_sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameHolder=txtUsername.getText().toString().trim();
                passwordHolder=txtPassword.getText().toString().trim();

                if(TextUtils.isEmpty(usernameHolder) || TextUtils.isEmpty(passwordHolder)){
                    Toast.makeText(SignIn.this, "Please Enter Username And Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(usernameHolder.equalsIgnoreCase("admin") && passwordHolder.equalsIgnoreCase("123"))
                {
                    Toast.makeText(SignIn.this, "Username Or Password Incorrect", Toast.LENGTH_SHORT).show();
                    return;
                }

                startActivity(new Intent(SignIn.this, MainActivity.class));
            }
        });

        findViewById(R.id.btn_new_account).setOnClickListener(v -> {
            startActivity(new Intent(SignIn.this, CreateAccount.class));
        });
    }
}