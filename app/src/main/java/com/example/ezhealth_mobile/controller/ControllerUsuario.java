package com.example.ezhealth_mobile.controller;

import android.util.Log;

import com.example.ezhealth_mobile.entity.Usuario;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ControllerUsuario {

    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        ControllerUsuario.usuarioLogado = usuarioLogado;
    }

    public static Usuario buscarUsuario(String uuid){

        FirebaseFirestore
            .getInstance()
            .collection("/usuarios")
            .addSnapshotListener((value, error) -> {
                if(error != null){
                    Log.i("TesteBusca", error.getMessage(), error);
                    return;
                }

                for (DocumentSnapshot doc : value.getDocuments())
                    if(doc.getId().equals(uuid))
                        usuarioLogado = doc.toObject(Usuario.class);

                Log.i("TesteBusca", usuarioLogado.getId());
            });

        return usuarioLogado;
    }

}
