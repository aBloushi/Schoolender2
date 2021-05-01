package com.example.schoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolender.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final EditText maily=findViewById(R.id.maily);
        final EditText passy=findViewById(R.id.passy);
        final Button login1=findViewById(R.id.login);
        fAuth = FirebaseAuth.getInstance();
        final Button sign=findViewById(R.id.SIGN);
        final ProgressBar load2=findViewById(R.id.progressBar2);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this,sign.class);
                startActivity(intent);
            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=maily.getText().toString().trim();
                String password=passy.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    maily.setError("name is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passy.setError("password is required");
                }
                if(password.length()<6){
                    passy.setError("password is too short / must be > 6 characters");
                    return;
                }
                load2.setVisibility(View.VISIBLE);








                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login.this, "logged in", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(login.this,Main_MenuT.class);
                            intent.putExtra("email",email);
                            startActivity(intent);
                        }else{
                            Toast.makeText(login.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}