package com.example.ezhealth_mobile.content;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.RecyclerViewAdapter;

public class ContentFirstPainelInformacoes {

    public ContentFirstPainelInformacoes(View viewOrigin,
                                         Class classEdicaoItem, boolean menuOpcoesHabilitado) {

        if(!menuOpcoesHabilitado)
            ((ImageView)viewOrigin.findViewById(R.id.imageViewButtonAdd)).setVisibility(View.INVISIBLE);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(viewOrigin.getContext(),
                classEdicaoItem, menuOpcoesHabilitado);

        RecyclerView recyclerView = viewOrigin.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewOrigin.getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
