package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.util.ExampleAdapterAlimento;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TabFragment_Alimento extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_alimento_fragment, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerViewAlimentos);

        buscarAlimentos();

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void buscarAlimentos() {
        ArrayList<Alimento> listAlimento = new ArrayList<>();
        FirebaseFirestore
            .getInstance()
            .collection("/alimentos")
            .addSnapshotListener((value, error) -> {
                if(error != null){
                    Log.i("TesteBusca", error.getMessage(), error);
                    return;
                }
                //Elementos da lista de usuários
                List<DocumentSnapshot> docs = value.getDocuments();

                for (DocumentSnapshot doc : docs)
                    listAlimento.add(doc.toObject(Alimento.class));

                for(Alimento a: listAlimento)
                    Log.d("buscarAlimentos:_", "_"+a.toString());

                configurarRecycleView(listAlimento);
            });
    }

    public void configurarRecycleView(ArrayList<Alimento> listAlimento){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new ExampleAdapterAlimento(
                listAlimento,
                alimento -> { // Construção do botão de ADICIONAR de cada item da lista
                    Intent intent = new Intent();
                    intent.putExtra("ALIMENTO", (Alimento) alimento);
                    getActivity().setResult(getActivity().RESULT_OK, intent);
                    getActivity().finish();
                }, // Construção do botão de EDITAR de cada item da lista
                alimento -> {
                    Intent intent = new Intent(getContext(), EditarAlimento_Activity.class);
                    intent.putExtra("ALIMENTO", (Alimento) alimento);
                    startActivity(intent);
                })
        );
    }
}
