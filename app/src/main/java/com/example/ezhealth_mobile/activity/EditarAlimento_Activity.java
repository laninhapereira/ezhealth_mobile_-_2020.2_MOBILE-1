package com.example.ezhealth_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.content.PainelQuantidades_Content;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class EditarAlimento_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Alimento");

        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        Intent intent = getIntent();
        String nome = (intent == null)? null: intent.getStringExtra("ALIMENTO");;

        Alimento alimento = (nome==null)?
                null:
                (Alimento) new Alimento_Repositorio().getItemList(nome);

        if(alimento!=null)
            PainelQuantidades_Content.configura(this, alimento);
        else
            finish();
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        setResult(RESULT_OK, new Intent());
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        setResult(RESULT_CANCELED, new Intent());
        finish();
    }
}
