package com.example.sgugit.AdapterRV;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.BD.BDMeasurements.MyConstants2;
import com.example.sgugit.BD.BDMeasurements.MyDBManager2;
import com.example.sgugit.Measurements;
import com.example.sgugit.R;

import java.util.ArrayList;
import java.util.List;

public class RCAdapterMeas extends RecyclerView.Adapter<RCAdapterMeas.MyViewHolder2> {
    private Context context;
    private List<ListMeasurements> mainArray;

    public RCAdapterMeas(Context context) {
        this.context = context;
        mainArray = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder2(view, context, mainArray);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.setData2(mainArray.get(position).getTittle());
    }

    @Override
    public int getItemCount() {
        return mainArray.size();
    }

    static class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvTittle;
        private Context context;
        private List<ListMeasurements> mainArray;

        public MyViewHolder2(@NonNull View itemView, Context context, List<ListMeasurements> mainArray) {
            super(itemView);
            this.context = context;
            this.mainArray = mainArray;
            tvTittle = itemView.findViewById(R.id.text_trai);
            itemView.setOnClickListener(this);
        }

        public void setData2(String tittle){
            tvTittle.setText(tittle);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, Measurements.class);
            i.putExtra(MyConstants2.LIST_MEAS_INTENT, mainArray.get(getAdapterPosition()));
            i.putExtra(MyConstants2.EDIT_STATE, false);
            context.startActivity(i);
        }
    }

    public void updateAdapter2(List<ListMeasurements> newList){
        mainArray.clear();
        mainArray.addAll(newList);
        notifyDataSetChanged();
    }
    public void removeItem2 (int pos, MyDBManager2 dbManager2){
        dbManager2.delete(mainArray.get(pos).getId());
        mainArray.remove(pos);
        notifyItemChanged(0, mainArray.size());
        notifyItemRemoved(pos);
    }
}
