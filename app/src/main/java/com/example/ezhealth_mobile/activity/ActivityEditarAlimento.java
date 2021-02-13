package com.example.ezhealth_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.ContentFirstPainelQuantidades;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class ActivityEditarAlimento extends AppCompatActivity {

    private ObjectDefault objectDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Alimento");
        popular();
        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_quant, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        // Classe para configuração do conteúdo do primeiro painel
        new ContentFirstPainelQuantidades(
                this,
                objectDefault.getName(),
                objectDefault.getQuantity(),
                objectDefault.getQuantityMeasure()
        );
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        Intent intent = new Intent(this, ActivityEditarRefeicao.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        Intent intent = new Intent(this, ActivityEditarRefeicao.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Ainda será implementado
    }

    private void popular(){
        objectDefault = new ObjectDefault("Maçã", "4", null, "100");
    }

}
