package com.example.ezhealth_mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

public class ExampleAdapterRefeicaoPersonalizada extends RecyclerView.Adapter<ExampleAdapterRefeicaoPersonalizada.ExampleViewHolder> {

    private static OnClickListenerAdapter botaoEditar;
    private static OnClickListenerAdapter botaoExcluir;
    private static OnClickListenerAdapter botaoEditarNome;

    public ExampleAdapterRefeicaoPersonalizada(OnClickListenerAdapter botaoEditar, OnClickListenerAdapter botaoEditarNome, OnClickListenerAdapter botaoExcluir){
        this.botaoEditar = botaoEditar;
        this.botaoExcluir = botaoExcluir;
        this.botaoEditarNome = botaoEditarNome;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textRefeicaoPersonalizada;
        private TextView textCaloriasPersonalizada;

        private PopupMenu popup;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            textRefeicaoPersonalizada = itemView.findViewById(R.id.TextViewRefeicaoPersonalizada);
            textCaloriasPersonalizada = itemView.findViewById(R.id.TextViewCaloriasRefeicaoPersonalizada);

            configurePopupMenu();

            itemView.findViewById(R.id.imageViewButtonMoreRefeicaoPersonalizada).setOnClickListener(v->{
                popup.show();
            });
        }

        private void configurePopupMenu(){
            popup = new PopupMenu(itemView.getContext(), itemView, Gravity.RIGHT, R.attr.actionOverflowMenuStyle,0);
            popup.getMenuInflater().inflate(R.menu.overflow_menu, popup.getMenu());
            // escolhe o que fazer de acordo com o item selecionado no menu de popup
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getTitle().toString()){
                    case "Editar":
                        botaoEditar.OnClick(textRefeicaoPersonalizada.getText().toString());
                        break;
                    case "Editar Nome":
                        botaoEditarNome.OnClick(textRefeicaoPersonalizada.getText().toString());
                        break;
                    case "Excluir":
                        botaoExcluir.OnClick(textRefeicaoPersonalizada.getText().toString());
                        break;
                }
                return false;
            });
        }

    }
    

    @NonNull
    @Override
    public ExampleAdapterRefeicaoPersonalizada.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_refeicao_personalizada, parent, false);
        return new ExampleAdapterRefeicaoPersonalizada.ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Refeicao itemAtual = (Refeicao) Refeicao_Repositorio.getInstance().getListPersonalizada().get(position);

        holder.textRefeicaoPersonalizada.setText(itemAtual.getNome());
        holder.textCaloriasPersonalizada.setText(itemAtual.getCalorias());
    }


    @Override
    public int getItemCount() {
        return Refeicao_Repositorio.getInstance().getListPersonalizada().size();
    }

}
