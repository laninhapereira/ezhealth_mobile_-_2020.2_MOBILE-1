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

import static androidx.core.content.ContextCompat.startActivity;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private Refeicao refeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

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

        Log.d("Refeicao: ", refeicao.getNome());

    }

    private void configuraPrimeiroPainel(){
        // Classe para configuração do conteúdo do painel

        new PainelInformacoes_Content(
            "Alimentos",
            getWindow().getDecorView(),
            true,
            new ExampleAdapterObjectDefault(
                true,
                refeicao.getRepAlimentos().getList(),
                nome -> { // Construção do botão de EDITAR de cada item da lista
                    Intent intent = new Intent(this, EditarAlimento_Activity.class);
                    intent.putExtra("ALIMENTO", nome);
                    startActivity(intent);
                },
                nome -> { // Construção do botão de EXCLUIR de cada item da lista

                }
            )
        );
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

}
