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

public class MainActivity extends AppCompatActivity {

    private EditText loginEmail, loginSenha;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* Confirmar se todos os campos estão preenchidos //
        loginEmail = findViewById(R.id.editTextEmailLogin);
        loginSenha = findViewById(R.id.editTextSenhaLogin);
        loginButton = findViewById(R.id.buttonLogin);

        loginEmail.addTextChangedListener(loginTextWatcher);
        loginSenha.addTextChangedListener(loginTextWatcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String loginInput = loginEmail.getText().toString().trim();
            String senhaInput = loginSenha.getText().toString().trim();

            loginButton.setEnabled(!loginInput.isEmpty() && !senhaInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void login(View v){

        //------------------------------------------------//
        //Testar se email e senha existem e ir para Home //
        //------------------------------------------------//

        //Intent intent = new Intent(this, ListaExercicioActivity.class);
        //startActivity(intent);

        Intent intent = new Intent(this, Add_Alimento_Refeicao.class);
        startActivity(intent);

    }

    public void cadastrarUsuario(View v){
        Intent intent = new Intent(this, TelaCadastro1Activity.class);
        startActivity(intent);
    }
}