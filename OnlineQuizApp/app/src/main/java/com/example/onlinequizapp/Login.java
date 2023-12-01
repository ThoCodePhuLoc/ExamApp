<<<<<<< HEAD
package com.example.onlinequizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextInputEditText l_password, l_username, l_email;
    Button login;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        l_password = findViewById(R.id.l_Password);
//        l_username = findViewById(R.id.l_UserName);
        l_email = findViewById(R.id.l_email);
        login = (Button) findViewById(R.id.btn_login1);
        back = findViewById(R.id.btnBack);
        String email, username, password;
        login.setOnClickListener(view -> {
            loginUser();
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Quay lại màn hình trước đó
        super.onBackPressed();
    }

        private void loginUser(){

            String email, username, password;
            email = l_email.getText().toString();
//                username = String.valueOf(s_username.getText());
            password = l_password.getText().toString();
//            if (TextUtils.isEmpty(email)) {
//                l_email.setError("Email cannot be empty");
//                l_email.requestFocus();
//            }
////                if (TextUtils.isEmpty(username)) {
////                    Toast.makeText(SignUp.this, "Username is empty", Toast.LENGTH_SHORT).show();
////                    return;
////                }
//            if (TextUtils.isEmpty(password)) {
//                l_password.setError("Password cannot be empty");
//                l_password.requestFocus();
//            }
            try {
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    throw new Exception("Email và password không được để trống.");
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "User Login successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this, MainActivity2.class));
                                }else{
                                    Toast.makeText(Login.this, "Login Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                // Thực hiện hành động tiếp theo
            } catch (Exception e) {
                // Hiển thị thông báo lỗi cho người dùng
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }


        }
=======
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextInputEditText l_password, l_username, l_email;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        l_password = findViewById(R.id.l_Password);
//        l_username = findViewById(R.id.l_UserName);
        l_email = findViewById(R.id.l_email);
        login = (Button) findViewById(R.id.btn_login1);
        String email, username, password;
        login.setOnClickListener(view -> {
            loginUser();
        });
    }
        private void loginUser(){

            String email, username, password;
            email = l_email.getText().toString();
//                username = String.valueOf(s_username.getText());
            password = l_password.getText().toString();
            if (TextUtils.isEmpty(email)) {
                l_email.setError("Email cannot be empty");
                l_email.requestFocus();
            }
//                if (TextUtils.isEmpty(username)) {
//                    Toast.makeText(SignUp.this, "Username is empty", Toast.LENGTH_SHORT).show();
//                    return;
//                }
            if (TextUtils.isEmpty(password)) {
                l_password.setError("Password cannot be empty");
                l_password.requestFocus();
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, MainActivity2.class));
                            }else{
                                Toast.makeText(Login.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
>>>>>>> origin/Mạnh
}