package com.example.ezhealth_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.ContentFirstPanelQuantity;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class EditarExercicioActivity extends AppCompatActivity {

    private ObjectDefault objectDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Exercício");
        popular();
        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void configuraPrimeiroPainel(){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_quant, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        // Classe para configuração do conteúdo do painel
        new ContentFirstPanelQuantity(
                this,
                objectDefault.getName(),
                objectDefault.getQuantity(),
                objectDefault.getQuantityMeasure()
        );
    }

    private void configuraSegundoPainel(){
        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Tempo");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText("5");
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("h");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Gorduras");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText("300");
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("Kcal");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText("");
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("");

        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText("700");
    }

    //Botão "check" para confirmar que o usuário já adicionou os alimentos/refeições desejados
    public void checkAlimentoRefeição(View v){
        Intent intent = new Intent(this, ListaExercicioActivity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltarListaAlimentos(View v){
        Intent intent = new Intent(this, ListaExercicioActivity.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("asdasd", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: ");
    }

    private void popular(){
        objectDefault = new ObjectDefault("Correr", "4", "Km", "400");
    }

}
