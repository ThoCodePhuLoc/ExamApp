package com.example.onlinequizapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.onlinequizapp.MainActivity;
import com.example.onlinequizapp.Profile.SettingView;
import com.example.onlinequizapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {
    private Button logout;
    LinearLayout Setting, Changepass, history, about;
    TextView tvName, tvEmail;
    ImageView avatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.buttonLogout);
        Setting = view.findViewById(R.id.Settings);
        Changepass = view.findViewById(R.id.changePassword);
        history = view.findViewById(R.id.history);
        about = view.findViewById(R.id.about);
        tvName = view.findViewById(R.id.tv_name);
        tvEmail = view.findViewById(R.id.tv_mail);
        avatar = view.findViewById(R.id.img_avatar);
        showUserInformation();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        comeToSetting();
        // Inflate the layout for this fragment
        return view;
    }
    public void onLogout() {
        // Đăng xuất người dùng
        FirebaseAuth.getInstance().signOut();
        Intent intent= new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
    private void showUserInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            return;
        }
        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        if (name == null){
            tvName.setVisibility(View.GONE);
        }else {
            tvName.setVisibility(View.VISIBLE);
            tvName.setText(name);
        }
        tvEmail.setText(email);
        Glide.with((this)).load(photoUrl).error(R.drawable.ic_avatar).into(avatar);
    }
    private void comeToSetting(){
        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingView.class);
                startActivity(intent);
            }
        });
    }
}