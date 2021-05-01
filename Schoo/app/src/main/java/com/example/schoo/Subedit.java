package com.example.schoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.schoolender.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Subedit extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://schoolender-f458b-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference dbr = db.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subedit);

        Button test = findViewById(R.id.savee);
        final EditText name = findViewById(R.id.namee);
        final EditText Sec = findViewById(R.id.sece);
        final EditText Min = findViewById(R.id.mine);
        final EditText Hour = findViewById(R.id.houre);
        final EditText Day = findViewById(R.id.daye);
        final EditText Month = findViewById(R.id.mone);
        final EditText Year = findViewById(R.id.yeare);
        final EditText week = findViewById(R.id.weeke);
        final EditText color = findViewById(R.id.colore);


        Bundle get = getIntent().getExtras();

        final String id =  get.getString("id");
        final String FatherId =  get.getString("fatherId");
        String sDate = Day.getText().toString() + "-" + Month.getText().toString() + "-" + Year.getText().toString() + " " + Hour.getText().toString() + ":" + Min.getText().toString() + ":" + Sec.getText().toString();
        final madah a = new madah(name.getText().toString(), color.getText().toString(), week.getText().toString(), sDate, id, FatherId);

        name.setText(get.getString("name"));

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String name, String color, String weeks, String date, String id, String fatherId


                Query applesQuery = dbr.child("subjects").orderByChild("id").equalTo(a.getId());

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                           for (int i = 0; i < arry.array2.size(); i++) {
                               if(arry.array2.get(i).getId().equals(a.getId()))
                                   arry.array2.remove(i);
                           }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                arry.array2.add(a);
                dbr.child("subjects").push().setValue(a);

                Intent intent = new Intent(Subedit.this , Main_MenuT.class);
                startActivity(intent);
            }
        });







//        name.setText(oldName);
//        color.setText(oldcolor);

    }
}