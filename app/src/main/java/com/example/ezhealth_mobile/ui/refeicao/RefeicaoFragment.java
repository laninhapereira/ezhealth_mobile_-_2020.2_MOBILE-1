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
import com.example.ezhealth_mobile.activity.Home_Activity;
import com.example.ezhealth_mobile.activity.PopupNome;
import com.example.ezhealth_mobile.activity.TelaCadastro8_Activity;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.util.ExampleAdapterRefeicaoPersonalizada;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;

public class RefeicaoFragment extends Fragment {

    private Dialog dialogAdicionar;
    private Dialog dialogEditarNome;
    private FloatingActionButton fabButtonAdicionar;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_refeicao, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewRefeicaoPersonalizada);
        fabButtonAdicionar = root.findViewById(R.id.fab);

        configurarFab();
        configuraPopupAdicionar();
        configuraPopupEditarNome();
        configuraRecycle(root);

        return root;
    }

    private void configurarFab(){
        fabButtonAdicionar.setOnClickListener(v -> {
            ((EditText)dialogAdicionar.findViewById(R.id.editTextPopupNome)).setText("");
            dialogAdicionar.show();
        });
    }

    private void configuraPopupAdicionar(){
        dialogAdicionar = PopupNome.configuraPopup(getActivity(), "refeição", nome -> {
            Refeicao refeicao = new Refeicao();
            refeicao.setNome(nome);
            refeicao.setData(new Date());
            refeicao.setDiaria(false);
            refeicao.setListAlimentos(new ArrayList<>());

            Intent intent = new Intent(getActivity(), EditarRefeicao_Activity.class);
            intent.putExtra("REFEICAO", refeicao);
            getActivity().startActivity(intent);
        });
    }

    private void configuraPopupEditarNome(){
        dialogEditarNome = PopupNome.configuraPopup(getActivity(), "refeição", nome -> {
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            getActivity().finish();
//            salvarNomeEditado(nome);
            getActivity().startActivity(intent);
        });
    }

    private void configuraRecycle(View root){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ExampleAdapterRefeicaoPersonalizada(
                object -> {
                    Intent intent = new Intent(root.getRootView().getContext(), EditarRefeicao_Activity.class);
                    intent.putExtra("REFEICAO", (Refeicao) object);
                    startActivity(intent);
                },
                object -> {
                    ((EditText)dialogEditarNome.findViewById(R.id.editTextPopupNome)).setText("");
                    dialogEditarNome.show();
                },
                object -> {

                }
        ));
    }

    private void salvarNomeEditado(String nome){
        // Ainda deverá ser contruida
    }



}