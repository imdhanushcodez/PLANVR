package com.example.planvr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class regpage extends AppCompatActivity {

    EditText email,pass;
    AppCompatButton btn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);
        email = findViewById(R.id.regemail);
        pass = findViewById(R.id.regpass);
        btn = findViewById(R.id.regbtn);

        auth = FirebaseAuth.getInstance();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(regpage.this,"registration is compeleted successfully",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(regpage.this,loginpage.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(regpage.this,"already registred email or password must 6 digit or above",Toast.LENGTH_LONG).show();
                            Toast.makeText(regpage.this," or check the email format",Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });


    }
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(regpage.this,loginpage.class);
        startActivity(i);
    }
}