package com.example.ezhealth_mobile.dao;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.ezhealth_mobile.activity.EditarPerfil;
import com.example.ezhealth_mobile.activity.Home_Activity;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

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
                            String caloras = doc.get("calorias").toString();
                            Integer calorias = Integer.parseInt(caloras);
                            refeicao.setCalorias(calorias);
                            if(refeicao.isDiaria()) {
                                refeicao.setListAlimentos(getAlimentoRefeicao(refeicao.getId()));
                                Log.d("asdasd", "vaaaaaaaa"+refeicao.getCalorias());
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
                                    refeicao.setListAlimentos(getAlimentoRefeicao(refeicao.getId()));
                                    listRefeicao.add(refeicao);
                                }
                            }

                            handlerRefeicao.handlerListPersonalizada(listRefeicao);

                        }
                ).addOnFailureListener(e -> Log.e("erro ao buscar refeicao", e.getMessage() ));
    }


    public List<Alimento> getAlimentoRefeicao(String id){
        String idUsuario = FirebaseAuth.getInstance().getUid();
        List<Alimento> alimentoList = new ArrayList();

        FirebaseFirestore
                .getInstance()
                .collection("/usuarios").document(idUsuario)
                .collection("/refeicoes").document(id)
                .collection("/alimentos").get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<DocumentSnapshot> querySnapshots = queryDocumentSnapshots.getDocuments();
                    
                    for(DocumentSnapshot documentSnapshot :querySnapshots)
                        alimentoList.add(documentSnapshot.toObject(Alimento.class));

                });

        return alimentoList;
    }

    public void saveRefeicao(Refeicao refeicao){
        String id = FirebaseAuth.getInstance().getUid();

        saveAlimentos(refeicao.getId(), refeicao.getListAlimentos());

        refeicao.setListAlimentos(null);

        //Salvar usuário no firebase com id como chave primária
        FirebaseFirestore
                .getInstance()
                .collection("/usuarios").document(id)
                .collection("/refeicoes").document(refeicao.getId())
                .set(refeicao)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("testeEdição", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("testeEdição", e.getMessage());
                    }
                });
    }

    private void saveAlimentos(String idRefeicao, List<Alimento> alimentoList){
        String id = FirebaseAuth.getInstance().getUid();

//        removeAlimento(idRefeicao, alimentoList);
        //Salvar usuário no firebase com id como chave primária
        for(Alimento alimento: alimentoList)
            if(alimento.getId() != null)
                FirebaseFirestore
                        .getInstance()
                        .collection("/usuarios").document(id)
                        .collection("/refeicoes").document(idRefeicao)
                        .collection("/alimentos").document(alimento.getId())
                        .set(alimento);
            else {
                getAutoIdAlimento(idRefeicao, alimento);
                FirebaseFirestore
                        .getInstance()
                        .collection("/usuarios").document(id)
                        .collection("/refeicoes").document(idRefeicao)
                        .collection("/alimentos").document(alimento.getId())
                        .set(alimento);
            }
    }

    private void getAutoIdAlimento(String idRefeicao, Alimento alimento){
        String id = FirebaseAuth.getInstance().getUid();

        alimento.setId(
            FirebaseFirestore
                .getInstance()
                .collection("/usuarios").document(id)
                .collection("/refeicoes").document(idRefeicao)
                .collection("/alimentos").document()
                .getId()
        );
    }

    private void removeAlimento(String idRefeicao, List<Alimento> alimentoList){
        String id = FirebaseAuth.getInstance().getUid();

        for(Alimento alimento: alimentoList)
            if(alimento.getId() != null)
                FirebaseFirestore
                        .getInstance()
                        .collection("/usuarios").document(id)
                        .collection("/refeicoes").document(idRefeicao)
                        .collection("/alimentos").document(alimento.getId())
                        .delete();
    }

}
