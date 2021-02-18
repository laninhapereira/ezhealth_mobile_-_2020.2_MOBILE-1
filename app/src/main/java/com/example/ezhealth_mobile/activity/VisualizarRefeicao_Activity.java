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
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
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
    }

    private void procurarRefeicao(){
        Intent intent = getIntent();
        String nome = (intent == null)? null : getIntent().getStringExtra("REFEICAO");

        if(nome == null) {
            Toast.makeText(this, "Refeição não encontrada", Toast.LENGTH_LONG);
            return;
        }

        refeicao = (Refeicao) Refeicao_Repositorio.getInstance().getItemList(nome);

        if(refeicao == null) {
            Toast.makeText(this, "Refeição não encontrada", Toast.LENGTH_LONG);
            return;
        }
    }

    private void configuraPrimeiroPainel(){
        ExampleAdapterObjectDefault exampleAdapterObjectDefault = new ExampleAdapterObjectDefault(
                false,
                refeicao.getRepAlimentos().getList(),
                nome -> { // Construção do botão de EDITAR de cada item da lista
                },
                nome -> { // Construção do botão de EXCLUIR de cada item da lista
                }
        );

        PainelInformacoes_Content.configura("Lista de alimentos", getWindow().getDecorView(),
                false, exampleAdapterObjectDefault);
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
