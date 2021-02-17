package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;

public class TelaCadastro1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro1_);
    }

    public void irTela2(View v){
        Intent intent = new Intent(this, TelaCadastro2_Activity.class);
        startActivity(intent);
    }

}