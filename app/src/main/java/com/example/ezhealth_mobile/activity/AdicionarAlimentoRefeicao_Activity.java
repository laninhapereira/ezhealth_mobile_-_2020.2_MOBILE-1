package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class AdicionarAlimentoRefeicao_Activity extends AppCompatActivity {

    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_alimento_refeicao);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        escolheFragmentInicial();
    }

    private void escolheFragmentInicial(){
        if(getIntent().getStringExtra("FRAGMENT") == null)
            return;
        switch ( getIntent().getStringExtra("FRAGMENT") ){
            case "alimento":
                tabs.getTabAt(0).select();
                break;
            case "refeicao":
                tabs.getTabAt(1).select();
                break;
            default:
                tabs.getTabAt(0).select();
        }
    }


    //Botão "check" para confirmar que o usuário já adicionou os alimentos/refeições desejados
    public void checkAlimentoRefeição(View v){
        Intent intent = new Intent(this, EditarRefeicao_Activity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltarListaAlimentos(View v){
        Intent intent = new Intent(this, EditarRefeicao_Activity.class);
        startActivity(intent);
    }

}