package com.example.onlinequizapp.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinequizapp.Login;
import com.example.onlinequizapp.MainActivity2;
import com.example.onlinequizapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassView extends AppCompatActivity {
    Button upPass;
    EditText oldpass, newpass, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_view);
        upPass = findViewById(R.id.ChangePass);
        oldpass = findViewById(R.id.oldPassword);
        newpass = findViewById(R.id.newPassword);
        confirm = findViewById(R.id.confirmPassword);

        upPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePasword();
            }
        });

    }

    private void updatePasword() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String old1 = oldpass.getText().toString();
        String new1 = newpass.getText().toString().trim();
        String confirm1 = confirm.getText().toString().trim();
        try {
            if (TextUtils.isEmpty(old1) || TextUtils.isEmpty(new1) || TextUtils.isEmpty(confirm1)) {
                throw new Exception("Không được để trống.");
            } else if (!new1.equals(confirm1))
            {
                throw new Exception("Xác nhận mật khẩu chưa đúng.");
            }else {
                AuthCredential credential = EmailAuthProvider
                        .getCredential(user.getEmail(), old1);
                user.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    user.updatePassword(new1)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(ChangePassView.this, "Change PassWord Successful", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                }else {
                                    Toast.makeText(ChangePassView.this, "Old PassWord is not correct", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            // Thực hiện hành động tiếp theo
        } catch (Exception e) {
            // Hiển thị thông báo lỗi cho người dùng
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}