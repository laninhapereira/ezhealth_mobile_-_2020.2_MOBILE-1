package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditarSenha extends AppCompatActivity {

    private Usuario userLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_senha);

        //Buscar dado usuário e preencher seus dados
        userLogado = getIntent().getExtras().getParcelable("user");
    }

    public void VoltarPerfil3(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

    public void SalvarAlteraçãoSenha(View v){

        updateSenha();
    }

    private void updateSenha() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        EditText edtSenhaAtual = findViewById(R.id.editSenhaAtual);
        EditText edtNovaSenha = findViewById(R.id.editNovaSenha);

        if(edtSenhaAtual.getText().toString().equals(userLogado.getSenha())) {

            String novaSenha = edtNovaSenha.getText().toString();

            user.updatePassword(novaSenha)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("TesteUpdateSenha", "User password updated.");
                                //Log.d("TesteEmail", user.getEmail());

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
            Toast.makeText(EditarSenha.this, "Sua senha atual está errada, insira novamente", Toast.LENGTH_LONG).show();
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

}