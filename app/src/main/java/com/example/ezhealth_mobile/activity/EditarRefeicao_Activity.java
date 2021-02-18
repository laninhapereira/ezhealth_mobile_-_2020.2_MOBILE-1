package com.example.ezhealth_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

import java.sql.Ref;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private int EDITAR_ACTIVITY = 0;
    private Refeicao refeicao;
    public String nome;

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
        Toast.makeText(this, "aaeee", Toast.LENGTH_LONG).show();
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

    private void configuraPrimeiroPainel(){
        ExampleAdapterObjectDefault exampleAdapterObjectDefault = new ExampleAdapterObjectDefault(
                true,
                refeicao.getRepAlimentos().getList(),
                nome -> { // Construção do botão de EDITAR de cada item da lista
                    Intent intent = new Intent(this, EditarAlimento_Activity.class);
                    intent.putExtra("ALIMENTO", nome);
                    startActivityForResult(intent, 0);
                },
                nome -> { // Construção do botão de EXCLUIR de cada item da lista

                }
        );
        PainelInformacoes_Content.configura("Alimentos", getWindow().getDecorView(),
                true, exampleAdapterObjectDefault);
    }

    private void configuraSegundoPainel(){
        Alimento_Repositorio repositorio = this.refeicao.getRepAlimentos();

        ((TextView) findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) findViewById(R.id.textViewPrimeiroItem)).setText("Carboidratos");
        ((TextView) findViewById(R.id.textViewPrimeiroValor)).setText(repositorio.getCarboidratosTotais());
        ((TextView) findViewById(R.id.textViewPrimeiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewSegundoItem)).setText("Proteinas");
        ((TextView) findViewById(R.id.textViewSegundoValor)).setText(repositorio.getProteinasTotais());
        ((TextView) findViewById(R.id.textViewSegundaMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewTerceiroItem)).setText("Gorduras");
        ((TextView) findViewById(R.id.textViewTerceiroValor)).setText(repositorio.getGordurasTotais());
        ((TextView) findViewById(R.id.textViewTerceiraMedida)).setText("g");

        ((TextView) findViewById(R.id.textViewValorTotalKcal)).setText(repositorio.getCaloriasTotais());
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
        startActivity(intent);
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
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
                String result = data.getStringExtra("result");
            }
        }
    }

}
