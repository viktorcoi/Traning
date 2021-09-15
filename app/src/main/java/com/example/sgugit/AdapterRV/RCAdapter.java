package com.example.sgugit.AdapterRV;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.BD.BDTraining.MyConstants;
import com.example.sgugit.BD.BDTraining.MyDBManager;
import com.example.sgugit.MyTraining;
import com.example.sgugit.R;

import java.util.ArrayList;
import java.util.List;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.MyViewHolder> {
    private Context context;
    private List<ListTraining> mainArray;

    public RCAdapter(Context context) {
        this.context = context;
        mainArray = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_mt, parent, false);
        return new MyViewHolder(view, context, mainArray);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setData(mainArray.get(position).Name);
        holder.setData0(mainArray.get(position).Date);
        holder.setData1(mainArray.get(position).Time);
        holder.setData3(mainArray.get(position).Timer);
    }

    @Override
    public int getItemCount() {
        return mainArray.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
     private TextView tvTittle, tvDate, tvTime, tvTimer;
     private Context context;
     private List<ListTraining> mainArray;

        public MyViewHolder(@NonNull View itemView, Context context, List<ListTraining> mainArray) {
            super(itemView);
            this.context = context;
            this.mainArray = mainArray;
            tvTittle = itemView.findViewById(R.id.text_trai_mt);
            tvDate = itemView.findViewById(R.id.tv_date_to_mt);
            tvTime = itemView.findViewById(R.id.tv_time_to_mt);
            tvTimer = itemView.findViewById(R.id.tv_timer_to_mt);
            itemView.setOnClickListener(this);

        }
        public void setData(String tittle){
            tvTittle.setText(tittle);
        }

        public void setData0(String date){
            tvDate.setText(date);
        }

        public void setData1(String time){
            tvTime.setText(time);
        }

        public void setData3(String timer){
            tvTimer.setText(timer);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, MyTraining.class);
            i.putExtra(MyConstants.LIST_TRAINING_INTENT, mainArray.get(getAdapterPosition()));
            i.putExtra(MyConstants.EDIT_STATE, false);
            context.startActivity(i);
        }
    }
    public void updateAdapter(List<ListTraining> newList) {
        mainArray.clear();
        mainArray.addAll(newList);
        notifyDataSetChanged();
    }
    public void removeItem (int pos, MyDBManager dbManager){
        ListTraining t = mainArray.get(pos);
        if (t == null || t.ID == -1)
            return;
        dbManager.delete(t.ID);
        mainArray.remove(pos);
        notifyItemChanged(0, mainArray.size());
        notifyItemRemoved(pos);
    }
}
