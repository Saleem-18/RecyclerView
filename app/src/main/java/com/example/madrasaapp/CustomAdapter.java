package com.example.madrasaapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList std_id, std_name,std_sabq, std_sabqi, std_manzil;

    CustomAdapter(Activity activity, Context context, ArrayList std_id, ArrayList std_name,ArrayList std_sabq, ArrayList std_sabqi,
                  ArrayList std_manzil){
        this.activity = activity;
        this.context = context;
        this.std_id = std_id;
        this.std_name = std_name;
        this.std_sabq=std_sabq;
        this.std_sabqi = std_sabqi;
        this.std_manzil = std_manzil;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.std_id_txt.setText(String.valueOf(std_id.get(position)));
        holder.std_name_txt.setText(String.valueOf(std_name.get(position)));
        holder.std_sabq_txt.setText(String.valueOf(std_sabq.get(position)));
        holder.std_sabqi_txt.setText(String.valueOf(std_sabqi.get(position)));
        holder.std_manzil_txt.setText(String.valueOf(std_manzil.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(std_id.get(position)));
                intent.putExtra("name", String.valueOf(std_name.get(position)));
                intent.putExtra("sabq", String.valueOf(std_sabq.get(position)));
                intent.putExtra("sabqi", String.valueOf(std_sabqi.get(position)));
                intent.putExtra("manzil", String.valueOf(std_manzil.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return std_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView std_id_txt, std_name_txt,std_sabq_txt, std_sabqi_txt, std_manzil_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            std_id_txt = itemView.findViewById(R.id.std_id_txt);
            std_name_txt = itemView.findViewById(R.id.std_name_txt);
            std_sabqi_txt = itemView.findViewById(R.id.std_sabqi_txt);
            std_manzil_txt = itemView.findViewById(R.id.std_manzil_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}

