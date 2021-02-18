package com.example.ezhealth_mobile.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.TelaChat_Activity;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        /*perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        final TextView textView = root.findViewById(R.id.text_perfil);

        perfilViewModel.getText().observe(
            getViewLifecycleOwner(),
            new Observer<String>(){
                @Override
                public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
            }
        );*/

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Abrir tela de chat
        Intent intent = new Intent(root.getRootView().getContext(), TelaChat_Activity.class);

        root.findViewById(R.id.fabAbrirChat).setOnClickListener(v -> {
            startActivity(intent);
        });

        //Abrir tela de edição de dados cadastrais



        return root;
    }

}