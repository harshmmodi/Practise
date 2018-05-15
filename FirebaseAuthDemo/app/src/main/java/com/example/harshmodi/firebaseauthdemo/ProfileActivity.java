package com.example.harshmodi.firebaseauthdemo;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    TextView email;
    Button buttonLogout, verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        email = (TextView)findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button)findViewById(R.id.buttonLogout);
        verify = (Button)findViewById(R.id.buttonVerify);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        email.setText("Welcome "+user.getEmail());
         buttonLogout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 firebaseAuth.signOut();
                 finish();
                 startActivity(new Intent(getApplicationContext(), MainActivity.class));
             }
         });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user1 = firebaseAuth.getCurrentUser();
                user1.reload();
                String em = user1.getEmail();
                String msg = em + "Unver";
                if(user1.isEmailVerified()){
                    Toast.makeText(getBaseContext(), "Verified", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
