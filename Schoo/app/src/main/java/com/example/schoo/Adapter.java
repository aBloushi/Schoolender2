package com.example.schoo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolender.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://schoolender-f458b-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference dbr = db.getReference();
    Context context;

    public Adapter(Context context) {

        this.context = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {


        ((ViewHolder) holder).name.setText(arry.arrayl.get(position).name.toString());


        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, subject.class);

                intent.putExtra("id", arry.arrayl.get(position).id.toString());


                context.startActivity(intent);

            }
        });
        ((ViewHolder) holder).editc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(context);
                final EditText edittext = new EditText(context);
                alert.setView(edittext);
                alert.setTitle("Change");
                alert.setMessage("Change name to ");
                alert.setPositiveButton("Change Name", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        f9l a = arry.arrayl.get(position);

                        Query applesQuery = dbr.child("classes").orderByChild("id").equalTo(arry.arrayl.get(position).getId());

                        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                                    appleSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        a.setName(edittext.getText().toString());
                        arry.arrayl.add(a);
                        dbr.child("classes").push().setValue(a);
                        Log.e("TTTTTTTTTTTTTTTTTTTTTT", edittext.getText().toString());
                        arry.arrayl.remove(position);
                        notifyDataSetChanged();


                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });

                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arry.arrayl.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public View view;
        public Button editc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            editc = itemView.findViewById(R.id.editc);
            name = itemView.findViewById(R.id.textView);


        }


    }


}
