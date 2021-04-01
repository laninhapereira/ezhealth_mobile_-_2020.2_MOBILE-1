package com.example.ezhealth_mobile.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarPerfil;
import com.example.ezhealth_mobile.activity.EditarSenha;
import com.example.ezhealth_mobile.activity.Main_Activity;
import com.example.ezhealth_mobile.activity.Maps_Activity;
import com.example.ezhealth_mobile.activity.TelaChat_Activity;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PerfilFragment extends Fragment {

    private Usuario userLogado;
    private View root;

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

        //Buscar dado usuário e preencher seus dados
        BuscarDadosUsusario();

        root = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Abrir tela de chat
        Intent intent = new Intent(root.getRootView().getContext(), TelaChat_Activity.class);

        root.findViewById(R.id.fabAbrirChat).setOnClickListener(v -> {
            startActivity(intent);
        });


        //Abrir tela de edição de dados cadastrais
        Intent intent1 = new Intent(root.getRootView().getContext(), EditarPerfil.class);

        root.findViewById(R.id.ClicarEditarDados).setOnClickListener(v -> {
            startActivity(intent1);
        });

        //Abrir tela de edição de senha
        Intent intent2 = new Intent(root.getRootView().getContext(), EditarSenha.class);

        root.findViewById(R.id.TextEditarSenha).setOnClickListener(v -> {
            startActivity(intent2);
        });

        //Sair do app
        Intent intent3 = new Intent(root.getRootView().getContext(), Main_Activity.class);

        root.findViewById(R.id.fabSairApp).setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            verificarAutenticacao(intent3);
            // startActivity(intent3);
        });

        //Abrir maps        ///////////Em desenvolvimento\\\\\\\\\\\\\\\
        Intent intent4 = new Intent(root.getRootView().getContext(), Maps_Activity.class);

        root.findViewById(R.id.fabMaps).setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            verificarAutenticacao(intent4);
        });


        return root;
    }

    private void BuscarDadosUsusario() {
        //Buscar coleção de usuários para buscar o registro de conversas do usuário logado
        FirebaseFirestore.getInstance().collection("/usuarios")
                .document(FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        userLogado = documentSnapshot.toObject(Usuario.class);
                        PreencherPerfil();
                    }
                });
    }

    private void PreencherPerfil() {
        TextView txtNome = root.findViewById(R.id.TextPerfilNome);
        txtNome.setText(userLogado.getNomeCompleto());

        TextView txtNascimento = root.findViewById(R.id.perfilNascimento);
        txtNascimento.setText(userLogado.getDataNascimento());

        TextView txtSexo = root.findViewById(R.id.perfilSexo);
        txtSexo.setText(userLogado.getSexo());

        TextView txtCpf = root.findViewById(R.id.perfilCPF);
        txtCpf.setText(userLogado.getCpf());

        TextView txtCrn = root.findViewById(R.id.perfilCRN);
        txtCrn.setText(userLogado.getCrn());

        TextView txtAltura = root.findViewById(R.id.perfilAltura);
        txtAltura.setText(userLogado.getAltura() + " cm");

        TextView txtPeso = root.findViewById(R.id.perfilPeso);
        txtPeso.setText(userLogado.getPeso() + " kg");

        TextView txtObjetivo = root.findViewById(R.id.perfilObjetivo);
        txtObjetivo.setText(userLogado.getObjetivo());

        TextView txtIntolerancias = root.findViewById(R.id.perfilIntolerancia);
        txtIntolerancias.setText(userLogado.getIntolerancias());

        TextView txtDoencas = root.findViewById(R.id.perfilDoencas);
        txtDoencas.setText(userLogado.getDoencas());
    }

    private void verificarAutenticacao(Intent intent) {
        if(FirebaseAuth.getInstance().getUid() == null){
            //Fazer que activity seja a principal
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}