package com.example.ezhealth_mobile.ui.refeicao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicaoPersonalizada;

public class RefeicaoFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        Intent intent = new Intent(root.getRootView().getContext(), EditarRefeicao_Activity.class);
        intent.putExtra("TELA_ANTERIOR", "homeRefeicao");

        root.findViewById(R.id.fab).setOnClickListener(v -> {
            startActivity(intent);
        });

        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewRefeicaoPersonalizada);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ExampleAdapterRefeicaoPersonalizada(intent));

        return root;
    }

}