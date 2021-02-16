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

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textAlimento;
        private TextView textMassa;
        private TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textAlimento = itemView.findViewById(R.id.TextViewAlimento);
            textMassa = itemView.findViewById(R.id.TextViewMassaAlimento);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasAlimento);

            itemView.findViewById(R.id.buttonItemAlimentoEditar).setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), EditarAlimento_Activity.class);
                intent.putExtra("ALIMENTO", textAlimento.getText());
                intent.putExtra("TELA_ANTERIOR", "adicionarRefeicao");
                itemView.getContext().startActivity(intent);
            });

            itemView.findViewById(R.id.buttonItemAlimentoAdicionar).setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), EditarRefeicao_Activity.class);
                intent.putExtra("ALIMENTO", textAlimento.getText());
                itemView.getContext().startActivity(intent);
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
        Alimento itemAtual = (Alimento) Alimento_Repositorio.getListaAlimentosGeral().get(position);

        holder.textAlimento.setText(itemAtual.getNome());
        holder.textMassa.setText(itemAtual.getQuantidade());
        holder.textCalorias.setText(itemAtual.getCalorias());
    }

    @Override
    public int getItemCount() {
        return Alimento_Repositorio.getListaAlimentosGeral().size();
    }


}
