package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;

public class TelaCadastro2_Activity extends AppCompatActivity {


    private EditText cadastroNome, cadastroCPF, cadastroCRN;
    private Button buttonProximo2;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro2);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");
        Log.i("testeIntent", user.getTipoUsuario());


        //* Confirmar se todos os campos estão preenchidos //
        cadastroNome = findViewById(R.id.editTextCadastroNomeCompleto);
        cadastroCPF = findViewById(R.id.editTextCadastroCPF);

        //Se usuário for comum, esconder CRN
        cadastroCRN = findViewById(R.id.editTextCadastroCRN);
        if(user.getTipoUsuario().equals("Uso Comum")){ cadastroCRN.setVisibility(View.INVISIBLE); }
        else  cadastroCRN.addTextChangedListener(cadastro1Watcher);

        buttonProximo2 = findViewById(R.id.buttonCadastroProximo2);

        cadastroNome.addTextChangedListener(cadastro1Watcher);
        cadastroCPF.addTextChangedListener(cadastro1Watcher);

        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro1Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            buttonProximo2.setEnabled(true);

            String nomeInput = cadastroNome.getText().toString().trim();
            String CPFInput = cadastroCPF.getText().toString().trim();
            String CRNInput = cadastroCRN.getText().toString().trim();

            if(user.getTipoUsuario().equals("Uso Comum")){ buttonProximo2.setEnabled(!nomeInput.isEmpty() && !CPFInput.isEmpty()); }
            else buttonProximo2.setEnabled(!nomeInput.isEmpty() && !CPFInput.isEmpty() && !CRNInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void irTela3(View v){
        Intent intent = new Intent(this, TelaCadastro3_Activity.class);

        user.setNomeCompleto(cadastroNome.getText().toString());
        user.setCpf(cadastroCPF.getText().toString());

        if(user.getTipoUsuario().equals("Uso Comum")){ user.setCrn("Não possui"); }
        else user.setCrn(cadastroCRN.getText().toString());


        intent.putExtra("user", user);

        startActivity(intent);
    }

}