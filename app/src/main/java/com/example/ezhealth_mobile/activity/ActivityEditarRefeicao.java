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
import com.example.ezhealth_mobile.content.ContentFirstPainelInformacoes;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.RepositoryObjectDefault;

public class ActivityEditarRefeicao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);
        popular();
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(RepositoryObjectDefault.getTitleListItens());
        this.configuraPrimeiroPainel();
    }

    private void configuraPrimeiroPainel(){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_info, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        ((TextView) findViewById(R.id.textViewTituloPrimeiroPainel)).setText("Lista de alimentos");

        // Classe para configuração do conteúdo do painel
        new ContentFirstPainelInformacoes(
                getWindow().getDecorView(),
                ActivityEditarAlimento.class,
                true
        );
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        Intent intent = new Intent(this, ActivityHome.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        Intent intent = new Intent(this, ActivityHome.class);
        startActivity(intent);
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(this, ActivityAdicionarAlimentoRefeicao.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Ainda será implementado
    }

    private void popular(){
        RepositoryObjectDefault.setTitleListItens("Café da manhã");
        RepositoryObjectDefault.add(new ObjectDefault("Maçã", "4", null, "100"));
        RepositoryObjectDefault.add(new ObjectDefault("Uva", "3", null, "80"));
        RepositoryObjectDefault.add(new ObjectDefault("Coca-Cola", "500", "ml", "120"));
        RepositoryObjectDefault.add(new ObjectDefault("Pedaço de Pizza", "2", null, "500"));
    }

}
