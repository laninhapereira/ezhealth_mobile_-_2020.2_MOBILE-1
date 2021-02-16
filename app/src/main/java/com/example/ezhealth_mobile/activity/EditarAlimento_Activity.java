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
import com.example.ezhealth_mobile.content.PainelQuantidades_Content;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class EditarAlimento_Activity extends AppCompatActivity {

    private Intent intent;
    private String telaAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Alimento");

        this.configuraPrimeiroPainel();


        intent = getIntent();
        telaAnterior = (intent != null)? intent.getStringExtra("TELA_ANTERIOR") : "default";
        telaAnterior = (telaAnterior!=null)? telaAnterior :"default";
    }

    private void configuraPrimeiroPainel(){
        new PainelQuantidades_Content(this, (ObjectDefault) Alimento_Repositorio.getInstance().getItemList(0));
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        switch(telaAnterior){
            case "adicionarRefeicao":
                intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                break;
            default:
                intent = new Intent(this, EditarRefeicao_Activity.class);
                intent.putExtra("ATUALIZAR", true);
        }
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        switch(telaAnterior){
            case "adicionarRefeicao":
                intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                break;
            default:
                intent = new Intent(this, EditarRefeicao_Activity.class);
                intent.putExtra("ATUALIZAR", false);
        }
        startActivity(intent);
    }

}
