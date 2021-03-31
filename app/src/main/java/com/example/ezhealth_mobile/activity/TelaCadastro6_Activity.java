package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;

public class TelaCadastro6_Activity extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro6);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");

        Log.i("TesteTela6", user.getPeso());

    }

    public void irTela7(View v){
        RadioGroup radioGroup = findViewById(R.id.radioTela6);
        String radiovalue =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();


        Intent intent = new Intent(this, TelaCadastro7_Activity.class);

        user.setObjetivo(radiovalue);
        intent.putExtra("user", user);

        startActivity(intent);
    }

}