package com.codelite.kr4k3rz.kotha6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.paperdb.Paper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity
        Paper.init(this);

        FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if (mFirebaseUser == null) {
            //Not signed in, launch the Sign In Activity
            startActivity(new Intent(this, EmailPasswordActivity.class));
        } else {
            startActivity(new Intent(this, HomeActivity.class));
        }
        finish();

        // close splash activity


    }

}
