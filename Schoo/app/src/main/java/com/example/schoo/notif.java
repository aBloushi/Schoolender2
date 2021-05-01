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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class notif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        Button test = findViewById(R.id.test);
        final EditText Name = findViewById(R.id.name);
        final EditText Sec = findViewById(R.id.sec);
        final EditText Min = findViewById(R.id.min);
        final EditText Hour = findViewById(R.id.hour);
        final EditText Day = findViewById(R.id.day);
        final EditText Month = findViewById(R.id.mon);
        final EditText Year = findViewById(R.id.year);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(notif.this, "Reminder Set11!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(notif.this,ReminderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(notif.this,0,intent,0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeatButtonClick = System.currentTimeMillis();

                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String namea = Name.getText().toString();
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

                alarmManager.set(AlarmManager.RTC_WAKEUP, afterTime + timeatButtonClick ,pendingIntent);

            }

        });






       CLASSES lect1 = new CLASSES(new Date(2021,05,2,4,0,0),"Lect1");






    }
}