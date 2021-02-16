package com.example.ezhealth_mobile.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    public PainelInformacoes_Content(String titulo, Activity activity, boolean menuOpcoesHabilitado,
                 ExampleAdapterObjectDefault exampleAdapterObjectDefault) {

        // Classe para configuração do conteúdo do painel
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) activity.findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(inflater.inflate(R.layout.content_panel_first_info, null));

        ((TextView) activity.findViewById(R.id.textViewTituloPrimeiroPainel)).setText(titulo);

        // Configura itens do menu de opções do adapter
        if(!menuOpcoesHabilitado)
            ((ImageView) activity.findViewById(R.id.imageViewButtonAdd)).setVisibility(View.INVISIBLE);

        RecyclerView recyclerView = activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(exampleAdapterObjectDefault);

    }

}
