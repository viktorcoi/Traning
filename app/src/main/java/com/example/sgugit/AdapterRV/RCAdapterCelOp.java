package com.example.sgugit.AdapterRV;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.CelebrityGO;
import com.example.sgugit.R;

public class RCAdapterCelOp extends RecyclerView.Adapter<RCAdapterCelOp.MyViewHolder4> {

    private String data1[], data_left[], data_right[], data_op[];
    private int id;
    private TypedArray images;
    private Context context;

    public void setId(int id) {
        this.id = id;
    }

    private int key;


    public RCAdapterCelOp(Context context, String name[], String left[], String right[], String op[], TypedArray img, int key) {
        this.context = context;
        data1 = name;
        data_left = left;
        data_right = right;
        data_op = op;
        images = img;
        this.key = key;
    }

    @NonNull
    @Override
    public MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_celebrity_op, parent, false);
        return new MyViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder4 holder, int position) {
        holder.tv.setText(data1[position]);
        holder.iv.setImageResource(images.getResourceId(position, 0));
        holder.tv_left.setText(data_left[position]);
        holder.tv_right.setText(data_right[position]);
        holder.tv_op.setText(data_op[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder4 extends RecyclerView.ViewHolder {

        private TextView tv, tv_left, tv_right, tv_op;
        private ImageView iv;
        ConstraintLayout ilco;

        public MyViewHolder4(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textExerciseNameOp);
            // Копирование названия
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (key==666)
                    {
                        ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        Toast.makeText(tv.getContext(), "Название упражнения скопировано", Toast.LENGTH_SHORT).show();
                        ClipData clip = ClipData.newPlainText("", tv.getText().toString());
                        cb.setPrimaryClip(clip);

                        Context context = v.getContext();
                        Intent intent = new Intent(context, CelebrityGO.class);
                        intent.putExtra("key_", 777);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);


                    }else{

                    }
                }
            });
            iv = itemView.findViewById(R.id.im_cel_op);
            tv_left = itemView.findViewById(R.id.trainingCellLeft_op);
            tv_right = itemView.findViewById(R.id.trainingCellRight_op);
            tv_op = itemView.findViewById(R.id.cel_ex_op);
            ilco = itemView.findViewById(R.id.ilco);
        }
    }
}

