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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

public class TelaCadastro8_Activity extends AppCompatActivity {

    private EditText cadastroEmail, cadastroSenha, cadastroSenha2, teste;
    private Button buttonProximo8;
    private Usuario user;

    //Login Google
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth firebaseAuth;
    private Button buttonLogoutGoogle;
    private int RESULT_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro8);

        // Receber objeto(usuário que irá receber mensagem) de outra activity
        user = getIntent().getExtras().getParcelable("user");

        //* Confirmar se todos os campos estão preenchidos //
        cadastroEmail = findViewById(R.id.editTextCadastroEmail);
        cadastroSenha = findViewById(R.id.editTextCadastroSenha1);
        cadastroSenha2 = findViewById(R.id.editTextCadastroSenha2);
        //cadastroSenha2.setVisibility(View.INVISIBLE);

        buttonProximo8 = findViewById(R.id.buttonCadastroProximo8);
        buttonProximo8.setEnabled(false);

        cadastroEmail.addTextChangedListener(cadastro7Watcher);
        cadastroSenha.addTextChangedListener(cadastro7Watcher);
        cadastroSenha2.addTextChangedListener(cadastro7Watcher);
        // Confirmar se todos os campos estão preenchidos *//

        //* Login Google //
        firebaseAuth = FirebaseAuth.getInstance();
        //buttonLogoutGoogle = findViewById(R.id.buttonLogoutGoogle);

        //Solicitar dados do usuário
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("505486870243-33hqdql0i988f5ffpnav9uv3vpht33u4.apps.googleusercontent.com")
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        // Login Google *//

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

            buttonProximo8.setEnabled( !email.isEmpty() && !senha1.isEmpty() && !senha2.isEmpty() );
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    //Concluir Cadastro
    public void autenticarUser(View v){
        String email = cadastroEmail.getText().toString();
        String senha = cadastroSenha.getText().toString();
        String senha2 = cadastroSenha2.getText().toString();

       if(senha.equals(senha2)) {
           FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                   .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){
                               Log.i("TesteCadastro", task.getResult().getUser().getUid());
                               salvarNoFirebase(/*teste.getText().toString()*/);
                           }
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(TelaCadastro8_Activity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
                           Log.i("TesteCadastro", e.getMessage());
                       }
                    });
       }else{
           Toast.makeText(TelaCadastro8_Activity.this, "Insira senhas iguais", Toast.LENGTH_SHORT).show();
           return;
       }


        //Intent intent = new Intent(this, Main_Activity.class);
        //startActivity(intent);
    }


    //Salvar usuário no firestore
    public void salvarNoFirebase(/*String teste*/){
        String id = FirebaseAuth.getInstance().getUid();
        //String testee = teste;

        user.setId(id);
        user.setSenha(cadastroSenha.getText().toString());
        //user.setTeste(testee);

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
                        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
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

    //Salvar usuário no firestore
    public void salvarNoFirebaseGoogle(/*String teste*/){
        String id = FirebaseAuth.getInstance().getUid();
        //String testee = teste;

        user.setId(id);
        //user.setSenha(cadastroSenha.getText().toString());
        //user.setTeste(testee);

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
                        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
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

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////// Criar conta com GOOGLE

    public void cadastroGoogle(View v){
        Intent intent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent, RESULT_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_SIGN_IN && resultCode == RESULT_OK){
            Log.d("teste", "t");
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            Log.d("teste", "t");
            handleSignInResult(task);
        }

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            //Toast.makeText(TelaCadastro8_Activity.this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
            Log.d("testeGoogleLogin", "Teste login");
            autenticarGoogle(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("testeErroGoogle", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(TelaCadastro8_Activity.this, "Login não realizado", Toast.LENGTH_SHORT).show();
            autenticarGoogle(null);
        }
    }

    private void autenticarGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("testeAutenticaçãoGoogle", "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            salvarNoFirebaseGoogle();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("testeAutenticaçãoGoogle", "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser user){
        //buttonLogoutGoogle.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account != null){
            String nameUser = account.getDisplayName();
            //Log.d("testeNome", nameUser);
            //Toast.makeText(TelaCadastro8_Activity.this, nameUser, Toast.LENGTH_SHORT).show();
        }
    }


}