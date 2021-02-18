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
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;

public class EditarExercicio_Activity extends AppCompatActivity {

    private Exercicio exercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Exercício");

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();

        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        Intent intent = getIntent();
        String nome = (intent == null)? null: intent.getStringExtra("EXERCICIO");;

        exercicio = (nome == null)? null:
                (Exercicio) Exercicio_Repositorio.getInstance().getItemList(nome);

        PainelQuantidades_Content.configura(this, exercicio);
    }


    // Classe para configuração do conteúdo do segundo painel
    private void configuraSegundoPainel(){
        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Duração");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText(exercicio.getQuantidade());
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("min");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Calorias Perdidas");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText(exercicio.getCalorias());
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("kcal");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText("");
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("");

        ((TextView) findViewById(R.id.textViewTotal)).setText("");
        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText("");
        ((TextView) findViewById(R.id.textViewKcal4)).setText("");
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        finish();
    }

}
