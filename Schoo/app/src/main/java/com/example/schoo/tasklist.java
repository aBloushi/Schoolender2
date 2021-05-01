package com.example.schoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolender.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class tasklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist);
        RecyclerView rv = findViewById(R.id.rect);


        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Bundle get = getIntent().getExtras();
        final String id = get.getString("id");

        Button insert1 = findViewById(R.id.insertt);
        final taskAdapter ad = new taskAdapter(this, id, arry.array3);
        rv.setAdapter(ad);
        ArrayList<taskclass> filterPosts = new ArrayList<taskclass>();
        for (taskclass post : arry.array3) {
            if (post.getFatherId().equals(id)) {
                filterPosts.add(post);
            }
        }
        ad.filterList(filterPosts);
        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(tasklist.this, task.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }

        });


    }
}