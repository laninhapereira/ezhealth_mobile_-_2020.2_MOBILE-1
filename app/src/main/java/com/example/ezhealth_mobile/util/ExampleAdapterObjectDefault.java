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


public class ExampleAdapterObjectDefault extends RecyclerView.Adapter<ExampleAdapterObjectDefault.ViewHolder>{

    private static OnClickListenerAdapter botaoEditar;
    private static OnClickListenerAdapter botaoExcluir;
    private static OnClickListenerAdapter botaoEditarNome;
    private boolean menuOpcoesHabilitado;
    private ArrayList<ObjectDefault> list;


    public ExampleAdapterObjectDefault(boolean menuOpcoesHabilitado, ArrayList<ObjectDefault> list,
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

        private PopupMenu popup;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.textViewItemTitle);
            quantidade = itemView.findViewById(R.id.textViewItemQuant);
            unidadeMedida = itemView.findViewById(R.id.textViewItemQuantMeasure);
            calorias = itemView.findViewById(R.id.textViewItemKcal);

            configurePopupMenu();

            itemView.findViewById(R.id.imageViewButtonMore).setOnClickListener(v->{
                Log.d("a", "testeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
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
                        botaoEditar.OnClick(titulo.getText().toString());
                        break;
                    case "Editar Nome":
                        botaoEditarNome.OnClick(titulo.getText().toString());
                        break;
                    case "Excluir":
                        botaoExcluir.OnClick(titulo.getText().toString());
                        break;
                }
                return false;
            });
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exemple_item, parent, false);
        if(!menuOpcoesHabilitado)
            ((ImageView) view.findViewById(R.id.imageViewButtonMore)).setVisibility(View.INVISIBLE);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ObjectDefault obj = list.get(position);

        holder.titulo.setText(obj.getNome());
        holder.quantidade.setText(obj.getQuantidade());
        holder.unidadeMedida.setText(obj.getUnidadeMedida());
        holder.calorias.setText(obj.getCalorias());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
