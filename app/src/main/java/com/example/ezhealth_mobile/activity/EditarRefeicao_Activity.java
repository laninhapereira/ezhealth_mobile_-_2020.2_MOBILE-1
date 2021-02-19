package com.example.ezhealth_mobile.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private int EDITAR_ACTIVITY = 0;
    public Refeicao refeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);
    }

    @Override
    public void onResume(){ // escreva esse método na act1
        super.onResume();

        procurarRefeicao();
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(refeicao.getNome());

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void procurarRefeicao(){
        Intent intent = getIntent();
        String nome = (intent == null)? null : getIntent().getStringExtra("REFEICAO");

        if(nome == null) {
            Toast.makeText(this, "Refeição não encontrada", Toast.LENGTH_LONG).show();
            return;
        }
        refeicao = (Refeicao) Refeicao_Repositorio.getInstance().getItemList(nome);
        if(refeicao == null) {
            Toast.makeText(this, "Refeição não encontrada", Toast.LENGTH_LONG).show();
            return;
        }
        Log.d("Refeicao: ", refeicao.getNome());

    }

    @SuppressLint("WrongViewCast")
    private void configuraPrimeiroPainel(){
        ExampleAdapterObjectDefault exampleAdapterObjectDefault = new ExampleAdapterObjectDefault(
                true,
                refeicao.getRepAlimentos().getList(),
                nome -> { // Construção do botão de EDITAR de cada item da lista
                    Intent intent = new Intent(this, EditarAlimento_Activity.class);
                    intent.putExtra("REFEICAO", refeicao.getNome());
                    intent.putExtra("ALIMENTO", nome);
                    this.startActivityForResult(intent, 0);
                },
                nome -> { // Construção do botão de EXCLUIR de cada item da lista

                }
        );
        PainelInformacoes_Content.configura("Alimentos", getWindow().getDecorView(),
                true, exampleAdapterObjectDefault);

        ((ImageView) findViewById(R.id.imageViewButtonAdd)).setOnClickListener(
                v -> {
                    Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                    startActivityForResult(intent, EDITAR_ACTIVITY);
                }
        );
    }

    private void configuraSegundoPainel(){

        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Carboidratos");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText(refeicao.getCarboidratosTotais());
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Proteinas");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText(refeicao.getProteinasTotais());
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("Gorduras");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText(refeicao.getGordurasTotais());
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText(refeicao.getCaloriasTotais());
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        setResult(RESULT_OK);
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDITAR_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                String nome = data.getStringExtra("ALIMENTO");
                String quantidade = data.getStringExtra("QUANTIDADE");

                refeicao.getRepAlimentos().getItemList(nome).setQuantidade(quantidade);
                Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
