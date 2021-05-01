package com.example.schoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.schoolender.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main_MenuT extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://schoolender-f458b-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference dbr = db.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu_t);

        Button lec = findViewById(R.id.lec);
        Button Task = findViewById(R.id.task);
        Button Class = findViewById(R.id.classss);
        Button misso = findViewById(R.id.misson);
        Button logout = findViewById(R.id.logout);
        Button cal = findViewById(R.id.cal);

        Hello.refreshLis1t();

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_MenuT.this , calen.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(Main_MenuT.this,login.class);
                startActivity(intent);


            }
        });

        misso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_MenuT.this , missions.class);
                startActivity(intent);
            }
        });

        Class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_MenuT.this , MainActivity.class);
                startActivity(intent);
            }
        });

        lec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_MenuT.this , notif.class);
                startActivity(intent);
            }
        });

        Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_MenuT.this , task.class);
                startActivity(intent);
            }
        });
    }
}