package com.example.ezhealth_mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ezhealth_mobile.R;

public class ActivityTelaCadastro5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro5);
    }

    public void irTela4(View v){
        Intent intent = new Intent(this, ActivityTelaCadastro6.class);
        startActivity(intent);
    }

}