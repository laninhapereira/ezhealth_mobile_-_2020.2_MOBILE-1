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
import com.example.ezhealth_mobile.util.ExampleAdapterRelatorio30dias;

public class TabFragment_30diasRelatorio extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_30dias_relatorio_fragment, container, false);

        RecyclerView mRecyclerView = v.findViewById(R.id.recyclerViewRelatorio30dias);
        ExampleAdapterRelatorio30dias mAdapter = new ExampleAdapterRelatorio30dias(getContext());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        return v;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Array de Relatório

        //ArrayList<?> listaRelatorio = new ArrayList<>();

        //listaRelatorio.add(new Example_Item_Refeicao("Meu café da manhã 1", "100", "320"));
        //listaRefeicoes.add(new Example_Item_Refeicao("Meu almoço 1", "100", "320"));


        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);
        //mAdapter = new ExampleAdapter(listaAlimentos);


        //mRecyclerView.setAdapter(mAdapter);

    }

}
