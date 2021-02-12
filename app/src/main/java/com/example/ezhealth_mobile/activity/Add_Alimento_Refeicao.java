package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Add_Alimento_Refeicao extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__alimento__refeicao);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // tabs.getTabAt(0).setIcon(R.drawable.check);
    }

    //Botão "check" para confirmar que o usuário já adicionou os alimentos/refeições desejados
    public void check_Alimento_refeição(View v){
        Intent intent = new Intent(this, EditarRefeicaoActivity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltarListaAlimentos(View v){
        Intent intent = new Intent(this, EditarRefeicaoActivity.class);
        startActivity(intent);
    }


}