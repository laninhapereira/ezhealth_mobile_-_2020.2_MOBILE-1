package com.example.ezhealth_mobile.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.ActivityEditarAlimento;
import com.example.ezhealth_mobile.activity.ActivityEditarRefeicao;
import com.example.ezhealth_mobile.entity.ExampleItemAlimento;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class ExampleAdapterAlimento extends RecyclerView.Adapter<ExampleAdapterAlimento.ExampleViewHolder>{


    //Array auxiliar
    private ArrayList<ExampleItemAlimento> mListaAlimentos;
    public Context mContext;

    public ExampleAdapterAlimento(Context context, ArrayList<ExampleItemAlimento> array){
        this.mContext = context;
        this.mListaAlimentos = array;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageResource;
        public TextView textAlimento;
        public TextView textMassa;
        public TextView textCalorias;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textAlimento = itemView.findViewById(R.id.TextViewAlimento);
            textMassa = itemView.findViewById(R.id.TextViewMassaAlimento);
            textCalorias = itemView.findViewById(R.id.TextViewCaloriasAlimento);

            itemView.findViewById(R.id.buttonItemAlimentoEditar).setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), ActivityEditarAlimento.class);
                intent.putExtra("alimento", textAlimento.getText());
                intent.putExtra("telaAnterior", "adicionarRefeicao");
                itemView.getContext().startActivity(intent);
            });

            itemView.findViewById(R.id.buttonItemAlimentoAdicionar).setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), ActivityEditarRefeicao.class);
                intent.putExtra("alimento", textAlimento.getText());
                itemView.getContext().startActivity(intent);
            });

        }

    }

    public ExampleAdapterAlimento(ArrayList<ExampleItemAlimento> listaAlimentos){
        mListaAlimentos = listaAlimentos;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_alimento, parent, false);
        ExampleViewHolder example = new ExampleViewHolder(v);
        return example;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItemAlimento itemAtual = mListaAlimentos.get(position);

        holder.textAlimento.setText(itemAtual.getTextAlimento());
        holder.textMassa.setText(itemAtual.getTextMassa());
        holder.textCalorias.setText(itemAtual.getTextCalorias());

    }

    @Override
    public int getItemCount() {
        return mListaAlimentos.size();
    }


}
