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

public class sign extends AppCompatActivity {
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        final EditText name=findViewById(R.id.name);
        final EditText pass=findViewById(R.id.pass);
        final EditText mail=findViewById(R.id.mail);
        Button sign=findViewById(R.id.account2);
        final ProgressBar load=findViewById(R.id.progressBar);
        fAuth= FirebaseAuth.getInstance();
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username=name.getText().toString().trim();
                final String email=mail.getText().toString().trim();
                String password=pass.getText().toString().trim();
                if(TextUtils.isEmpty(username)){
                    mail.setError("name is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    pass.setError("password is required");
                }
                if(password.length()<6){
                    pass.setError("password is too short / must me > 6 characters");
                    return;
                }
                if(TextUtils.isEmpty(username)){
                    name.setError("name is required");
                }
                load.setVisibility(View.VISIBLE);




                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(sign.this, "user created", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(sign.this,Main_MenuT.class);
                            intent.putExtra("email",email);
                            startActivity(intent);

                        }else {
                            Toast.makeText(sign.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });

    }
    }
