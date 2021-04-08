package com.example.ezhealth_mobile.util;

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

public class ExampleAdapterRefeicaoPersonalizada extends RecyclerView.Adapter<ExampleAdapterRefeicaoPersonalizada.ExampleViewHolder> {

    private static OnClickListenerAdapter botaoEditar;
    private static OnClickListenerAdapter botaoExcluir;
    private static OnClickListenerAdapter botaoEditarNome;
    private PopupMenu popup;
    private View view;

    public ExampleAdapterRefeicaoPersonalizada(OnClickListenerAdapter botaoEditar, OnClickListenerAdapter botaoEditarNome, OnClickListenerAdapter botaoExcluir){
        this.botaoEditar = botaoEditar;
        this.botaoExcluir = botaoExcluir;
        this.botaoEditarNome = botaoEditarNome;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textRefeicaoPersonalizada;
        private TextView textCaloriasPersonalizada;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            textRefeicaoPersonalizada = itemView.findViewById(R.id.TextViewRefeicaoPersonalizada);
            textCaloriasPersonalizada = itemView.findViewById(R.id.TextViewCaloriasRefeicaoPersonalizada);

            itemView.findViewById(R.id.imageViewButtonMoreRefeicaoPersonalizada).setOnClickListener(v->{
                popup.show();
            });
        }

    }
    

    @NonNull
    @Override
    public ExampleAdapterRefeicaoPersonalizada.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_refeicao_personalizada, parent, false);
        return new ExampleAdapterRefeicaoPersonalizada.ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
//        Refeicao itemAtual = (Refeicao) Refeicao_Repositorio.getInstance().getListPersonalizada().get(position);
//        configurePopupMenu(itemAtual);
//
//        holder.textRefeicaoPersonalizada.setText(itemAtual.getNome());
//        holder.textCaloriasPersonalizada.setText(String.valueOf(itemAtual.getCalorias()));
    }


    @Override
    public int getItemCount() {
        return 0;
//        return Refeicao_Repositorio.getInstance().getListPersonalizada().size();
    }

    private void configurePopupMenu(Refeicao object){
        popup = new PopupMenu(view.getContext(), view, Gravity.RIGHT, R.attr.actionOverflowMenuStyle,0);
        popup.getMenuInflater().inflate(R.menu.overflow_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            switch (item.getTitle().toString()){
                case "Editar":
                    botaoEditar.OnClick(object);
                    break;
                case "Editar Nome":
                    botaoEditarNome.OnClick(object);
                    break;
                case "Excluir":
                    botaoExcluir.OnClick(object);
                    break;
            }
            return false;
        });
    }

}
