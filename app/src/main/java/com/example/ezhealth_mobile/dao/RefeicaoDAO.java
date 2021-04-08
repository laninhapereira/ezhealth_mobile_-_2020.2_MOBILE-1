package com.example.ezhealth_mobile.dao;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RefeicaoDAO {

    public interface HandlerRefeicao {
        void handler(Refeicao refeicao);
    }

    public interface HandlerRefeicaoPersonalizada {
        void handlerListPersonalizada(List<Refeicao> listRefeicao);
    }

    private static RefeicaoDAO instance;

    private RefeicaoDAO(){}

    public static RefeicaoDAO getInstance(){
        if(instance == null)
            instance = new RefeicaoDAO();
        return instance;
    }

    public void getRefeicoesDiarias(HandlerRefeicao handlerRefeicao){
        String idUsuario = FirebaseAuth.getInstance().getUid();

        FirebaseFirestore
                .getInstance()
                .collection("/usuarios").document(idUsuario)
                .collection("/refeicoes")
                .get()
                .addOnSuccessListener(
                    documentSnapshots -> {
                        List<DocumentSnapshot> documents = documentSnapshots.getDocuments();
                        if(documents == null)
                            return;

                        for (DocumentSnapshot doc : documents) {
                            Refeicao refeicao = doc.toObject(Refeicao.class);
                            if(refeicao.isDiaria()) {
                                ArrayList<Alimento> list = new ArrayList();
                                list.add(new Alimento("Coxinha", 1, "g", 54,
                                        21, 21, 54));
                                refeicao.setListAlimentos(list);
                                handlerRefeicao.handler(refeicao);
                            }
                        }

                    }
                ).addOnFailureListener(e -> Log.e("erro ao buscar refeicao", e.getMessage() ));
    }

    public void getRefeicoesPersonalizadas(HandlerRefeicaoPersonalizada handlerRefeicao){
        String idUsuario = FirebaseAuth.getInstance().getUid();

        FirebaseFirestore
                .getInstance()
                .collection("/usuarios").document(idUsuario)
                .collection("/refeicoes")
                .get()
                .addOnSuccessListener(
                        documentSnapshots -> {
                            List<DocumentSnapshot> documents = documentSnapshots.getDocuments();
                            List<Refeicao> listRefeicao = new ArrayList<Refeicao>();
                            if(documents == null)
                                return;

                            for (DocumentSnapshot doc : documents) {
                                Refeicao refeicao = doc.toObject(Refeicao.class);
                                if(!refeicao.isDiaria()) {
                                    ArrayList<Alimento> list = new ArrayList();
                                    list.add(new Alimento("Coxinha", 1, "g", 54,
                                            21, 21, 54));
                                    refeicao.setListAlimentos(list);
                                    listRefeicao.add(refeicao);
                                }
                            }

                            handlerRefeicao.handlerListPersonalizada(listRefeicao);

                        }
                ).addOnFailureListener(e -> Log.e("erro ao buscar refeicao", e.getMessage() ));
    }

}
