package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditarSenha extends AppCompatActivity {

    private Usuario userLogado;

    EditText edtSenhaAtual;
    EditText edtNovaSenha;
    EditText edtNovaSenha2;

    private Button buttonEditSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_senha);

        //Buscar dado usuário e preencher seus dados
        userLogado = getIntent().getExtras().getParcelable("user");


        //* Confirmar se todos os campos estão preenchidos //
        edtSenhaAtual = findViewById(R.id.editSenhaAtual);
        edtNovaSenha = findViewById(R.id.editNovaSenha);
        edtNovaSenha2 = findViewById(R.id.editNovaSenha2);

        buttonEditSenha = findViewById(R.id.buttonEditarSenha);
        buttonEditSenha.setEnabled(false);

        edtSenhaAtual.addTextChangedListener(editSenhaTextWatcher);
        edtNovaSenha.addTextChangedListener(editSenhaTextWatcher);
        edtNovaSenha2.addTextChangedListener(editSenhaTextWatcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher editSenhaTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String senhaAtual = edtSenhaAtual.getText().toString().trim();
            String novaSenha = edtNovaSenha.getText().toString().trim();
            String novaSenha2 = edtNovaSenha2.getText().toString().trim();

            buttonEditSenha.setEnabled( !senhaAtual.isEmpty() && !novaSenha.isEmpty() && !novaSenha2.isEmpty() );
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void VoltarPerfil3(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

    public void SalvarAlteraçãoSenha(View v){
        updateSenha();
    }

    private void updateSenha() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        edtSenhaAtual = findViewById(R.id.editSenhaAtual);
        edtNovaSenha = findViewById(R.id.editNovaSenha);
        edtNovaSenha2 = findViewById(R.id.editNovaSenha2);

        if(edtSenhaAtual.getText().toString().equals(userLogado.getSenha())) {

            if(edtNovaSenha.getText().toString().equals(edtNovaSenha2.getText().toString())) {

                String novaSenha = edtNovaSenha.getText().toString();

                user.updatePassword(novaSenha)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("TesteUpdateSenha", "User password updated.");
                                    //Log.d("TesteEmail", user.getEmail());

                                    salvarNoFirebase(novaSenha);

                                    Toast.makeText(EditarSenha.this, "Senha alterada", Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(EditarSenha.this, Home_Activity.class);
                                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);

                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("testeUpdateSenha", e.getMessage());

                        Intent intent = new Intent(EditarSenha.this, Main_Activity.class);

                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(EditarSenha.this, "O usuário está inativo há bastante tempo, realize o login novamente", Toast.LENGTH_LONG).show();

                        verificarAutenticacao(intent);
                    }
                });
            }else{
                Log.i("testeEdit 1 : ", edtNovaSenha.getText().toString());
                Log.i("testeEdit 2 : ", edtNovaSenha2.getText().toString());
                Toast.makeText(EditarSenha.this, "Os campos de nova senha precisam ser iguais", Toast.LENGTH_LONG).show();
                return;
            }

        }else{
            Toast.makeText(EditarSenha.this, "Sua senha atual difere do cadastro, insira novamente", Toast.LENGTH_LONG).show();
            return;
        }
    }

    private void verificarAutenticacao(Intent intent) {
        if(FirebaseAuth.getInstance().getUid() == null){
            //Fazer que activity seja a principal
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    //Salvar usuário no firestore
    public void salvarNoFirebase(String novaSenha){
        String id = FirebaseAuth.getInstance().getUid();
        userLogado.setSenha(novaSenha);
        //user.setId(id);

        //Salvar usuário no firebase com id como chave primária
        FirebaseFirestore.getInstance().collection("usuarios")
                .document(id)
                .set(userLogado)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.i("testeEdição", documentReference.get());
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