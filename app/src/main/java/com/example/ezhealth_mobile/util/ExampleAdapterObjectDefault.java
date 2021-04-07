package com.example.ezhealth_mobile.util;


import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ObjectDefault;

import java.util.ArrayList;
import java.util.List;


public class ExampleAdapterObjectDefault extends RecyclerView.Adapter<ExampleAdapterObjectDefault.ViewHolder>{

    private static OnClickListenerAdapter botaoEditar;
    private static OnClickListenerAdapter botaoExcluir;
    private static OnClickListenerAdapter botaoEditarNome;
    private boolean menuOpcoesHabilitado;
    private List list;
    private PopupMenu popup;
    private View view;


    public ExampleAdapterObjectDefault(boolean menuOpcoesHabilitado, List list,
                                       OnClickListenerAdapter botaoEditar, OnClickListenerAdapter botaoEditarNome, OnClickListenerAdapter botaoExcluir){
        this.menuOpcoesHabilitado = menuOpcoesHabilitado;
        this.list = list;
        this.botaoExcluir = botaoExcluir;
        this.botaoEditar = botaoEditar;
        this.botaoEditarNome = botaoEditarNome;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView quantidade;
        private TextView unidadeMedida;
        private TextView calorias;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.textViewItemTitle);
            quantidade = itemView.findViewById(R.id.textViewItemQuant);
            unidadeMedida = itemView.findViewById(R.id.textViewItemQuantMeasure);
            calorias = itemView.findViewById(R.id.textViewItemKcal);

            itemView.findViewById(R.id.imageViewButtonMore).setOnClickListener(v->{
                popup.show();
            });
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exemple_item, parent, false);
        if(!menuOpcoesHabilitado)
            ((ImageView) view.findViewById(R.id.imageViewButtonMore)).setVisibility(View.INVISIBLE);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ObjectDefault obj = (ObjectDefault) list.get(position);
        obj.setPosition(position);
        configurePopupMenu(obj);

        holder.titulo.setText(obj.getNome());
        holder.quantidade.setText(String.valueOf(obj.getQuantidade()));
        holder.unidadeMedida.setText(obj.getUnidadeMedida());
        holder.calorias.setText(String.valueOf(obj.getCalorias()));
    }

    @Override
    public int getItemCount() {
        return (list == null)? 0: list.size();
    }

    private void configurePopupMenu(ObjectDefault objectDefault){
        popup = new PopupMenu(view.getContext(), view, Gravity.RIGHT, R.attr.actionOverflowMenuStyle,0);
        popup.getMenuInflater().inflate(R.menu.overflow_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            switch (item.getTitle().toString()){
                case "Editar":
                    botaoEditar.OnClick(objectDefault);
                    break;
                case "Editar Nome":
                    botaoEditarNome.OnClick(objectDefault);
                    break;
                case "Excluir":
                    botaoExcluir.OnClick(objectDefault);
                    break;
            }
            return false;
        });
    }

}
