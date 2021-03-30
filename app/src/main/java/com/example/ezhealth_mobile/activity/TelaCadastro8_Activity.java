package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class TelaCadastro8_Activity extends AppCompatActivity {

    private EditText cadastroEmail, cadastroSenha, cadastroSenha2, teste;
    private Button buttonProximo8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro8);

        //* Confirmar se todos os campos estão preenchidos //
        cadastroEmail = findViewById(R.id.editTextCadastroEmail);
        cadastroSenha = findViewById(R.id.editTextCadastroSenha1);
        teste = findViewById(R.id.editTextCadastroSenha2);
        buttonProximo8 = findViewById(R.id.buttonCadastroProximo8);

        //cadastroEmail.addTextChangedListener(cadastro7Watcher);
        //cadastroSenha.addTextChangedListener(cadastro7Watcher);
        //cadastroSenha2.addTextChangedListener(cadastro7Watcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher cadastro7Watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String email = cadastroEmail.getText().toString().trim();
            String senha1 = cadastroSenha.getText().toString().trim();
            String senha2 = cadastroSenha2.getText().toString().trim();

            buttonProximo8.setEnabled(!email.isEmpty() && !senha1.isEmpty() && !senha2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    //Concluir Cadastro
    public void voltarTelaLogin(View v){
        String email = cadastroEmail.getText().toString();
        String senha = cadastroSenha.getText().toString();
        /*String senha2 = cadastroSenha2.getText().toString();

        if(email == null || email.isEmpty() || senha == null || senha.isEmpty() || senha2 == null || senha2.isEmpty() ){
            Toast.makeText(this, "Todos os dados devem ser preenchidos", Toast.LENGTH_SHORT).toString();
            return;
        }*/

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) Log.i("TesteCadastro", task.getResult().getUser().getUid());

                    salvarNoFirebase(teste.getText().toString());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.i("TesteCadastro", e.getMessage());
                }
        });


        //Intent intent = new Intent(this, Main_Activity.class);
        //startActivity(intent);
    }

    //Salvar usuário no firestore
    public void salvarNoFirebase(String teste){
        String id = FirebaseAuth.getInstance().getUid();
        String testee = teste;

        Usuario user = new Usuario(id, testee);

        //Salvar usuário no firebase com id como chave primária
        FirebaseFirestore.getInstance().collection("usuarios")
                .document(id)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.i("testeCadastro", documentReference.getId());

                        Intent intent = new Intent(TelaCadastro8_Activity.this, Home_Activity.class);
                        //Fazer que activity seja a principal
                        //intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("testeCadastro", e.getMessage());
                    }
                });
    }

}