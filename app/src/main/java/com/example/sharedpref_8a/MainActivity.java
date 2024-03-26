package com.example.sharedpref_8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    View loginView, signupView;
    Button btnLoginL, btnLoginR, btnSignupL, btnSignupR;
    TextInputEditText etUsername, etPassword, etRUsername, etRPassword, etRConfirmPassword;

    Fragment LoginFragment, SignUpFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        

        setContentView(R.layout.activity_main);

        init();

//        manager.beginTransaction()
//                .hide(SignUpFragment)
//                .show(LoginFragment)
//                .commit();


//        Toast.makeText(this, "vdsfvsdvsd", Toast.LENGTH_SHORT).show();

//        SharedPreferences sPref = getSharedPreferences("Login", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sPref.edit();
//        SharedPreferences.Editor editor1 = sPref.edit();
//
//        boolean flag = sPref.getBoolean("isLogin", false);
//        if(flag)
//        {
//            Intent intent = new Intent(MainActivity.this,
//                    Home.class);
//            startActivity(intent);
//            finish();
//        }
//        Toast.makeText(this, "dsdgfsgs", Toast.LENGTH_SHORT).show();

        btnSignupL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.beginTransaction()
                        .hide(LoginFragment)
                        .show(SignUpFragment)
                        .commit();
            }
        });

        btnLoginR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.beginTransaction()
                        .show(LoginFragment)
                        .hide(SignUpFragment)
                        .commit();
            }
        });

        btnSignupR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                    MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        btnLoginL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void init()
    {
        manager = getSupportFragmentManager();

        loginView = Objects.requireNonNull(manager.findFragmentById(R.id.fragLogin)).requireView();
        signupView = Objects.requireNonNull(manager.findFragmentById(R.id.fragSignup)).requireView();
        btnLoginL = loginView.findViewById(R.id.LoginL);
        btnSignupL = loginView.findViewById(R.id.btnsignupL);
        btnLoginR = signupView.findViewById(R.id.btnloginS);
        btnSignupR = signupView.findViewById(R.id.btnsignupS);

        etUsername = loginView.findViewById(R.id.etUsername);
        etPassword = loginView.findViewById(R.id.etPassword);
//        etRUsername = signupView.findViewById(R.id.etRUsername);
//        etRPassword = signupView.findViewById(R.id.etRPassword);
//        etRConfirmPassword = signupView.findViewById(R.id.etRConfirmPassword);

        LoginFragment = manager.findFragmentById(R.id.fragLogin);
        SignUpFragment = manager.findFragmentById(R.id.fragSignup);

    }
}