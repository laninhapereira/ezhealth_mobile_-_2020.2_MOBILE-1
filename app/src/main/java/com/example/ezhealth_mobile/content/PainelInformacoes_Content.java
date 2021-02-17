package com.example.ezhealth_mobile.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarAlimento_Activity;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.ObjectDefault_Repositorio;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;
import com.example.ezhealth_mobile.util.OnClickListenerAdapter;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;

public class PainelInformacoes_Content {

    public PainelInformacoes_Content(String titulo, View view, boolean menuOpcoesHabilitado,
                 ExampleAdapterObjectDefault exampleAdapterObjectDefault) {

        Context context = view.getContext();

        // Classe para configuração do conteúdo do painel
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) view.findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(inflater.inflate(R.layout.content_panel_first_info, null));

        ((TextView) view.findViewById(R.id.textViewTituloPrimeiroPainel)).setText(titulo);

        // Configura itens do menu de opções do adapter
        if(!menuOpcoesHabilitado)
            ((ImageView) view.findViewById(R.id.imageViewButtonAdd)).setVisibility(View.INVISIBLE);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(exampleAdapterObjectDefault);

    }

}
