package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Home_Activity extends AppCompatActivity {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_diario, R.id.navigation_refeicoes, R.id.navigation_exercicios, R.id.navigation_perfil).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        verificarAutenticacao();
//        cadastra();
    }

    private void verificarAutenticacao() {
        if(FirebaseAuth.getInstance().getUid() == null){
            Intent intent = new Intent(Home_Activity.this, Main_Activity.class);
            //Fazer que activity seja a principal
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void sair(View view){
        FirebaseAuth.getInstance().signOut();
        verificarAutenticacao();
    }

    public void irEditarRefeicao(View view){
        Intent intent = new Intent(this, EditarRefeicao_Activity.class);
        startActivity(intent);
    }

    public void irAdicionarAlimento(View view){
        Intent intent = new Intent(this, EditarRefeicao_Activity.class);
        startActivity(intent);
    }

    public void irPerfil(View view){
        navView.setSelectedItemId(R.id.navigation_perfil);
    }

    public void irRelatorio(View view){
        Intent intent = new Intent(this, Relatorio_Activity.class);
        startActivity(intent);
    }

    public void cadastra(){
        String idUsuario = FirebaseAuth.getInstance().getUid();

        Alimento alimento = new Alimento();
        alimento.setNome("Laranja");

        ArrayList<Alimento> list = new ArrayList<>();
        list.add(alimento);
        alimento.setNome("Caju");
        list.add(alimento);

        Refeicao ref = new Refeicao();
        ref.setDiaria(true);
        ref.setListAlimentos(list);
        ref.setData(new Date());

        ref.setNome("Café da manhã");
        adicionaAlimentos(
                adicionaRefeicao(idUsuario, ref),
                ref.getListAlimentos()
        );

        ref.setNome("Almoço");
        adicionaAlimentos(
                adicionaRefeicao(idUsuario, ref),
                ref.getListAlimentos()
        );

        ref.setNome("Lanche da Tarde");
        adicionaAlimentos(
                adicionaRefeicao(idUsuario, ref),
                ref.getListAlimentos()
        );

        ref.setNome("Jantar");
        adicionaAlimentos(
                adicionaRefeicao(idUsuario, ref),
                ref.getListAlimentos()
        );

        ref.setNome("Lanche da noite");
        adicionaAlimentos(
                adicionaRefeicao(idUsuario, ref),
                ref.getListAlimentos()
        );

        Log.d("äaaaaaaaa", "cabou:++++++++++++++");
    }

    private DocumentReference adicionaRefeicao(String idUsuario, Refeicao ref){
        CollectionReference refRefecao = FirebaseFirestore.getInstance()
                .collection("usuarios").document(idUsuario)
                .collection("refeicoes");

        String idRefeicao = refRefecao.document().getId();
        refRefecao.document(idRefeicao).set(ref.toRefeicaoDB());

        return refRefecao.document(idRefeicao);
    }

    private void adicionaAlimentos(DocumentReference referenceRefeicao, List<Alimento> listAlimento){
        CollectionReference refAlimento = referenceRefeicao.collection("alimentos");

        for(Alimento ali: listAlimento) {
            String idAlimento = refAlimento.document().getId();
            refAlimento.document(idAlimento).set(ali.toAlimentoDB());
        }
    }

}
