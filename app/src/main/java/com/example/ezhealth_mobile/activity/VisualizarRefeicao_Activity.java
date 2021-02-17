package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

public class VisualizarRefeicao_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);
        ((Button) findViewById(R.id.buttonCheck)).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(Refeicao_Repositorio.getTitleListItens());
        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        // Classe para configuração do conteúdo do primeiro painel
        new PainelInformacoes_Content(
                Refeicao_Repositorio.getInstance().getItemList(0).getNome(),
                getWindow().getDecorView(),
                false,
                new ExampleAdapterObjectDefault(
                    false,
                    Refeicao_Repositorio.getInstance(),
                    nome -> { // Construção do botão de EDITAR de cada item da lista

                    },
                    nome -> { // Construção do botão de EXCLUIR de cada item da lista

                    }
                )
        );
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
        intent.putExtra("FRAGMENT","refeicao");
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
        intent.putExtra("FRAGMENT","refeicao");
        startActivity(intent);
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
        intent.putExtra("FRAGMENT","refeicao");
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Ainda será implementado
    }

}
