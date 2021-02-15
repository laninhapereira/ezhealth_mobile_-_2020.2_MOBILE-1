package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Exercicio;

import java.util.ArrayList;

public class ExampleAdapterExercicio extends RecyclerView.Adapter<ExampleAdapterExercicio.ExampleViewHolder> {

    //Array auxiliar
    private ArrayList<Exercicio> mListaExercicios;
    Context mContext;

    public ExampleAdapterExercicio(Context context, ArrayList<Exercicio> array){
        this.mContext = context;
        this.mListaExercicios = array;
    }

    public ExampleAdapterExercicio(ArrayList<Exercicio> array){
        this.mListaExercicios = array;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textExercicio;
        private TextView textDuracao;
        private TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textExercicio = itemView.findViewById(R.id.TextViewExercicio);
            textDuracao = itemView.findViewById(R.id.TextViewDuracaoExercicio);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasExercicio);
        }

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_exercicio, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Exercicio itemAtual = mListaExercicios.get(position);

        holder.textExercicio.setText(itemAtual.getTextExercicio());
        holder.textDuracao.setText(itemAtual.getTextDuracao());
        holder.textCalorias.setText(itemAtual.getTextCalorias());
    }

    @Override
    public int getItemCount() {
        return mListaExercicios.size();
    }


}
