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
import com.example.ezhealth_mobile.entity.Usuario;

public class TelaCadastro5_Activity extends AppCompatActivity {

    private EditText cadastroPeso, cadastroAltura;
    private Button buttonProximo5;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro5);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");

        //* Confirmar se todos os campos estão preenchidos //
        cadastroPeso = findViewById(R.id.editTextCadastroPeso);
        cadastroAltura = findViewById(R.id.editTextCadastroAltura);
        buttonProximo5 = findViewById(R.id.buttonCadastroProximo5);
        buttonProximo5.setEnabled(false);

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

            buttonProximo5.setEnabled(!nomeInput.isEmpty() && !sobrenomeInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void irTela6(View v){
        Intent intent = new Intent(this, TelaCadastro6_Activity.class);

        user.setPeso(cadastroPeso.getText().toString());
        user.setAltura(cadastroAltura.getText().toString());

        intent.putExtra("user", user);

        startActivity(intent);
    }
}