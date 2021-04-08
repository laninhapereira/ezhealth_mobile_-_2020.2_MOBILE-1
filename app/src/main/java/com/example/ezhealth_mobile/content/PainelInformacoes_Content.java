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

public class PainelInformacoes_Content {

    private static LayoutInflater inflater;
    private static Context context;
    private static TextView textViewTituloPrimeiroPainel;
    private static ConstraintLayout includeFirstPanel;
    private static ImageView imageViewButtonAdd;
    private static RecyclerView recyclerView;

    public static void configura(String titulo, View view, boolean menuOpcoesHabilitado,
                                 ExampleAdapterObjectDefault exampleAdapterObjectDefault,
                                 View.OnClickListener buttonAdd) {

        context = view.getContext();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        includeFirstPanel = view.findViewById(R.id.include);
        textViewTituloPrimeiroPainel = view.findViewById(R.id.textViewTituloPrimeiroPainel);
        imageViewButtonAdd = view.findViewById(R.id.imageViewButtonAdd);
        recyclerView = view.findViewById(R.id.recyclerView);

        outrasConfiguracoes(titulo);
        configuraButaoAdicionar(menuOpcoesHabilitado, buttonAdd);
        configuraItensPanel();
        configuraRecycleView(exampleAdapterObjectDefault);
    }

    private static void configuraRecycleView(ExampleAdapterObjectDefault exampleAdapterObjectDefault){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(exampleAdapterObjectDefault);
    }

    private static void configuraItensPanel(){
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(inflater.inflate(R.layout.content_panel_first_info, null));
    }

    private static void configuraButaoAdicionar(boolean menuOpcoesHabilitado, View.OnClickListener buttonAdd){
        if(!menuOpcoesHabilitado)
            imageViewButtonAdd.setVisibility(View.INVISIBLE);
        imageViewButtonAdd.setOnClickListener(buttonAdd);
    }

    private static void outrasConfiguracoes(String titulo){
        textViewTituloPrimeiroPainel.setText("Lista de "+titulo);
    }

}
