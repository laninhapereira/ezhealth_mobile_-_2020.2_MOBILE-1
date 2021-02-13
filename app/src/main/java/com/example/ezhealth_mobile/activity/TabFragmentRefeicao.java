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
import com.example.ezhealth_mobile.entity.ExampleItemRefeicao;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicao;

import java.util.ArrayList;

public class TabFragmentRefeicao extends Fragment {

    View v;
    private RecyclerView mRecyclerView;
    private ExampleAdapterRefeicao mAdapter;
    //private LinearLayoutManager mLayoutManager;
    ArrayList<ExampleItemRefeicao> listaRefeicoes = new ArrayList<>();


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

        listaRefeicoes.add(new ExampleItemRefeicao("Meu café da manhã 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu almoço 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu jantar 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu lanche da tarde 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu café da manhã 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu almoço 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu jantar 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu lanche da tarde 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu café da manhã 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu almoço 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu jantar 1", "100", "320"));
        listaRefeicoes.add(new ExampleItemRefeicao("Meu lanche da tarde 1", "100", "320"));

        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);
        //mAdapter = new ExampleAdapter(listaAlimentos);


        //mRecyclerView.setAdapter(mAdapter);

    }
}
