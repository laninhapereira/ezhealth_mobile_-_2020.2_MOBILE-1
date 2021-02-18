package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;

public class EditarSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_senha);
    }

    public void VoltarPerfil3(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

    public void SalvarAlteraçãoSenha(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

}