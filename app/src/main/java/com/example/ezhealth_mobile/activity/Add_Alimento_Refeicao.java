package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.ExampleAdapter;
import com.example.ezhealth_mobile.util.Example_Item_Alimento;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ezhealth_mobile.activity.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

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
        FloatingActionButton fab = findViewById(R.id.fab);

        // tabs.getTabAt(0).setIcon(R.drawable.check);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    //Botão "check" para confirmar que o usuário já adicionou os alimentos/refeições desejados
    public void check_Alimento_refeição(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltarListaAlimentos(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //////////////////////////
    // OBS : Não mexer no fragment_add__alimento_refeicao, em construção...
    //////////////////////////


}