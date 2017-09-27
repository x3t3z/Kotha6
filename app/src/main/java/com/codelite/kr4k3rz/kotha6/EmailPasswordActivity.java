package com.codelite.kr4k3rz.kotha6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codelite.kr4k3rz.kotha6.model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.paperdb.Paper;

public class EmailPasswordActivity extends BaseActivity {

    private static final String TAG = "FIREBASE";
    private static boolean FLAG = true;

    EditText mEmail, mPassword, mFirstName, mLastName;
    Button mSignIn, mSignUp;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_ui);
        mEmail = (EditText) findViewById(R.id.emailText);
        mPassword = (EditText) findViewById(R.id.passwordText);
        mFirstName = (EditText) findViewById(R.id.firstName);
        mLastName = (EditText) findViewById(R.id.lastName);
        mSignIn = (Button) findViewById(R.id.signinBtn);
        mSignUp = (Button) findViewById(R.id.singupBtn);


        mFirstName.setVisibility(View.GONE);
        mLastName.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();

        mSignUp.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                if (FLAG) {
                    mFirstName.setVisibility(View.VISIBLE);
                    mLastName.setVisibility(View.VISIBLE);
                    mSignIn.setVisibility(View.GONE);
                    FLAG = false;
                } else {
                    showProgressDialog();
                    mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                            .addOnCompleteListener(EmailPasswordActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.

                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        DatabaseReference myRef = database.getReference("users/" + mAuth.getCurrentUser().getUid());
                                        Users name = new Users();
                                        name.setFirstName(mFirstName.getText().toString());
                                        name.setLastName(mLastName.getText().toString());

                                        myRef.setValue(name);
                                        Paper.book().write("user", name);
                                        hideProgressDialog();
                                        startActivity(new Intent(EmailPasswordActivity.this, HomeActivity.class));

                                    } else {
                                        Toast.makeText(EmailPasswordActivity.this, R.string.auth_failed,
                                                Toast.LENGTH_SHORT).show();
                                        hideProgressDialog();
                                    }
                                    finish();
                                }
                            });
                }

            }
        });

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
                mAuth.signInWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                        .addOnCompleteListener(EmailPasswordActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                                    hideProgressDialog();
                                    startActivity(new Intent(EmailPasswordActivity.this, HomeActivity.class));

                                } else {
                                    Log.w(TAG, "signInWithEmail:failed");
                                    Toast.makeText(EmailPasswordActivity.this, R.string.auth_failed,
                                            Toast.LENGTH_SHORT).show();
                                    hideProgressDialog();
                                }
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        });


    }


}

