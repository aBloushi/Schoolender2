package com.example.schoo;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Hello {
    static FirebaseDatabase db = FirebaseDatabase.getInstance("https://schoolender-f458b-default-rtdb.asia-southeast1.firebasedatabase.app/");
   static DatabaseReference dbr = db.getReference();
    public static void refreshLis1t() {
        arry.arrayl.clear();
        arry.array2.clear();
        arry.array3.clear();

        Query classes = dbr.child("classes");
        Query tasks = dbr.child("tasks");
        Query subjects = dbr.child("subjects");
        classes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot user : snapshot.getChildren()) {
                    f9l insertUser = user.getValue(f9l.class);
                    arry.arrayl.add(insertUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        tasks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot user : snapshot.getChildren()) {
                    taskclass insertUser = user.getValue(taskclass.class);
                    arry.array3.add(insertUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        subjects.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot user : snapshot.getChildren()) {
                    madah insertUser = user.getValue(madah.class);
                    arry.array2.add(insertUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
