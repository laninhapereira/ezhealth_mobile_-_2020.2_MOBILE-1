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

    Alimento alimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Alimento");

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void configuraPrimeiroPainel(){
        Intent intent = getIntent();
        String nome = (intent == null)? null: intent.getStringExtra("ALIMENTO");;

        alimento = (nome==null)?
                null:
                (Alimento) Alimento_Repositorio.getInstance().getItemList(nome);

        if(alimento!=null)
            PainelQuantidades_Content.configura(this, alimento);
        else
            finish();
    }

    private void configuraSegundoPainel(){

        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Carboidratos");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText(alimento.getCarboidratos());
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Proteinas");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText(alimento.getProteinas());
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("Gorduras");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText(alimento.getGorduras());
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText(alimento.getCalorias());
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        setResult(RESULT_OK, new Intent());
        String result = ((TextView) findViewById(R.id.editTextQtd)).getText().toString();
        alimento.setQuantidade(result);

        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        setResult(RESULT_CANCELED, new Intent());
        finish();
    }
}
