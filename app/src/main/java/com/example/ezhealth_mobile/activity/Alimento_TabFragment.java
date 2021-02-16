package com.example.ezhealth_mobile.activity;

import android.content.Intent;
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

public class Alimento_TabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_alimento_fragment, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerViewAlimentos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(new ExampleAdapterAlimento(
            nome -> { // Construção do botão de ADICIONAR de cada item da lista
                Intent intent = new Intent(getContext(), EditarRefeicao_Activity.class);
                intent.putExtra("ALIMENTO", nome);
                startActivity(intent);
            }, // Construção do botão de EDITAR de cada item da lista
            nome -> {
                Intent intent = new Intent(getContext(), EditarAlimento_Activity.class);
                intent.putExtra("TELA_ANTERIOR", "adicionarAlimento");
                intent.putExtra("ALIMENTO", nome);
                startActivity(intent);
            })
        );

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
