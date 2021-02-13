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

public class ActivityTelaCadastro2 extends AppCompatActivity {

    private EditText cadastroDia, cadastroMes, cadastroAno;
    private Button buttonProximo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro2);

        //* Confirmar se todos os campos estão preenchidos //
        cadastroDia = findViewById(R.id.editTextDia);
        cadastroMes = findViewById(R.id.editTextMes);
        cadastroAno = findViewById(R.id.editTextAno);
        buttonProximo2 = findViewById(R.id.buttonProximo2);

        cadastroDia.addTextChangedListener(cadastro1Watcher);
        cadastroMes.addTextChangedListener(cadastro1Watcher);
        cadastroAno.addTextChangedListener(cadastro1Watcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro1Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String diaInput = cadastroDia.getText().toString().trim();
            String mesInput = cadastroMes.getText().toString().trim();
            String anoInput = cadastroAno.getText().toString().trim();

            buttonProximo2.setEnabled(!diaInput.isEmpty() && !mesInput.isEmpty() && !anoInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void irTela3(View v){
        Intent intent = new Intent(this, ActivityTelaCadastro3.class);
        startActivity(intent);
    }
}