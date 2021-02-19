package com.example.ezhealth_mobile.ui.refeicao;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarAlimento_Activity;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.activity.PopupNome;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicaoPersonalizada;

public class RefeicaoFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        root.findViewById(R.id.fab).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PopupNome.class);
            intent.putExtra("REFEICAO", "Sem nome");
            startActivity(intent);
        });

        RecyclerView recyclerView = root.findViewById(R.id.recyclerViewRefeicaoPersonalizada);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ExampleAdapterRefeicaoPersonalizada(
            nome -> {
                Intent intent = new Intent(root.getRootView().getContext(), EditarRefeicao_Activity.class);
                intent.putExtra("REFEICAO", nome);
                startActivity(intent);
            },
            nome -> {

            }
        ));

        return root;
    }
/*
    private void openPopUp(){
        Dialog dialog = new Dialog(this, R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);
        dialog.show();

        String nome = ((EditText)dialog.findViewById(R.id.editTextPopupNome)).getText().toString();

        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(getActivity(), EditarAlimento_Activity.class);
            startActivity(intent);
        });
    }*/

}