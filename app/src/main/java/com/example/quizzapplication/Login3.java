package com.example.quizzapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class Login3 extends AppCompatActivity {

    EditText Password,EmailAddress;
    Button buttonlogin,buttonSignup;
    FirebaseAuth mAuth;
    TextView txt;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        mAuth = FirebaseAuth.getInstance();
        Password = findViewById(R.id.Password);
        EmailAddress = findViewById(R.id.EmailAddress);
        buttonlogin = findViewById(R.id.buttonlogin);
        txt = findViewById(R.id.txt);
        buttonSignup = findViewById(R.id.buttonSignup);


        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                finish();
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email, password;
                email = String.valueOf(EmailAddress.getText());
                password = String.valueOf(Password.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Password Cannot be blank", Toast.LENGTH_LONG).show();
                    return;
                }




                //           Code from the fire base.


                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {



                                    //we have to add the Main Activity here In the second line

                                    Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT);

                                        Intent intent = new Intent(getApplicationContext(),LoginIntroduction.class);
                                        startActivity(intent);
                                        finish();

                                } else {

                                    Toast.makeText(Login3.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });


    }
}