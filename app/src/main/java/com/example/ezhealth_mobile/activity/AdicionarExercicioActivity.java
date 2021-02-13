package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Example_Item_Exercicio;
import com.example.ezhealth_mobile.util.ExampleAdapterExercicio;

import java.util.ArrayList;

public class AdicionarExercicioActivity extends AppCompatActivity {

    View v;
    private RecyclerView mRecyclerView;
    private ExampleAdapterExercicio mAdapter;
    private LinearLayoutManager mLayoutManager;
    ArrayList<Example_Item_Exercicio> listaExercicios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_exercicio);

        listaExercicios.add(new Example_Item_Exercicio("Correr", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Dançar", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Andar de Bicicleta", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Nadar", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Correr", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Dançar", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Andar de Bicicleta", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Nadar", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Correr", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Dançar", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Andar de Bicicleta", "30", "200"));
        listaExercicios.add(new Example_Item_Exercicio("Nadar", "30", "200"));


        mRecyclerView = findViewById(R.id.recyclerViewExercicios);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapterExercicio(listaExercicios);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void editarExercicio(View v){
        Intent intent = new Intent(this, EditarExercicioActivity.class);
        startActivity(intent);
    }

    public void adicionarExercicio(View v){
        Intent intent = new Intent(this, ListaExercicioActivity.class);
        startActivity(intent);
    }

    public void voltarListaExercicios(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void check_Exercicios(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}