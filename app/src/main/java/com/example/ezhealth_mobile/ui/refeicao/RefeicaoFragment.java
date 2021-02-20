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

    private Dialog dialogAdicionar;
    private Dialog dialogEditarNome;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        dialogAdicionar = configuraPopupAdicionar();
        dialogEditarNome = configuraPopupEditarNome();

        root.findViewById(R.id.fab).setOnClickListener(v -> {
            dialogAdicionar.show();
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
                dialogEditarNome.show();
            },
            nome -> {

            }
        ));

        return root;
    }

    public Dialog configuraPopupAdicionar(){
        TextView textView;
        Dialog dialog;

        dialog = new Dialog(getActivity(), R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);
        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        textView = ((EditText)dialog.findViewById(R.id.editTextPopupNome));
        textView.setHint("Digite o nome da nova refeição");

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(getActivity(), EditarAlimento_Activity.class);
            intent.putExtra("ALIMENTO_NOVO", true);
            intent.putExtra("ALIMENTO_NOVO_NOME", textView.getText().toString());
            getActivity().startActivity(intent);
        });

        return dialog;
    }

    private void salvarNomeEditado(String nome){
        // Ainda deverá ser contruida
    }

    public Dialog configuraPopupEditarNome(){
        TextView textView;
        Dialog dialog;
        dialog = new Dialog(getActivity(), R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);

        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        textView = ((EditText)dialog.findViewById(R.id.editTextPopupNome));
        textView.setHint("Digite o nome da refeição");

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            getActivity().finish();
            salvarNomeEditado(textView.getText().toString());
            getActivity().startActivity(intent);
        });
        return dialog;
    }


}