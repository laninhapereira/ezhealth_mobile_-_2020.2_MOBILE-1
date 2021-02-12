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
import com.example.ezhealth_mobile.util.ExampleAdapter;
import com.example.ezhealth_mobile.entity.Example_Item_Alimento;

import java.util.ArrayList;

public class TabAlimento_Fragment extends Fragment {

    View v;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    //private LinearLayoutManager mLayoutManager;
    ArrayList<Example_Item_Alimento> listaAlimentos = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_alimento_fragment, container, false);
        mRecyclerView = v.findViewById(R.id.recyclerViewAlimentos);
        mAdapter = new ExampleAdapter(getContext(), listaAlimentos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return v;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Array de Alimentos

        listaAlimentos.add(new Example_Item_Alimento("Banana", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Caju", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Mamão", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Pera", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Morango", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Banana", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Caju", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Mamão", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Pera", "100", "320"));
        listaAlimentos.add(new Example_Item_Alimento("Morango", "100", "320"));

        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);
        //mAdapter = new ExampleAdapter(listaAlimentos);


        //mRecyclerView.setAdapter(mAdapter);

    }
}
