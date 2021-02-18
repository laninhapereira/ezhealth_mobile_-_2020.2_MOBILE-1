package com.example.ezhealth_mobile.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public interface PainelQuantidades_Content {

    static void configura(AppCompatActivity appCompatActivity, ObjectDefault objectDefault) {
        LayoutInflater inflater = (LayoutInflater)appCompatActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_quant, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) appCompatActivity.findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        view = appCompatActivity.getWindow().getDecorView();
        ((TextView)view.findViewById(R.id.textViewTituloPrimeiroPainel)).setText(objectDefault.getNome());
        ((TextView)view.findViewById(R.id.editTextQtd)).setText(objectDefault.getQuantidade());
        ((TextView)view.findViewById(R.id.textViewUniMed)).setText(objectDefault.getUnidadeMedida());
    }

}
