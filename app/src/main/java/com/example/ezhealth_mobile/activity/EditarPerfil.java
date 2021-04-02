package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

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

        TextView txtCpf = findViewById(R.id.editCPF);
        //txtCpf.setText(userLogado.getCpf());
        txtCpf.setHint(userLogado.getCpf());
        txtCpf.setKeyListener(null);


        //Se usuário for comum, esconder CRN
        if(userLogado.getTipoUsuario().equals("Uso Comum")){
            TextView txtCrn = findViewById(R.id.editCRN);
            //txtCrn.setVisibility(View.INVISIBLE);
            txtCrn.setHint("O usuário não possui CRN");
            txtCrn.setKeyListener(null);
        }else if(userLogado.getTipoUsuario().equals("Sou nutricionista")){
            TextView txtCrn = findViewById(R.id.editCRN);
            txtCrn.setHint(userLogado.getCrn());
            txtCrn.setKeyListener(null);
        }

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
        EditText txtNome = findViewById(R.id.editNome); userLogado.setNomeCompleto(txtNome.getText().toString());

        EditText txtDia = findViewById(R.id.editDia); userLogado.setDiaNasc(txtDia.getText().toString());
        EditText txtMes = findViewById(R.id.editMes); userLogado.setMesNasc(txtMes.getText().toString());
        EditText txtAno = findViewById(R.id.editAno); userLogado.setAnoNasc(txtAno.getText().toString());

        EditText txtAltura = findViewById(R.id.editAltura); userLogado.setAltura(txtAltura.getText().toString());

        EditText txtPeso = findViewById(R.id.editPeso); userLogado.setPeso(txtPeso.getText().toString());

        RadioGroup radioGroup = findViewById(R.id.editRadioObjetivo);
        String radiovalue = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        userLogado.setObjetivo(radiovalue);
        //alterarCalculoObjetivo();

        //Conferir checkbox de intolerâncias
        CheckBox checkBox = findViewById(R.id.editLactose);
        CheckBox checkBox2 = findViewById(R.id.editGluten);

        if(checkBox.isChecked() && !checkBox2.isChecked() ) { userLogado.setIntolerancias(checkBox.getText().toString()); }
        else if (!checkBox.isChecked() && checkBox2.isChecked()) { userLogado.setIntolerancias(checkBox2.getText().toString()); }
        else if (checkBox.isChecked() && checkBox2.isChecked()) { userLogado.setIntolerancias( checkBox.getText().toString() + " e " + checkBox2.getText().toString() ); }
        else if (!checkBox.isChecked() && !checkBox2.isChecked()) { userLogado.setIntolerancias("Não possui"); }

        //Conferir checkbox de doenças
        CheckBox checkBox3 = findViewById(R.id.editDiabetes);
        CheckBox checkBox4 = findViewById(R.id.editColesterol);

        if(checkBox3.isChecked() && !checkBox4.isChecked() ) { userLogado.setDoencas(checkBox3.getText().toString()); }
        else if (!checkBox3.isChecked() && checkBox4.isChecked()) { userLogado.setDoencas(checkBox4.getText().toString()); }
        else if (checkBox3.isChecked() && checkBox4.isChecked()) { userLogado.setDoencas( checkBox3.getText().toString() + " e " + checkBox4.getText().toString() ); }
        else if (!checkBox3.isChecked() && !checkBox4.isChecked()) { userLogado.setDoencas("Não possui"); }


        salvarNoFirebase();
    }

    private void alterarCalculoObjetivo() {

    }


    //Salvar usuário no firestore
    public void salvarNoFirebase(/*String teste*/){
        String id = FirebaseAuth.getInstance().getUid();

        //user.setId(id);

        //Salvar usuário no firebase com id como chave primária
        FirebaseFirestore.getInstance().collection("usuarios")
                .document(id)
                .set(userLogado)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.i("testeEdição", documentReference.getId());
                        Toast.makeText(EditarPerfil.this, "Dados Salvos", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(EditarPerfil.this, Home_Activity.class);
                        //Fazer que activity seja a principal
                        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("testeEdição", e.getMessage());
                    }
                });
    }


}