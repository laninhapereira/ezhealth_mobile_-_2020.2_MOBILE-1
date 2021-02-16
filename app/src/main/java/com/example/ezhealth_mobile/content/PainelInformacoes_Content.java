package com.example.ezhealth_mobile.content;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.ObjectDefault_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

import java.util.ArrayList;

public class PainelInformacoes_Content {

    public PainelInformacoes_Content(ObjectDefault_Repositorio rep, View viewroot,
                                     Class classEdicaoItem, boolean menuOpcoesHabilitado) {


        LayoutInflater inflater = (LayoutInflater)viewroot.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_info, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) viewroot.findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        ((TextView) viewroot.findViewById(R.id.textViewTituloPrimeiroPainel)).setText(rep.getTitleListItens());

        if(!menuOpcoesHabilitado)
            ((ImageView)viewroot.findViewById(R.id.imageViewButtonAdd)).setVisibility(View.INVISIBLE);

        ExampleAdapterObjectDefault adapter = new ExampleAdapterObjectDefault(
                viewroot.getContext(), classEdicaoItem, menuOpcoesHabilitado);

        RecyclerView recyclerView = viewroot.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewroot.getContext()));
        recyclerView.setAdapter(adapter);
    }

}
