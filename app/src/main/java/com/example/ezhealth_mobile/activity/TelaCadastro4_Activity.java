package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;

public class TelaCadastro4_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro4);
    }

    public void irTela5(View v){
        Intent intent = new Intent(this, TelaCadastro5_Activity.class);
        startActivity(intent);
    }

}