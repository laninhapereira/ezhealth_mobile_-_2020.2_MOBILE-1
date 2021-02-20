package com.example.ezhealth_mobile.ui.refeicao;

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

    private Dialog dialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        configuraPopup();

        root.findViewById(R.id.fab).setOnClickListener(v -> {
            dialog.show();
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

    private void configuraPopup(){
        dialog = new Dialog(getActivity(), R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);


        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(getActivity(), EditarAlimento_Activity.class);
            intent.putExtra("ALIMENTO_NOVO", true);
            String nome = ((EditText)dialog.findViewById(R.id.editTextPopupNome)).getText().toString();
            intent.putExtra("ALIMENTO_NOVO_NOME", nome);
            startActivity(intent);
        });

    }

}