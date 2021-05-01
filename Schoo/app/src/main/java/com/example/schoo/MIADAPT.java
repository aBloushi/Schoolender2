package com.example.schoo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolender.R;

import java.util.ArrayList;

public class MIADAPT extends RecyclerView.Adapter {

    Context context;


    public MIADAPT(Context context) {

        this.context = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvlayout4, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {



        ((ViewHolder) holder).name.setText(arry4.arrayl.get(position).toString());
        ((ViewHolder) holder).date.setText(arry3.arrayl.get(position).toString());
        Log.e("akl","dadad"+arry3.arrayl.get(position));



        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, subject.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arry4.arrayl.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView date;
        public View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            date=itemView.findViewById(R.id.enddate);

            name = itemView.findViewById(R.id.textView);


        }


    }


}
