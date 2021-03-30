package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ezhealth_mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

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

}
