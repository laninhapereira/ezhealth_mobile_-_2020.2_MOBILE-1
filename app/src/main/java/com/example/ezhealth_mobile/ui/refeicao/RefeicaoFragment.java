package com.example.ezhealth_mobile.ui.refeicao;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarAlimento_Activity;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.activity.PopupNome;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicaoPersonalizada;

public class RefeicaoFragment extends Fragment {

    private Dialog dialogAdicionar;
    private Dialog dialogEditarNome;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        root.findViewById(R.id.fab).setOnClickListener(v -> {
            ((EditText)dialogAdicionar.findViewById(R.id.editTextPopupNome)).setText("");
            dialogAdicionar.show();
        });

        configuraPopup();
        configuraRecycle(root);

        return root;
    }

    private void configuraPopup(){
        dialogAdicionar = PopupNome.configuraPopup(getActivity(), "refeição", nome -> {
            Intent intent = new Intent(getActivity(), EditarRefeicao_Activity.class);
            intent.putExtra("REFEICAO_NOVA", true);
            intent.putExtra("REFEICAO_NOVA_NOME", (Refeicao) nome);
            getActivity().startActivity(intent);
        });

        dialogEditarNome = PopupNome.configuraPopup(getActivity(), "refeição", nome -> {
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            getActivity().finish();
//            salvarNomeEditado(nome);
            getActivity().startActivity(intent);
        });;
    }

    private void configuraRecycle(View root){
        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewRefeicaoPersonalizada);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ExampleAdapterRefeicaoPersonalizada(
                nome -> {
                    Intent intent = new Intent(root.getRootView().getContext(), EditarRefeicao_Activity.class);
                    intent.putExtra("REFEICAO", (Refeicao) nome);
                    startActivity(intent);
                },
                nome -> {
                    ((EditText)dialogEditarNome.findViewById(R.id.editTextPopupNome)).setText("");
                    dialogEditarNome.show();
                },
                nome -> {

                }
        ));
    }

    private void salvarNomeEditado(String nome){
        // Ainda deverá ser contruida
    }


}