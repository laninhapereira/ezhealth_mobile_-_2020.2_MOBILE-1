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
