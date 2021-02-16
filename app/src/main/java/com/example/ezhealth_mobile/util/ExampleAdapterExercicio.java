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

    private static Intent intentAdicionar;
    private static Intent intentEditar;

    public ExampleAdapterExercicio(Intent intentAdicionar, Intent intentEditar){
        this.intentAdicionar = intentAdicionar;
        this.intentEditar = intentEditar;
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

            itemView.findViewById(R.id.buttonItemAlimentoAdicionar).setOnClickListener(v -> {
                intentAdicionar.putExtra("EXERCICIO", textExercicio.getText());
                itemView.getContext().startActivity(intentAdicionar);
            });

            itemView.findViewById(R.id.buttonItemAlimentoEditar).setOnClickListener(v -> {
                intentEditar.putExtra("EXERCICIO", textExercicio.getText());
                itemView.getContext().startActivity(intentEditar);
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
        Exercicio itemAtual = Exercicio_Repositorio.getInstance().getList().get(position);

        holder.textExercicio.setText(itemAtual.getNome());
        holder.textDuracao.setText(itemAtual.getQuantidade());
        holder.textCalorias.setText(itemAtual.getCalorias());
    }

    @Override
    public int getItemCount() {
        return Exercicio_Repositorio.getInstance().getList().size();
    }


}
