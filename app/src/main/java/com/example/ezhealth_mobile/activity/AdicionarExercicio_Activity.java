package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ItemExercicio_Example;
import com.example.ezhealth_mobile.util.ExampleAdapterExercicio;

import java.util.ArrayList;

public class AdicionarExercicio_Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapterExercicio mAdapter;
    private LinearLayoutManager mLayoutManager;
    ArrayList<ItemExercicio_Example> listaExercicios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_exercicio);

        listaExercicios.add(new ItemExercicio_Example("Correr", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Dançar", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Andar de Bicicleta", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Nadar", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Correr", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Dançar", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Andar de Bicicleta", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Nadar", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Correr", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Dançar", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Andar de Bicicleta", "30", "200"));
        listaExercicios.add(new ItemExercicio_Example("Nadar", "30", "200"));


        mRecyclerView = findViewById(R.id.recyclerViewExercicios);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapterExercicio(listaExercicios);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void editarExercicio(View v){
        Intent intent = new Intent(this, EditarExercicio_Activity.class);
        intent.putExtra("ANTERIOR", "adicionarExercicio");
        startActivity(intent);
    }

    public void adicionarExercicio(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        intent.putExtra("FRAGMENT", "exercicio");
        startActivity(intent);
    }

    public void voltarListaExercicios(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        intent.putExtra("FRAGMENT", "exercicio");
        startActivity(intent);
    }

    public void checkExercicios(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        intent.putExtra("FRAGMENT", "exercicio");
        startActivity(intent);
    }

}