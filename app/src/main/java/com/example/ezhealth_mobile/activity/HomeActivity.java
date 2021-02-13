package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ezhealth_mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_diario, R.id.navigation_refeicoes, R.id.navigation_exercicios, R.id.navigation_perfil).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(navView, navController);


        //TESTE TESTE TESTE

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.navigation_diario:
                        return true;
                    case R.id.navigation_refeicoes:
                        startActivity(new Intent(getApplicationContext(), EditarRefeicaoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_exercicios:
                        startActivity(new Intent(getApplicationContext(), ListaExercicioActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_perfil:
                        return true;
                }
                return false;
            }
        });

        //TESTE TESTE TESTE

    }

    public void irEditarRefeicao(View view){
        Intent intent = new Intent(this, EditarRefeicaoActivity.class);
        startActivity(intent);
    }

    public void irAdicionarAlimento(View view){
        Intent intent = new Intent(this, EditarRefeicaoActivity.class);
        startActivity(intent);
    }

}
