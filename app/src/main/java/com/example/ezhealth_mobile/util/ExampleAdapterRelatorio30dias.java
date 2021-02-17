package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;

import java.util.ArrayList;

public class ExampleAdapterRelatorio30dias extends RecyclerView.Adapter<ExampleAdapterRelatorio30dias.ExampleViewHolder> {

    //Array auxiliar
    private ArrayList<?> mListaRelatorio;
    Context mContext;

    public ExampleAdapterRelatorio30dias(Context context/*, ArrayList<?> array*/){
        this.mContext = context;
        //this.mListaRelatorio = array;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView text1;
        public TextView text2;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.TextViewRelatorioDia);
            text2 = itemView.findViewById(R.id.TextViewRelatorioCalorias);
        }
    }

    @NonNull
    @Override
    public ExampleAdapterRelatorio30dias.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_dias_relatorio, parent, false);

        ExampleAdapterRelatorio30dias.ExampleViewHolder example = new ExampleAdapterRelatorio30dias.ExampleViewHolder(v);
        return example;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapterRelatorio30dias.ExampleViewHolder holder, int position) {
        holder.text1.setText("Segunda");
        holder.text2.setText("600");
    }

    @Override
    public int getItemCount() {
        return 30;
    }


}
