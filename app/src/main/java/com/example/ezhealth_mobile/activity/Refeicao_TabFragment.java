package com.example.ezhealth_mobile.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.ItemRefeicao_Example;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicao;

import java.util.ArrayList;

public class Refeicao_TabFragment extends Fragment {

    View v;
    private RecyclerView mRecyclerView;
    private ExampleAdapterRefeicao mAdapter;
    //private LinearLayoutManager mLayoutManager;
    ArrayList<ItemRefeicao_Example> listaRefeicoes = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_refeicao_fragment, container, false);
        mRecyclerView = v.findViewById(R.id.recyclerViewRefeicoes);
        mAdapter = new ExampleAdapterRefeicao(getContext(), listaRefeicoes);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return v;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Array de Alimentos

        listaRefeicoes.add(new ItemRefeicao_Example("Meu café da manhã 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu almoço 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu jantar 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu lanche da tarde 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu café da manhã 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu almoço 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu jantar 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu lanche da tarde 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu café da manhã 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu almoço 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu jantar 1", "100", "320"));
        listaRefeicoes.add(new ItemRefeicao_Example("Meu lanche da tarde 1", "100", "320"));

        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);
        //mAdapter = new ExampleAdapter(listaAlimentos);


        //mRecyclerView.setAdapter(mAdapter);

    }
}
