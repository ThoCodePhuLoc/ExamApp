<<<<<<< HEAD
package com.example.onlinequizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.onlinequizapp.databinding.ActivityMain2Binding;
import com.example.onlinequizapp.fragment.CreateFragment;
import com.example.onlinequizapp.fragment.HomeFragment;
import com.example.onlinequizapp.fragment.JoinFragment;
import com.example.onlinequizapp.fragment.ProfileFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repalceFreagment(new HomeFragment());

        binding.bottomnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.join) {
                    repalceFreagment(new JoinFragment());
                }else if (item.getItemId() == R.id.create) {
                    repalceFreagment(new CreateFragment());
                }else if (item.getItemId() == R.id.profile) {
                    repalceFreagment(new ProfileFragment());
                    logout = findViewById(R.id.buttonLogout);

                }else if (item.getItemId() == R.id.home) {
                    repalceFreagment(new HomeFragment());
                }
                return true;
            }
        });

    }
    private void repalceFreagment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentview, fragment);
        fragmentTransaction.commit();
    }
=======
package com.example.onlinequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    FirebaseUser mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
>>>>>>> origin/Mạnh
}