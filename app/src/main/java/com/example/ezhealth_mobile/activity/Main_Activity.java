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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Main_Activity extends AppCompatActivity {

    private EditText loginEmail, loginSenha;
    private Button loginButton;

    //Login Google
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth firebaseAuth;
    private Button buttonLogoutGoogle;
    private int RESULT_SIGN_IN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* Confirmar se todos os campos estão preenchidos //
        loginEmail = findViewById(R.id.editTextEmailLogin);
        loginSenha = findViewById(R.id.editTextSenhaLogin);
        loginButton = findViewById(R.id.buttonLogin);
        loginButton.setEnabled(false);

        loginEmail.addTextChangedListener(loginTextWatcher);
        loginSenha.addTextChangedListener(loginTextWatcher);
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
        //Testar se email e senha existem e ir para Home  //
        //------------------------------------------------//

        autenticarUsuario(loginEmail.getText().toString() , loginSenha.getText().toString());

        //Intent intent = new Intent(this, Maps_Activity.class);
        //startActivity(intent);

        //Intent intent = new Intent(this, AdicionarExercicioActivity.class);
        //startActivity(intent);

    }

    public void cadastrarUsuario(View v){
        Intent intent = new Intent(this, TelaCadastro1_Activity.class);
        startActivity(intent);
    }


    //Autenticar usuário no firestore
    public void autenticarUsuario(String email , String senha){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //String uuid = task.getResult().getUser().getUid();
                    //Log.i("testeAutenticação", uuid);

                    Intent intent = new Intent(Main_Activity.this, Home_Activity.class);
                    //Fazer que activity seja a principal
                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Main_Activity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
                    Log.i("testeAutenticação", e.getMessage());
                }
            });
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////// Criar conta com GOOGLE

    public void loginGoogle(View v){
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
            //Toast.makeText(Main_Activity.this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
            Log.d("testeGoogleLogin", "Teste login");
            autenticarGoogle(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("testeErroGoogle", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(Main_Activity.this, "Login não realizado", Toast.LENGTH_SHORT).show();
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
                            updateUI(user);

                            Intent intent = new Intent(Main_Activity.this, Home_Activity.class);
                            //Fazer que activity seja a principal
                            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

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
            //Toast.makeText(Main_Activity.this, nameUser, Toast.LENGTH_SHORT).show();
        }
    }

}