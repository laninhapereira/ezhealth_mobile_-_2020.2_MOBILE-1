package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterExercicio;

import java.util.ArrayList;

public class AdicionarExercicio_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_exercicio);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerViewExercicios);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(new ExampleAdapterExercicio(
            nome -> { // Construção do botão de ADICIONAR de cada item da lista
                finish();
            }, // Construção do botão de EDITAR de cada item da lista
            nome -> {
                Intent intent = new Intent(this, EditarExercicio_Activity.class);
                intent.putExtra("EXERCICIO", nome);
                startActivity(intent);
            })
        );

    }

    public void voltarListaExercicios(View v){
        finish();
    }

    public void checkExercicios(View v){
        finish();
    }

}