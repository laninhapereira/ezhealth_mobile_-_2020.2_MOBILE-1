package com.example.ezhealth_mobile.ui.perfil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarPerfil;
import com.example.ezhealth_mobile.activity.EditarSenha;
import com.example.ezhealth_mobile.activity.Home_Activity;
import com.example.ezhealth_mobile.activity.TelaCadastro8_Activity;
import com.example.ezhealth_mobile.activity.TelaChat_Activity;
import com.example.ezhealth_mobile.controller.ControllerUsuario;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;
    private TextView nome;
    private TextView email;
    private TextView dataNascimento;
    private TextView sexo;
    private TextView cpf;
    private TextView crn;
    private TextView altura;
    private TextView peso;
    private TextView objetivo;
    private TextView intolerancia;
    private TextView doenca;
    private FloatingActionButton abrirchat;
    private TextView editarSenha;
    private TextView editarDados;

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

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        nome = root.findViewById(R.id.TextPerfilNome);
        email = root.findViewById(R.id.TextPerfilEmail);
        dataNascimento = root.findViewById(R.id.perfilNascimento);
        sexo = root.findViewById(R.id.perfilSexo);
        cpf = root.findViewById(R.id.perfilCPF);
        crn = root.findViewById(R.id.perfilCRN);
        altura = root.findViewById(R.id.perfilAltura);
        peso = root.findViewById(R.id.perfilPeso);
        objetivo = root.findViewById(R.id.perfilObjetivo);
        intolerancia = root.findViewById(R.id.perfilIntolerancia);
        doenca = root.findViewById(R.id.perfilDoencas);

        abrirchat = root.findViewById(R.id.fabAbrirChat);
        editarDados = root.findViewById(R.id.ClicarEditarDados);
        editarSenha = root.findViewById(R.id.TextEditarSenha);

        Context context = root.getContext();
        //Abrir tela de chat
        abrirchat.setOnClickListener(v -> startActivity(new Intent(context, TelaChat_Activity.class)));

        //Abrir tela de edição de dados cadastrais
        editarDados.setOnClickListener(v -> startActivity(new Intent(context, EditarPerfil.class)));

        //Abrir tela de edição de senha
        editarSenha.setOnClickListener(v -> startActivity(new Intent(context, EditarPerfil.class)));

        atributiDados();
        return root;
    }


    public void atributiDados(){
        Usuario usuario = ControllerUsuario.getUsuarioLogado();

        nome.setText(usuario.getNomeCompleto());
        email.setText(usuario.getEmail());
        dataNascimento.setText(usuario.getDataNascimento());
        sexo.setText(usuario.getSexo());
        cpf.setText(usuario.getCpf());
        crn.setText(usuario.getCrn());
        altura.setText(usuario.getAltura());
        peso.setText(usuario.getPeso());
        objetivo.setText(usuario.getObjetivo());
        intolerancia.setText(usuario.getIntolerancias());
        doenca.setText(usuario.getDoencas());
    }

}