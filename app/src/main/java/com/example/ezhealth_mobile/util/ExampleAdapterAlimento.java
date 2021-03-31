package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarAlimento_Activity;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

import java.util.ArrayList;

public class ExampleAdapterAlimento extends RecyclerView.Adapter<ExampleAdapterAlimento.ExampleViewHolder>{

    private static OnClickListenerAdapter botaoAdicionar;
    private static OnClickListenerAdapter botaoEditar;
    private static ArrayList<Alimento> listAlimento;
    private View view;

    public ExampleAdapterAlimento(ArrayList<Alimento> listAlimento, OnClickListenerAdapter botaoAdicionar, OnClickListenerAdapter botaoEditar){
        this.botaoAdicionar = botaoAdicionar;
        this.botaoEditar = botaoEditar;
        this.listAlimento = listAlimento;
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
        }
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_alimento, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Alimento itemAtual = listAlimento.get(position);
        configureButtons(itemAtual);

        holder.textAlimento.setText(itemAtual.getNome());
        holder.textMassa.setText(String.valueOf(itemAtual.getQuantidade()));
        holder.textCalorias.setText(String.valueOf(itemAtual.getCalorias()));
    }

    @Override
    public int getItemCount() {
        return listAlimento.size();
    }

    private void configureButtons(Alimento object){
        view.findViewById(R.id.buttonItemAlimentoAdicionar).setOnClickListener(v -> {
            botaoAdicionar.OnClick(object);
        });

        view.findViewById(R.id.buttonItemAlimentoEditar).setOnClickListener(v -> {
            botaoEditar.OnClick(object);
        });
    }

}
