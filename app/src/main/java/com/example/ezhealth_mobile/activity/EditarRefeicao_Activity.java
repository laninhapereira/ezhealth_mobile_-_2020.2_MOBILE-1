package com.example.ezhealth_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Alimento_Repositorio;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

import static androidx.core.content.ContextCompat.startActivity;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private Intent intent;
    private String telaAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(Refeicao_Repositorio.getTitleListItens());

        this.configuraPrimeiroPainel();

        escolheTelaVolta();
    }

    private void configuraPrimeiroPainel(){
        // Classe para configuração do conteúdo do painel

        new PainelInformacoes_Content(
            Refeicao_Repositorio.getInstance().getTitleListItens(),
            getWindow().getDecorView(),
            true,
            new ExampleAdapterObjectDefault(
                true,
                Refeicao_Repositorio.getInstance(),
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
        intent.putExtra("TELA_ANTERIOR", "editarRefeicao");
        startActivity(intent);
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        intent.putExtra("ATUALIZAR", true);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        intent.putExtra("ATUALIZAR", false);
        startActivity(intent);
    }

    private void escolheTelaVolta(){
        intent = getIntent();
        telaAnterior = (intent != null)? intent.getStringExtra("TELA_ANTERIOR") : "default";
        telaAnterior = (telaAnterior!=null)? telaAnterior :"default";
        switch(telaAnterior){
            case "adicionarAlimento":
                intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                intent.putExtra("FRAGMENT", "alimento");
                break;
            case "adicionarRefeicao":
                intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                intent.putExtra("FRAGMENT", "refeicao");
                break;
            case "homeRefeicao":
                intent = new Intent(this, Home_Activity.class);
                intent.putExtra("FRAGMENT", "refeicao");
                break;
            default:
                intent = new Intent(this, Home_Activity.class);
        }
    }
}
