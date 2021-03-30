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

public class TelaCadastro2_Activity extends AppCompatActivity {


    private EditText cadastroNome, cadastroCPF, cadastroCRN;
    private Button buttonProximo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro2);

        //* Confirmar se todos os campos estão preenchidos //
        cadastroNome = findViewById(R.id.editTextCadastroNomeCompleto);
        cadastroCPF = findViewById(R.id.editTextCadastroCPF);
        cadastroCRN = findViewById(R.id.editTextCadastroCRN);
        //cadastroCRN.setVisibility(View.INVISIBLE);
        buttonProximo2 = findViewById(R.id.buttonCadastroProximo2);

        cadastroNome.addTextChangedListener(cadastro1Watcher);
        cadastroCPF.addTextChangedListener(cadastro1Watcher);
        cadastroCRN.addTextChangedListener(cadastro1Watcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro1Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String nomeInput = cadastroNome.getText().toString().trim();
            String CPFInput = cadastroCPF.getText().toString().trim();
            String CRNInput = cadastroCRN.getText().toString().trim();

            buttonProximo2.setEnabled(!nomeInput.isEmpty() && !CPFInput.isEmpty() && !CRNInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void irTela3(View v){
        Intent intent = new Intent(this, TelaCadastro8_Activity.class);

        Usuario user = new Usuario();
        user.setNomeCompleto(cadastroNome.getText().toString());
        user.setCpf(cadastroCPF.getText().toString());
        user.setCrn(cadastroCRN.getText().toString());

        intent.putExtra("user", user);

        startActivity(intent);
    }

}