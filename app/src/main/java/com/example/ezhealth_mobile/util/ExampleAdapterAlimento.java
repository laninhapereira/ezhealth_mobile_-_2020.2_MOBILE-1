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
import com.example.ezhealth_mobile.entity.ItemAlimento_Example;

import java.util.ArrayList;

public class ExampleAdapterAlimento extends RecyclerView.Adapter<ExampleAdapterAlimento.ExampleViewHolder>{


    //Array auxiliar
    private ArrayList<ItemAlimento_Example> mListaAlimentos;
    public Context mContext;

    public ExampleAdapterAlimento(Context context, ArrayList<ItemAlimento_Example> array){
        this.mContext = context;
        this.mListaAlimentos = array;
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

    public ExampleAdapterAlimento(ArrayList<ItemAlimento_Example> listaAlimentos){
        mListaAlimentos = listaAlimentos;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_alimento, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ItemAlimento_Example itemAtual = mListaAlimentos.get(position);

        holder.textAlimento.setText(itemAtual.getTextAlimento());
        holder.textMassa.setText(itemAtual.getTextMassa());
        holder.textCalorias.setText(itemAtual.getTextCalorias());
    }

    @Override
    public int getItemCount() {
        return mListaAlimentos.size();
    }


}
