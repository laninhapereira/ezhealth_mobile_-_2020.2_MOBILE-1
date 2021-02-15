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
import com.example.ezhealth_mobile.util.ExampleAdapterAlimento;
import com.example.ezhealth_mobile.entity.Alimento;

import java.util.ArrayList;

public class Alimento_TabFragment extends Fragment {

    private ArrayList<Alimento> listaAlimentos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_alimento_fragment, container, false);

        ExampleAdapterAlimento mAdapter = new ExampleAdapterAlimento(getContext(), listaAlimentos);

        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerViewAlimentos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Array de Alimentos

        listaAlimentos.add(new Alimento("Banana", "100", "320"));
        listaAlimentos.add(new Alimento("Caju", "100", "320"));
        listaAlimentos.add(new Alimento("Mamão", "100", "320"));
        listaAlimentos.add(new Alimento("Pera", "100", "320"));
        listaAlimentos.add(new Alimento("Morango", "100", "320"));
        listaAlimentos.add(new Alimento("Banana", "100", "320"));
        listaAlimentos.add(new Alimento("Caju", "100", "320"));
        listaAlimentos.add(new Alimento("Mamão", "100", "320"));
        listaAlimentos.add(new Alimento("Pera", "100", "320"));
        listaAlimentos.add(new Alimento("Morango", "100", "320"));

    }
}
