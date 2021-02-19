package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;

public class TelaCadastro8_Activity extends AppCompatActivity {

    private EditText cadastroEmail, cadastroSenha, getCadastroSenha2;
    private Button buttonProximo8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro8);

        //* Confirmar se todos os campos estão preenchidos //
        cadastroEmail = findViewById(R.id.editTextCadastroEmail);
        cadastroSenha = findViewById(R.id.editTextCadastroSenha1);
        getCadastroSenha2 = findViewById(R.id.editTextCadastroSenha2);
        buttonProximo8 = findViewById(R.id.buttonCadastroProximo8);

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
            String email = cadastroEmail.getText().toString().trim();
            String senha1 = cadastroSenha.getText().toString().trim();
            String senha2 = getCadastroSenha2.getText().toString().trim();

            buttonProximo8.setEnabled(!email.isEmpty() && !senha1.isEmpty() && !senha2.isEmpty());
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