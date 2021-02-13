package com.example.ezhealth_mobile.ui.refeicao;

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
import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.ActivityEditarRefeicao;

public class RefeicaoFragment extends Fragment {

    private RefeicaoViewModel refeicaoViewModel;
    private ViewGroup container;
    private LayoutInflater inflater;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState)
    {
        this.container = container;
        this.inflater = inflater;
        refeicaoViewModel = new ViewModelProvider(this).get(RefeicaoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        refeicaoViewModel.getText().observe( getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        return root;
    }

    public void irAdicionarAlimento(View view){
        View root = inflater.inflate(R.layout.activity_home, container, false);
        Intent intent = new Intent(root.getContext(), ActivityEditarRefeicao.class);
        startActivity(intent);
    }
}