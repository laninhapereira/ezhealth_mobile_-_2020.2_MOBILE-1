package com.example.ezhealth_mobile.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class PainelQuantidades_Content {

    private View view;
    private AppCompatActivity appCompatActivity;
    private TextView textViewTituloPrimeiroPainel;
    private TextView editTextQtd;
    private TextView textViewUniMed;

    public PainelQuantidades_Content(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;

        LayoutInflater inflater = (LayoutInflater) appCompatActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.view = inflater.inflate(R.layout.content_panel_first_quant, null);

        this.textViewTituloPrimeiroPainel = view.findViewById(R.id.textViewTituloPrimeiroPainel);
        this.editTextQtd = view.findViewById(R.id.editTextQtd);
        this.textViewUniMed = view.findViewById(R.id.textViewUniMed);
    }

     public void configurarPainel(ObjectDefault objectDefault) {
        ConstraintLayout includeFirstPanel = (ConstraintLayout) appCompatActivity.findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

//        view = appCompatActivity.getWindow().getDecorView();
        textViewTituloPrimeiroPainel.setText(objectDefault.getNome());
        editTextQtd.setText(String.valueOf(objectDefault.getQuantidade()));
        textViewUniMed.setText(objectDefault.getUnidadeMedida());
    }

    public String getQuantidade(){
        return editTextQtd.getText().toString();
    }

}
