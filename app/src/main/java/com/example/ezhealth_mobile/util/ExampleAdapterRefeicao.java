package com.example.ezhealth_mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.AdicionarAlimentoRefeicao_Activity;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.activity.Refeicao_TabFragment;
import com.example.ezhealth_mobile.activity.VisualizarRefeicao_Activity;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;

import java.util.ArrayList;

public class ExampleAdapterRefeicao extends RecyclerView.Adapter<ExampleAdapterRefeicao.ExampleViewHolder> {

    private static OnClickListenerAdapter botaoAdicionar;
    private static OnClickListenerAdapter botaoVisualizar;

    public ExampleAdapterRefeicao(OnClickListenerAdapter botaoAdicionar, OnClickListenerAdapter botaoVisualizar){
        this.botaoAdicionar = botaoAdicionar;
        this.botaoVisualizar = botaoVisualizar;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView textRefeicao;
        public TextView textMassa;
        public TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textRefeicao = itemView.findViewById(R.id.TextViewRefeicao);
            textMassa = itemView.findViewById(R.id.TextViewMassaRefeicao);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasRefeicao);

            itemView.findViewById(R.id.buttonItemRefeicaoAdicionar).setOnClickListener(v -> {
                botaoAdicionar.OnClick(textRefeicao.getText().toString());
            });

            itemView.findViewById(R.id.buttonItemRefeicaoVisualizar).setOnClickListener(v -> {
                botaoVisualizar.OnClick(textRefeicao.getText().toString());
            });

        }

    }

    @NonNull
    @Override
    public ExampleAdapterRefeicao.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_refeicao, parent, false);
        return new ExampleAdapterRefeicao.ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Refeicao itemAtual = Refeicao_Repositorio.getInstance().getItemList(position);

        holder.textRefeicao.setText(itemAtual.getNome());
        holder.textMassa.setText(itemAtual.getQuantidade());
        holder.textCalorias.setText(itemAtual.getCalorias());
    }

    @Override
    public int getItemCount() {
        return Refeicao_Repositorio.getInstance().getList().size();
    }
}
