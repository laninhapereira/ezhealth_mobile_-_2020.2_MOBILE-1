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

public class TelaCadastro4_Activity extends AppCompatActivity {

    private Usuario user;
    private Button button4;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro4);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");
        Log.i("TesteTela4", user.getDataNascimento());

        button4 = findViewById(R.id.buttonCadastroProximo4);
        button4.setEnabled(false);

        checarRadio();

    }

    private void checarRadio() {
        radioGroup = (RadioGroup)findViewById(R.id.radioTela4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Log.i("teste", String.valueOf(i));
                if(R.id.escolhaCadastroSexoMasculino == i){
                    button4.setEnabled(true);
                }else if(R.id.escolhaCadastroSexoFeminino == i){
                    button4.setEnabled(true);
                }
            }
        });
    }

    public void irTela5(View v){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioTela4);
        String radiovalue =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        Log.i("TesteRadio4", radiovalue);


        Intent intent = new Intent(this, TelaCadastro5_Activity.class);

        user.setSexo(radiovalue);
        intent.putExtra("user", user);

        startActivity(intent);
    }

}