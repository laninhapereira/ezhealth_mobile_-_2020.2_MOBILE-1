package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;

public class EditarPerfil extends AppCompatActivity {

    private Usuario userLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        //Buscar dado usuário e preencher seus dados
        userLogado = getIntent().getExtras().getParcelable("user");
        preencherDados();

    }

    private void preencherDados() {
        TextView txtNome = findViewById(R.id.editNome); txtNome.setText(userLogado.getNomeCompleto());

        TextView txtDiaNascimento = findViewById(R.id.editDia); txtDiaNascimento.setText(userLogado.getDiaNasc());

        TextView txtMesNascimento = findViewById(R.id.editMes); txtMesNascimento.setText(userLogado.getMesNasc());

        TextView txtAnoNascimento = findViewById(R.id.editAno); txtAnoNascimento.setText(userLogado.getAnoNasc());

        TextView txtCpf = findViewById(R.id.editCPF); txtCpf.setText(userLogado.getCpf());

        TextView txtCrn = findViewById(R.id.editCRN); txtCrn.setText(userLogado.getCrn());

        TextView txtAltura = findViewById(R.id.editAltura); txtAltura.setText(userLogado.getAltura());

        TextView txtPeso = findViewById(R.id.editPeso); txtPeso.setText(userLogado.getPeso());

        //Preencher objetivo
        if(userLogado.getObjetivo().equals("Manter Peso")){
            RadioButton radioButton = findViewById(R.id.editManterPeso);
            radioButton.setChecked(true);
        }else if(userLogado.getObjetivo().equals("Perder Peso")){
            RadioButton radioButton = findViewById(R.id.editPerderPeso);
            radioButton.setChecked(true);
        }else if(userLogado.getObjetivo().equals("Ganhar Peso")){
            RadioButton radioButton = findViewById(R.id.editGanharPeso);
            radioButton.setChecked(true);
        }

        //Preencher intolerâncias
        if(userLogado.getIntolerancias().equals("Lactose")) {
            CheckBox checkBox = findViewById(R.id.editLactose);
            checkBox.setChecked(true);
        }else if (userLogado.getIntolerancias().equals("Glúten")) {
            CheckBox checkBox = findViewById(R.id.editGluten);
            checkBox.setChecked(true);
        }else if (userLogado.getIntolerancias().equals("Lactose e Glúten")) {
            CheckBox checkBox = findViewById(R.id.editLactose);
            CheckBox checkBox2 = findViewById(R.id.editGluten);
            checkBox.setChecked(true);
            checkBox2.setChecked(true);
        }

        //Preencher Doenças
        if(userLogado.getDoencas().equals("Diabetes")) {
            CheckBox checkBox = findViewById(R.id.editDiabetes);
            checkBox.setChecked(true);
        }else if (userLogado.getDoencas().equals("Colesterol")) {
            CheckBox checkBox = findViewById(R.id.editColesterol);
            checkBox.setChecked(true);
        }else if (userLogado.getDoencas().equals("Diabetes e Colesterol")) {
            CheckBox checkBox = findViewById(R.id.editDiabetes);
            CheckBox checkBox2 = findViewById(R.id.editColesterol);
            checkBox.setChecked(true);
            checkBox2.setChecked(true);
        }



    }

    public void VoltarPerfil2(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

    public void SalvarAlteraçãoDados(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

}