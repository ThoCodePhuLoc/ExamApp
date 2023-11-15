package com.example.onlinequizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextInputEditText s_password, s_username, s_email;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        s_password = findViewById(R.id.s_Password);
//        s_username = findViewById(R.id.s_UserName);
        s_email = findViewById(R.id.s_email);
        signup = (Button) findViewById(R.id.btn_signup1);

        signup.setOnClickListener(view ->{
            createUser();
        });
    }

    private void createUser() {
        String email, username, password;
        email = s_email.getText().toString();
//                username = String.valueOf(s_username.getText());
        password = s_password.getText().toString();
        if (TextUtils.isEmpty(email)) {
            s_email.setError("Email cannot be empty");
            s_email.requestFocus();
        }
//                if (TextUtils.isEmpty(username)) {
//                    Toast.makeText(SignUp.this, "Username is empty", Toast.LENGTH_SHORT).show();
//                    return;
//                }
        if (TextUtils.isEmpty(password)) {
            s_password.setError("Password cannot be empty");
            s_password.requestFocus();
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, MainActivity.class));
                        }else{
                            Toast.makeText(SignUp.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
