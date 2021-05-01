package com.example.schoo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.schoolender.R;

import java.util.ArrayList;

public class subject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        RecyclerView rv = findViewById(R.id.rec);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Bundle get = getIntent().getExtras();
        final String id = get.getString("id");


        Button insert1 = findViewById(R.id.insert1);
        final SubAdapter ad = new SubAdapter(this,id,arry.array2);
        rv.setAdapter(ad);
        ArrayList<madah> filterPosts = new ArrayList<madah>();
        for (madah post : arry.array2) {
            if (post.getFatherId().equals(id)) {
                filterPosts.add(post);
            }
        }
        ad.filterList(filterPosts);
        insert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(subject.this, madahA.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }

        });


    }
}