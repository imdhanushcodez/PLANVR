package com.example.planvr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity {

    EditText email,pass;
    AppCompatButton btn,btn2;

    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        email = findViewById(R.id.loginemail);
        pass = findViewById(R.id.loginpassword);
        btn = findViewById(R.id.loginbtn);

        auth = FirebaseAuth.getInstance();


        if(auth.getCurrentUser()!=null){

            if(auth.getCurrentUser().getEmail().toString().contains(".ad")){
                Intent i = new Intent(loginpage.this, adminpage.class);
                startActivity(i);
            }
            else {
                Intent i = new Intent(loginpage.this, homepage.class);
                startActivity(i);
            }
        }


        btn2 = findViewById(R.id.enterintosignup);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginpage.this, signuppage.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {


                            Toast.makeText(loginpage.this, "login is compeleted successfully", Toast.LENGTH_LONG).show();


                            if (email.getText().toString().contains(".ad")) {
                                Intent i = new Intent(loginpage.this, adminpage.class);
                                startActivity(i);

                            } else
                            {
                                Intent i = new Intent(loginpage.this, homepage.class);
                                startActivity(i);
                        }
                        }
                        else {
                            Toast.makeText(loginpage.this,"please enter valid credentials",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(loginpage.this,decidepage.class);
        startActivity(i);
    }
}