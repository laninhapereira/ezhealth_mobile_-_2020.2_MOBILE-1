package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;

import java.util.ArrayList;

public class ExampleAdapterExercicio extends RecyclerView.Adapter<ExampleAdapterExercicio.ExampleViewHolder> {

    private static OnClickListenerAdapter botaoAdicionar;
    private static OnClickListenerAdapter botaoEditar;

    public ExampleAdapterExercicio(OnClickListenerAdapter botaoAdicionar, OnClickListenerAdapter botaoEditar){
        this.botaoAdicionar = botaoAdicionar;
        this.botaoEditar = botaoEditar;
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

            itemView.findViewById(R.id.buttonItemExercicioAdicionar).setOnClickListener(v -> {
                botaoAdicionar.OnClick(textExercicio.getText().toString());
            });

            itemView.findViewById(R.id.buttonItemExercicioEditar).setOnClickListener(v -> {
                botaoEditar.OnClick(textExercicio.getText().toString());
            });

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
        Exercicio itemAtual = (Exercicio) new Exercicio_Repositorio().getItemList(position);

        holder.textExercicio.setText(itemAtual.getNome());
        holder.textDuracao.setText(itemAtual.getQuantidade());
        holder.textCalorias.setText(itemAtual.getCalorias());
    }

    @Override
    public int getItemCount() {
        return new Exercicio_Repositorio().getList().size();
    }

}
