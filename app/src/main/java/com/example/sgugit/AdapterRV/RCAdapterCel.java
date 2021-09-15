package com.example.sgugit.AdapterRV;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.Celebrity;
import com.example.sgugit.R;

public class RCAdapterCel extends RecyclerView.Adapter<RCAdapterCel.MyViewHolder3> {

    private String data1[];
    private int images[];
    private Context context;
    private int key;

    public RCAdapterCel(Context context, String s1[], int img[], int key) {
        this.context = context;
        data1 = s1;
        images = img;
        this.key=key;


    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_celebrity, parent, false);
        return new MyViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, int position) {

        holder.tv.setText(data1[position]);
        holder.iv.setImageResource(images[position]);

        holder.ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, Celebrity.class);
                i.putExtra("position", position);
                i.putExtra("key", key);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder3 extends RecyclerView.ViewHolder {

        private TextView tv;
        private ImageView iv;

        ConstraintLayout ml;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_lc);
            iv = itemView.findViewById(R.id.iv_lc);
            ml = itemView.findViewById(R.id.ml);
        }
    }
}

