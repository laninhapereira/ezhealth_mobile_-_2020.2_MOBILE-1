package com.example.ezhealth_mobile.util;


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
import com.example.ezhealth_mobile.entity.ObjectDefault_Repositorio;


public class ExampleAdapterObjectDefault extends RecyclerView.Adapter<ExampleAdapterObjectDefault.ViewHolder>{

    private static OnClickListenerAdapter botaoEditar;
    private static OnClickListenerAdapter botaoExcluir;
    private boolean menuOpcoesHabilitado;
    private ObjectDefault_Repositorio repositorio;

    public ExampleAdapterObjectDefault(boolean menuOpcoesHabilitado, ObjectDefault_Repositorio repositorio,
                                       OnClickListenerAdapter botaoEditar, OnClickListenerAdapter botaoExcluir){
        this.menuOpcoesHabilitado = menuOpcoesHabilitado;
        this.repositorio = repositorio;
        this.botaoExcluir = botaoExcluir;
        this.botaoEditar = botaoEditar;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView quantity;
        private TextView quantityMeasure;
        private TextView kcal;

        private PopupMenu popup;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.textViewItemTitle);
            quantity = itemView.findViewById(R.id.textViewItemQuant);
            quantityMeasure = itemView.findViewById(R.id.textViewItemQuantMeasure);
            kcal = itemView.findViewById(R.id.textViewItemKcal);

            configurePopupMenu();

            itemView.findViewById(R.id.imageViewButtonMore).setOnClickListener(v->{
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
                        botaoEditar.OnClick(title.getText().toString());
                        break;
                    case "Excluir":
                        botaoExcluir.OnClick(title.getText().toString());
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
        ObjectDefault obj = (ObjectDefault) repositorio.getList().get(position);

        holder.title.setText(obj.getNome());
        holder.quantity.setText(obj.getQuantidade());
        holder.quantityMeasure.setText(obj.getUnidadeMedida());
        holder.kcal.setText(obj.getCalorias());
    }

    @Override
    public int getItemCount() {
        return repositorio.getList().size();
    }

}
