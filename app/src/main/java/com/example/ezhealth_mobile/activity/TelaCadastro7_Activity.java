package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;

public class TelaCadastro7_Activity extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro7);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");

        Log.i("TesteTela7", user.getObjetivo());

    }

    public void irTela8(View v){
        //Conferir checkbox de intolerâncias
        CheckBox checkBox = findViewById(R.id.escolhaIntoleranciaLactose);
        CheckBox checkBox2 = findViewById(R.id.escolhaIntoleranciaGluten);

        if(checkBox.isChecked() && !checkBox2.isChecked() ) { user.setIntolerancias(checkBox.getText().toString()); }
        else if (!checkBox.isChecked() && checkBox2.isChecked()) { user.setIntolerancias(checkBox2.getText().toString()); }
        else if (checkBox.isChecked() && checkBox2.isChecked()) { user.setIntolerancias( checkBox.getText().toString() + " e " + checkBox2.getText().toString() ); }
        else if (!checkBox.isChecked() && !checkBox2.isChecked()) { user.setIntolerancias("Não possui"); }

        //Conferir checkbox de doenças
        CheckBox checkBox3 = findViewById(R.id.escolhaDoencaDiabetes);
        CheckBox checkBox4 = findViewById(R.id.escolhaDoencaColesterol);

        if(checkBox3.isChecked() && !checkBox4.isChecked() ) { user.setDoencas(checkBox3.getText().toString()); }
        else if (!checkBox3.isChecked() && checkBox4.isChecked()) { user.setDoencas(checkBox4.getText().toString()); }
        else if (checkBox3.isChecked() && checkBox4.isChecked()) { user.setDoencas( checkBox3.getText().toString() + " e " + checkBox4.getText().toString() ); }
        else if (!checkBox3.isChecked() && !checkBox4.isChecked()) { user.setDoencas("Não possui"); }

        //Log.i("Teste Intolerancia", user.getIntolerancias());
        //Log.i("Teste Doenças", user.getDoencas());

        Intent intent = new Intent(this, TelaCadastro8_Activity.class);

        intent.putExtra("user", user);
        startActivity(intent);
    }

}