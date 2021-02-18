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
import com.example.ezhealth_mobile.activity.EditarAlimento_Activity;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;

import java.util.ArrayList;

public class ExampleAdapterAlimento extends RecyclerView.Adapter<ExampleAdapterAlimento.ExampleViewHolder>{

    private static OnClickListenerAdapter botaoAdicionar;
    private static OnClickListenerAdapter botaoEditar;

    public ExampleAdapterAlimento(OnClickListenerAdapter botaoAdicionar, OnClickListenerAdapter botaoEditar){
        this.botaoAdicionar = botaoAdicionar;
        this.botaoEditar = botaoEditar;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textAlimento;
        private TextView textMassa;
        private TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textAlimento = itemView.findViewById(R.id.TextViewAlimento);
            textMassa = itemView.findViewById(R.id.TextViewMassaAlimento);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasAlimento);

            itemView.findViewById(R.id.buttonItemAlimentoAdicionar).setOnClickListener(v -> {
                botaoAdicionar.OnClick(textAlimento.getText().toString());
            });

            itemView.findViewById(R.id.buttonItemAlimentoEditar).setOnClickListener(v -> {
                botaoEditar.OnClick(textAlimento.getText().toString());
            });

        }
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_alimento, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Alimento itemAtual = (Alimento) new Alimento_Repositorio().getItemList(position);

        holder.textAlimento.setText(itemAtual.getNome());
        holder.textMassa.setText(itemAtual.getQuantidade());
        holder.textCalorias.setText(itemAtual.getCalorias());
    }

    @Override
    public int getItemCount() {
        return new Alimento_Repositorio().getList().size();
    }

}
