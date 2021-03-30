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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main_Activity extends AppCompatActivity {

    private EditText loginEmail, loginSenha;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* Confirmar se todos os campos estão preenchidos //
        loginEmail = findViewById(R.id.editTextEmailLogin);
        loginSenha = findViewById(R.id.editTextSenhaLogin);
        loginButton = findViewById(R.id.buttonLogin);

        loginEmail.addTextChangedListener(loginTextWatcher);
        loginSenha.addTextChangedListener(loginTextWatcher);
        // Confirmar se todos os campos estão preenchidos *//

    }

    // Confirmar se todos os campos estão preenchidos

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String loginInput = loginEmail.getText().toString().trim();
            String senhaInput = loginSenha.getText().toString().trim();

            loginButton.setEnabled(!loginInput.isEmpty() && !senhaInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void login(View v){

        //------------------------------------------------//
        //Testar se email e senha existem e ir para Home //
        //------------------------------------------------//
        
        autenticarUsuario(loginEmail.getText().toString() , loginSenha.getText().toString());

        //Intent intent = new Intent(this, Home_Activity.class);
        //startActivity(intent);

        //Intent intent = new Intent(this, AdicionarExercicioActivity.class);
        //startActivity(intent);

    }

    public void cadastrarUsuario(View v){
        Intent intent = new Intent(this, TelaCadastro8_Activity.class);
        startActivity(intent);
    }


    //Autenticar usuário no firestore
    public void autenticarUsuario(String email , String senha){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.i("testeAutenticação", task.getResult().getUser().getUid());

                    Intent intent = new Intent(Main_Activity.this, Home_Activity.class);
                    //Fazer que activity seja a principal
                    //intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.i("testeAutenticação", e.getMessage());
                }
            });
    }

}