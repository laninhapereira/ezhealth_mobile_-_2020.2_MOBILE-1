package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

public class VisualizarRefeicao_Activity extends AppCompatActivity {

    private Refeicao refeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);
        ((Button) findViewById(R.id.buttonCheck)).setVisibility(View.INVISIBLE);

        procurarRefeicao();
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(refeicao.getNome());

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void procurarRefeicao(){
        refeicao = getIntent().getExtras().getParcelable("REFEICAO");
    }

    private void configuraPrimeiroPainel(){
        ExampleAdapterObjectDefault exampleAdapterObjectDefault = new ExampleAdapterObjectDefault(
                false,
                refeicao.getListAlimentos(),
                nome -> { // Construção do botão de EDITAR de cada item da lista
                },
                nome -> { // Construção do botão de EDITAR NOME de cada item da lista

                },
                nome -> { // Construção do botão de EXCLUIR de cada item da lista
                }
        );

        PainelInformacoes_Content.configura("Alimentos", getWindow().getDecorView(),
                false, exampleAdapterObjectDefault, null);
    }

    private void configuraSegundoPainel(){

        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Carboidratos");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText(refeicao.getCarboidratos());
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Proteinas");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText(refeicao.getProteinas());
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("Gorduras");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText(refeicao.getGorduras());
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText(refeicao.getCalorias());
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        finish();
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        finish();
    }

}
