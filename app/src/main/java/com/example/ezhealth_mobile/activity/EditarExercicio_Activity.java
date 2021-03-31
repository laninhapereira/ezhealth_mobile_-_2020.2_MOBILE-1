package com.example.ezhealth_mobile.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelQuantidades_Content;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class EditarExercicio_Activity extends AppCompatActivity {

    private Exercicio exercicio;

    private TextView textViewTituloSegundoPainel;
    private TextView textViewPrimeiroItem;
    private TextView textViewPrimeiroValor;
    private TextView textViewPrimeiraMedida;
    private TextView textViewSegundoItem;
    private TextView textViewSegundoValor;
    private TextView textViewSegundaMedida;
    private TextView textViewTerceiroItem;
    private TextView textViewTerceiroValor;
    private TextView textViewTerceiraMedida;
    private TextView textViewTotal;
    private TextView textViewValorTotalKcal;
    private TextView textViewKcal4;
    private PainelQuantidades_Content painelQuantidades_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Exercício");

        textViewTituloSegundoPainel = findViewById(R.id.textViewTituloSegundoPainel);
        textViewPrimeiroItem = findViewById(R.id.textViewPrimeiroItem);
        textViewPrimeiroValor = findViewById(R.id.textViewPrimeiroValor);
        textViewPrimeiraMedida = findViewById(R.id.textViewPrimeiraMedida);
        textViewSegundoItem = findViewById(R.id.textViewSegundoItem);
        textViewSegundoValor = findViewById(R.id.textViewSegundoValor);
        textViewSegundaMedida = findViewById(R.id.textViewSegundaMedida);
        textViewTerceiroItem = findViewById(R.id.textViewTerceiroItem);
        textViewTerceiroValor = findViewById(R.id.textViewTerceiroValor);
        textViewTerceiraMedida = findViewById(R.id.textViewTerceiraMedida);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewValorTotalKcal = findViewById(R.id.textViewValorTotalKcal);
        textViewKcal4 = findViewById(R.id.textViewKcal4);

        exercicio = getIntent().getExtras().getParcelable("EXERCICIO");
        if(exercicio == null) exercicio = new Exercicio();

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();

        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        painelQuantidades_content = new PainelQuantidades_Content(this);
        painelQuantidades_content.configurarPainel(exercicio);
    }

    // Classe para configuração do conteúdo do segundo painel
    private void configuraSegundoPainel(){
        textViewTituloSegundoPainel.setText("Informações gerais");

        textViewPrimeiroItem.setText("Duração");
        textViewPrimeiroValor.setText(String.valueOf(exercicio.getQuantidade()));
        textViewPrimeiraMedida.setText("min");

        textViewSegundoItem.setText("Calorias Perdidas");
        textViewSegundoValor.setText(String.valueOf(exercicio.getCalorias()));
        textViewSegundaMedida.setText("kcal");
        textViewTerceiroItem.setText("");

        textViewTerceiroValor.setText("");
        textViewTerceiraMedida.setText("");
        textViewTotal.setText("");

        textViewValorTotalKcal.setText("");
        textViewKcal4.setText("");
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        String quantidade = painelQuantidades_content.getQuantidade();
        exercicio.setQuantidade(Integer.parseInt(quantidade));

        Intent intent = new Intent();
        intent.putExtra("SALVO", exercicio);
        setResult(RESULT_OK, intent);
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        finish();
    }

}
