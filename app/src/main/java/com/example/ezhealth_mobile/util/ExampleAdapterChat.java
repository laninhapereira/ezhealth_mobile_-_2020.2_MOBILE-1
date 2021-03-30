package com.example.ezhealth_mobile.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;

public class ExampleAdapterChat extends RecyclerView.Adapter<ExampleAdapterChat.ExampleViewHolder> {


    private static OnClickListenerAdapter botaoVisualizar;

    public ExampleAdapterChat(OnClickListenerAdapter botaoVisualizar){
        this.botaoVisualizar = botaoVisualizar;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textUser;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textUser = itemView.findViewById(R.id.textViewChat);

            itemView.findViewById(R.id.imageViewButtonChat).setOnClickListener(v -> {
                botaoVisualizar.OnClick(textUser.getText().toString());
            });

            }

    }

    @NonNull
    @Override
    public ExampleAdapterChat.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_chat, parent, false);

        ExampleAdapterChat.ExampleViewHolder example = new ExampleAdapterChat.ExampleViewHolder(v);

        return example;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapterChat.ExampleViewHolder holder, int position) {
        holder.textUser.setText("Usuário X");
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
