package com.example.harshmodi.firebaseauthdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText email, pwd;
    private TextView signup,  forgotPassword;
    private Button b1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.editTextEmail);
        pwd = (EditText)findViewById(R.id.editTextPassword);
        signup = (TextView)findViewById(R.id.textViewSignUp);
        b1 = (Button)findViewById(R.id.buttonLogin);
        forgotPassword = (TextView) findViewById(R.id.ForgotPassword);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null && firebaseAuth.getCurrentUser().isEmailVerified()){
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPass();
            }
        });
    }

    private void forgotPass(){
        final String name = email.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(getBaseContext(), "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.sendPasswordResetEmail(name);
        //if(task.getException() instanceof FirebaseAuthUserCollisionException){
          //  Toast.makeText(getBaseContext(), "User Not Registered! Please Register", Toast.LENGTH_LONG).show();
            //return;
        //}
        String msg = "A Password Reset Link has been sent to " + name + "";
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
        return;
    }

    private void userLogin(){
        String name = email.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(getBaseContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getBaseContext(), "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.length() < 6){
            Toast.makeText(getBaseContext(), "Password must have atleast 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(name, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){

                            FirebaseUser user1 = firebaseAuth.getCurrentUser();
                            if(user1.isEmailVerified()){
                                finish();
                                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            }
                            else {
                                Toast.makeText(getBaseContext(), "Please verify Email", Toast.LENGTH_SHORT).show();
                                return;
                            }


                        }
                        else{
                            Toast.makeText(getBaseContext(), "Login Unsuccesful!\nWrong Email or Password", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
