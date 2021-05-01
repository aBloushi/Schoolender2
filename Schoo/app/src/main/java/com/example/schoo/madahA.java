package com.example.schoo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolender.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class madahA extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://schoolender-f458b-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference dbr = db.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madah);
        Button test = findViewById(R.id.savem);
        final EditText name = findViewById(R.id.namem);
        final EditText Sec = findViewById(R.id.secm);
        final EditText Min = findViewById(R.id.minm);
        final EditText Hour = findViewById(R.id.hourm);
        final EditText Day = findViewById(R.id.daym);
        final EditText Month = findViewById(R.id.monm);
        final EditText Year = findViewById(R.id.yearm);
        final EditText week = findViewById(R.id.weekm);
        final EditText color = findViewById(R.id.colorm);



        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(madahA.this, "Reminder Set!", Toast.LENGTH_SHORT).show();

                Bundle get = getIntent().getExtras();
               String id = get.getString("id");

                Intent intent = new Intent(madahA.this, ReminderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(madahA.this,0,intent,0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeatButtonClick = System.currentTimeMillis();

                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String namea = name.getText().toString();
                ReminderBroadcast.fols = namea;
                Date date = new Date();
                String sDate = Day.getText().toString()+"-"+Month.getText().toString()+"-"+Year.getText().toString()+" "+ Hour.getText().toString()+":"+Min.getText().toString()+":"+Sec.getText().toString();

                Date date2 = null;
                try {
                    date2 = obj.parse(sDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                long afterTime = (date2.getTime() - date.getTime());

                System.out.println(obj.format(date.getTime()));
                System.out.println(obj.format(date2.getTime()));
                System.out.println(afterTime);

                madah m = new madah(name.getText().toString(),color.getText().toString(),week.getText().toString(),sDate, UUID.randomUUID().toString(),id);
                arry.array2.add(m);
                dbr.child("subjects").push().setValue(m);

                alarmManager.set(AlarmManager.RTC_WAKEUP, afterTime + timeatButtonClick ,pendingIntent);
                Intent intent1 = new Intent(madahA.this,MainActivity.class);
                startActivity(intent1);
            }

        });













    }
}