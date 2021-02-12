package com.example.ezhealth_mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.RepositoryObjectDefault;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{

    private static final int ATUALIZAR = 1;
    private Context contextOrigin;
    private Class classEdicaoItem;
    private boolean menuOpcoesHabilitado;

    public RecyclerViewAdapter(Context contextOrigin,  Class classEdicaoItem, boolean menuOpcoesHabilitado) {
        this.contextOrigin = contextOrigin;
        this.classEdicaoItem = classEdicaoItem;
        this.menuOpcoesHabilitado = menuOpcoesHabilitado;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exemple_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        if(!menuOpcoesHabilitado)
            ((ImageView) view.findViewById(R.id.imageViewButtonMore)).setVisibility(View.INVISIBLE);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ObjectDefault obj = RepositoryObjectDefault.getItemList(position);
        holder.setObj(obj);
        holder.setPosition(position);
        holder.setTitle(obj.getName());
        holder.setQuantity(obj.getQuantity());
        holder.setQuantityMeasure(obj.getQuantityMeasure());
        holder.setKcal(obj.getKcal());

        holder.setOnMenuItemClickListener(item -> {
            if(item.getTitle().equals("Editar")) {
                Intent intent = new Intent(contextOrigin, classEdicaoItem);
                intent.putExtra("POSITION", position);
                startActivityForResult((Activity) contextOrigin, intent, ATUALIZAR, null);
            }else if(item.getTitle().equals("Excluir")){

            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return RepositoryObjectDefault.getList().size();
    }

}
