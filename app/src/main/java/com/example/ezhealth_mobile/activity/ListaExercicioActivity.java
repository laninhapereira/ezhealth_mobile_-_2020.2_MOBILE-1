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
import com.example.ezhealth_mobile.content.ContentFirstPanelInformation;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.RepositoryObjectDefault;

public class ListaExercicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);
        popular();
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Lista de Exercícios");
        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void configuraPrimeiroPainel(){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_info, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        ((TextView) findViewById(R.id.textViewTituloPrimeiroPainel)).setText("Lista de Exercícios");

        // Classe para configuração do conteúdo do primeiro painel
        new ContentFirstPanelInformation(
                this,
                EditarAlimentoActivity.class,
                true
        );
    }

    // Classe para configuração do conteúdo do segundo painel
    private void configuraSegundoPainel(){
        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Tempo");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText("5");
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("h");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Quantidade");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText("1");
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText("");
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("");

        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText("700");
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(this, EditarExercicioActivity.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Ainda será implementado
    }

    private void popular(){
        RepositoryObjectDefault.setTitleListItens("Exercicios da manhã");
        RepositoryObjectDefault.add(new ObjectDefault("Correr", "4", "Km", "400"));
        RepositoryObjectDefault.add(new ObjectDefault("Abdominal", "3", "Series", "300"));
    }


}
