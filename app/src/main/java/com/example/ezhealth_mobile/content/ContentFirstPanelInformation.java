package com.example.ezhealth_mobile.content;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.RecyclerViewAdapter;

public class ContentFirstPanelInformation {

    public ContentFirstPanelInformation(AppCompatActivity appCompatActivity,
                                        Class classEdicaoItem, boolean menuOpcoesHabilitado) {
        View view = appCompatActivity.getWindow().getDecorView();

        if(!menuOpcoesHabilitado)
            ((ImageView)view.findViewById(R.id.imageViewButtonAdd)).setVisibility(View.INVISIBLE);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(appCompatActivity,
                classEdicaoItem, menuOpcoesHabilitado);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
