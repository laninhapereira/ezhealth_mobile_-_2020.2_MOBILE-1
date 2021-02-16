package com.example.ezhealth_mobile.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelQuantidades_Content;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class EditarExercicio_Activity extends AppCompatActivity {

    private Intent intent;
    private String telaAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Exercício");

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();

        intent = getIntent();
        telaAnterior = (intent != null)? intent.getStringExtra("TELA_ANTERIOR") : "default";
        telaAnterior = (telaAnterior!=null)? telaAnterior :"default";
    }

    private void configuraPrimeiroPainel(){
        new PainelQuantidades_Content(this, (ObjectDefault) Exercicio_Repositorio.getInstance().getItemList(0));
    }

    // Classe para configuração do conteúdo do segundo painel
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

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        intent.putExtra("ATUALIZAR", true);
        escolheTelaVolta();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    @SuppressLint("ResourceType")
    public void voltar(View v){
        intent.putExtra("ATUALIZAR", false);
        escolheTelaVolta();
    }

    private void escolheTelaVolta(){
        switch(telaAnterior){
            case "adicionarExercicio":
                intent = new Intent(this, AdicionarExercicio_Activity.class);
                break;
            default:
                intent = new Intent(this, Home_Activity.class);
                intent.putExtra("FRAGMENT", "exercicio");
        }
        startActivity(intent);
    }

}
