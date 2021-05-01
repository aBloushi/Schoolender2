package com.example.schoo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolender.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class task extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://schoolender-f458b-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference dbr = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        final EditText name = findViewById(R.id.namet);
        final EditText Sec = findViewById(R.id.sect);
        final EditText Min = findViewById(R.id.mint);
        final EditText Hour = findViewById(R.id.hourt);
        final EditText Day = findViewById(R.id.dayt);
        final EditText Month = findViewById(R.id.mont);
        final EditText Year = findViewById(R.id.yeart);
        Button test = findViewById(R.id.savet);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(task.this, "Reminder Set!", Toast.LENGTH_SHORT).show();

                Bundle get = getIntent().getExtras();
                String id = get.getString("id");

                Intent intent = new Intent(task.this, ReminderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(task.this, 0, intent, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeatButtonClick = System.currentTimeMillis();

                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String namea = name.getText().toString();
                ReminderBroadcast.fols = namea;
                Date date = new Date();
                String sDate = Day.getText().toString() + "-" + Month.getText().toString() + "-" + Year.getText().toString() + " " + Hour.getText().toString() + ":" + Min.getText().toString() + ":" + Sec.getText().toString();

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

                taskclass m = new taskclass(name.getText().toString(),sDate,id);
                dbr.child("tasks").push().setValue(m);
                arry.array3.add(m);


                alarmManager.set(AlarmManager.RTC_WAKEUP, afterTime + timeatButtonClick, pendingIntent);
                Intent intent1 = new Intent(task.this, MainActivity.class);
                startActivity(intent1);
            }

        });
    }
}