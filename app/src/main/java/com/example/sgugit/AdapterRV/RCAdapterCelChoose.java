package com.example.sgugit.AdapterRV;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.CelebrityOp;
import com.example.sgugit.R;

public class RCAdapterCelChoose extends RecyclerView.Adapter<RCAdapterCelChoose.MyViewHolder4> {

    private String data1[];
    private Context context;
    private int ID;
    private int key;


    public RCAdapterCelChoose(Context context, String s1[], int iID, int key) {
        this.context = context;
        data1 = s1;
        this.ID = iID;
        this.key = key;
    }


    @NonNull
    @Override
    public MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_for_celebrity, parent, false);
        return new MyViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder4 holder, int position) {

        holder.tv.setText(data1[position]);

        holder.ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CelebrityOp.class);
                i.putExtra("position", position);
                i.putExtra("id", ID);
                i.putExtra("key", key);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder4 extends RecyclerView.ViewHolder{
        private TextView tv;
        ConstraintLayout ml;

        public MyViewHolder4(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.text_trai);
            ml = itemView.findViewById(R.id.cl_choose);
        }
    }
}
