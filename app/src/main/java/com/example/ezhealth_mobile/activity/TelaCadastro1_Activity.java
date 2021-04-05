package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;

public class TelaCadastro1_Activity extends AppCompatActivity {

    private Usuario user;
    private Button button1;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro1_);

        button1 = findViewById(R.id.buttonCadastroProximo1);
        button1.setEnabled(false);

        checarRadio();

    }

    private void checarRadio() {
        radioGroup = (RadioGroup)findViewById(R.id.radioTela1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Log.i("teste", String.valueOf(i));
                if(R.id.escolhaCadastroUsario == i){
                    button1.setEnabled(true);
                }else if(R.id.escolhaCadastroNutricionista == i){
                    button1.setEnabled(true);
                }
            }
        });
    }

    public void irTela2(View v){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioTela1);
        String radiovalue =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        Log.i("TesteRadio", radiovalue);

        Intent intent = new Intent(this, TelaCadastro2_Activity.class);

        user = new Usuario();
        user.setTipoUsuario(radiovalue);
        intent.putExtra("user", user);

        startActivity(intent);
    }

}