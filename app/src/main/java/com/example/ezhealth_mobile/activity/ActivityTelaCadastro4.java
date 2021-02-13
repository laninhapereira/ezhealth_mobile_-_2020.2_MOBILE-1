package com.example.ezhealth_mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ezhealth_mobile.R;

public class ActivityTelaCadastro4 extends AppCompatActivity {

    private EditText cadastroPeso, cadastroAltura;
    private Button buttonProximo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro4);

        //* Confirmar se todos os campos estão preenchidos //
        cadastroPeso = findViewById(R.id.editTextPeso);
        cadastroAltura = findViewById(R.id.editTextAltura);
        buttonProximo4 = findViewById(R.id.buttonProximo4);

        cadastroPeso.addTextChangedListener(cadastro4Watcher);
        cadastroAltura.addTextChangedListener(cadastro4Watcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro4Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String nomeInput = cadastroPeso.getText().toString().trim();
            String sobrenomeInput = cadastroAltura.getText().toString().trim();

            buttonProximo4.setEnabled(!nomeInput.isEmpty() && !sobrenomeInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void irTela5(View v){
        Intent intent = new Intent(this, ActivityTelaCadastro5.class);
        startActivity(intent);
    }
}