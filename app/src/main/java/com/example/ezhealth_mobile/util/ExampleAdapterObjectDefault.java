package com.example.ezhealth_mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class ExampleAdapterObjectDefault extends RecyclerView.Adapter<ExampleAdapterObjectDefault.ViewHolder>{

    private static final int ATUALIZAR = 1;
    private Context contextOrigin;
    private Class classEdicaoItem;
    private boolean menuOpcoesHabilitado;
    private ArrayList<ObjectDefault> list;

    public ExampleAdapterObjectDefault(Context contextOrigin, Class classEdicaoItem, boolean menuOpcoesHabilitado) {
        this.contextOrigin = contextOrigin;
        this.classEdicaoItem = classEdicaoItem;
        this.menuOpcoesHabilitado = menuOpcoesHabilitado;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView quantity;
        private TextView quantityMeasure;
        private TextView kcal;
        private Integer position;

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
                        Intent intent = new Intent(contextOrigin, classEdicaoItem);
                        intent.putExtra("POSITION", position);
                        startActivityForResult((Activity) contextOrigin, intent, ATUALIZAR, null);
                        break;
                    case "Excluir":
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
        ObjectDefault obj = (ObjectDefault) Alimento_Repositorio.getInstance().getItemList(position);

        holder.position = position;
        holder.title.setText(obj.getNome());
        holder.quantity.setText(obj.getQuantidade());
        holder.quantityMeasure.setText(obj.getUnidadeMedida());
        holder.kcal.setText(obj.getCalorias());
    }

    @Override
    public int getItemCount() {
        return Alimento_Repositorio.getInstance().getList().size();
    }

}
