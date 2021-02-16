package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private Intent intent;
    private String telaAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(Refeicao_Repositorio.getTitleListItens());

        this.configuraPrimeiroPainel();

        intent = getIntent();
        telaAnterior = (intent != null)? intent.getStringExtra("TELA_ANTERIOR") : "default";
        telaAnterior = (telaAnterior!=null)? telaAnterior :"default";
    }

    private void configuraPrimeiroPainel(){
        // Classe para configuração do conteúdo do painel
        new PainelInformacoes_Content(
                Refeicao_Repositorio.getInstance(),
                getWindow().getDecorView(),
                EditarAlimento_Activity.class,
                true
        );
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        switch(telaAnterior){
            case "adicionarAlimentosRefeicao":
                intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                intent.putExtra("FRAGMENT", "refeicao");
                break;
            default:
                intent = new Intent(this, Home_Activity.class);
        }
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        switch(telaAnterior){
            case "adicionarAlimentosRefeicao":
                intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                intent.putExtra("FRAGMENT", "refeicao");
                break;
            default:
                intent = new Intent(this, Home_Activity.class);
        }
        startActivity(intent);
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
        startActivity(intent);
    }


}
