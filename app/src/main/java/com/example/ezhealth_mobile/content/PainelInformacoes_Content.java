package com.example.ezhealth_mobile.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;


public interface PainelInformacoes_Content {

        static void configura(String titulo, View view, boolean menuOpcoesHabilitado,
                              ExampleAdapterObjectDefault exampleAdapterObjectDefault) {

            Context context = view.getContext();

            // Classe para configuração do conteúdo do painel
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ConstraintLayout includeFirstPanel = (ConstraintLayout) view.findViewById(R.id.include);

            ((TextView) view.findViewById(R.id.textViewTituloPrimeiroPainel)).setText("Lista de "+titulo);

            // Configura itens do menu de opções do adapter
            if(!menuOpcoesHabilitado)
                ((ImageView) view.findViewById(R.id.imageViewButtonAdd)).setVisibility(View.INVISIBLE);


            RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(exampleAdapterObjectDefault);
    }

}
