package com.example.schoo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolender.R;

import java.util.ArrayList;

public class SubAdapter extends RecyclerView.Adapter {

    Context context;
    String id;
    ArrayList<madah> arrayList;

    public SubAdapter(Context context, String id, ArrayList<madah> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
        this.id = id;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).name.setText(arrayList.get(position).getName().toString());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(context, tasklist.class);
                intent.putExtra("id", arrayList.get(position).getId());
                context.startActivity(intent);
                try {
                    ((ViewHolder) holder).rl.setBackgroundColor(Color.parseColor(arrayList.get(position).getColor()));
                } catch (Exception e) {

                }

                ((ViewHolder) holder).editc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(context,Subedit.class);

                        String id = arrayList.get(position).getId();
                        String fatherId = arrayList.get(position).getFatherId();
                        intent1.putExtra("id", id);
                        intent1.putExtra("name", arrayList.get(position).getName());
                        intent1.putExtra("fatherId", fatherId);
                        context.startActivity(intent1);

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterList(ArrayList<madah> filterList) {
        arrayList = filterList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public View view;
        public RelativeLayout rl;
        public Button editc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            rl = itemView.findViewById(R.id.subColor);
            editc = itemView.findViewById(R.id.editSub);
            name = itemView.findViewById(R.id.textView);


        }


    }


}
