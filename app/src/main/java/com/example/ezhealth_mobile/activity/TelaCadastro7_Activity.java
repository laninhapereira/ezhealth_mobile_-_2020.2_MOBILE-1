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

public class TelaCadastro7_Activity extends AppCompatActivity {

    private EditText cadastroEmail, cadastroSenha, getCadastroSenha2;
    private Button buttonProximo7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro7);

        //* Confirmar se todos os campos estão preenchidos //
        cadastroEmail = findViewById(R.id.editTextEmailCadastro);
        cadastroSenha = findViewById(R.id.editTextSenhaCadastro1);
        getCadastroSenha2 = findViewById(R.id.editTextSenhaCadastro2);
        buttonProximo7 = findViewById(R.id.buttonProximo7);

        cadastroEmail.addTextChangedListener(cadastro7Watcher);
        cadastroSenha.addTextChangedListener(cadastro7Watcher);
        getCadastroSenha2.addTextChangedListener(cadastro7Watcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro7Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String emailInput = cadastroEmail.getText().toString().trim();
            String senha1Input = cadastroSenha.getText().toString().trim();
            String senha2Input = getCadastroSenha2.getText().toString().trim();

            buttonProximo7.setEnabled(!emailInput.isEmpty() && !senha1Input.isEmpty() && !senha2Input.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void voltarTelaLogin(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }

}