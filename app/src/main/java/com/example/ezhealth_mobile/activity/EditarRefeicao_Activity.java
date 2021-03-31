package com.example.ezhealth_mobile.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;
import com.example.ezhealth_mobile.util.OnClickListenerAdapter;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private int EDITAR_ACTIVITY = 0;
    private Refeicao refeicao;
    private Dialog dialogEditarNome;

    private TextView textViewTituloSegundoPainel;
    private TextView textViewPrimeiroItem;
    private TextView textViewPrimeiroValor;
    private TextView textViewPrimeiraMedida;
    private TextView textViewSegundoItem;
    private TextView textViewSegundoValor;
    private TextView textViewSegundaMedida;
    private TextView textViewTerceiroItem;
    private TextView textViewTerceiroValor;
    private TextView textViewTerceiraMedida;
    private TextView textViewValorTotalKcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        textViewTituloSegundoPainel = findViewById(R.id.textViewTituloSegundoPainel);
        textViewPrimeiroItem = findViewById(R.id.textViewPrimeiroItem);
        textViewPrimeiroValor = findViewById(R.id.textViewPrimeiroValor);
        textViewPrimeiraMedida = findViewById(R.id.textViewPrimeiraMedida);
        textViewSegundoItem = findViewById(R.id.textViewSegundoItem);
        textViewSegundoValor = findViewById(R.id.textViewSegundoValor);
        textViewSegundaMedida = findViewById(R.id.textViewSegundaMedida);
        textViewTerceiroItem = findViewById(R.id.textViewTerceiroItem);
        textViewTerceiroValor = findViewById(R.id.textViewTerceiroValor);
        textViewTerceiraMedida = findViewById(R.id.textViewTerceiraMedida);
        textViewValorTotalKcal = findViewById(R.id.textViewValorTotalKcal);

        configuraPopup();
    }

    @Override
    public void onResume(){ // escreva esse método na act1
        super.onResume();

        procurarRefeicao();
        if(refeicao==null)
            Log.e("aaaaaaaaaaaaa_", "onResume: deu errado" );
        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText(refeicao.getNome());

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void configuraPopup(){
        dialogEditarNome = PopupNome.configuraPopup(this, "alimento", nome -> {
            salvarNomeEditado((String) nome);
        });;
    }

    private void procurarRefeicao(){
        Intent intent = getIntent();

        Boolean novo = (intent == null)? false : getIntent().getBooleanExtra("REFEICAO_NOVA", false);

        if(novo){
            String nome = getIntent().getStringExtra("REFEICAO_NOVA_NOME");
            refeicao = new Refeicao( nome, 0, "g", 0, "0");
            return;
        }

        String nome = (intent == null)? null : getIntent().getStringExtra("REFEICAO");

        if(nome == null) {
            Toast.makeText(this, "Refeição não encontrada", Toast.LENGTH_LONG).show();
            return;
        }
        refeicao = (Refeicao) Refeicao_Repositorio.getInstance().getItemList(nome);
        if(refeicao == null) {
            Toast.makeText(this, "Refeição não encontrada", Toast.LENGTH_LONG).show();
            return;
        }
        Log.d("Refeicao: ", refeicao.getNome());
    }

    @SuppressLint("WrongViewCast")
    private void configuraPrimeiroPainel(){

        ExampleAdapterObjectDefault exampleAdapterObjectDefault = new ExampleAdapterObjectDefault(
                true,
                refeicao.getRepAlimentos().getList(),
                alimento -> { // Construção do botão de EDITAR de cada item da lista
                    Intent intent = new Intent(this, EditarAlimento_Activity.class);
                    intent.putExtra("ALIMENTO", (Alimento) alimento);
                    this.startActivityForResult(intent, 0);
                },
                alimento -> { // Construção do botão de EDITAR NOME de cada item da lista
                    ((EditText) dialogEditarNome.findViewById(R.id.editTextPopupNome)).setText("");
                    dialogEditarNome.show();
                }, alimento -> { // Construção do botão de EXCLUIR de cada item da lista

                }
        );
        PainelInformacoes_Content.configura("Alimentos", getWindow().getDecorView(),
                true, exampleAdapterObjectDefault);

        ((ImageView) findViewById(R.id.imageViewButtonAdd)).setOnClickListener(
                v -> {
                    Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                    startActivityForResult(intent, EDITAR_ACTIVITY);
                }
        );
    }

    private void salvarNomeEditado(String nome){
        // Ainda deverá ser contruida
    }

    private void configuraSegundoPainel(){
        textViewTituloSegundoPainel.setText("Informações gerais");

        textViewPrimeiroItem.setText("Carboidratos");
        textViewPrimeiroValor.setText(String.valueOf(refeicao.getCarboidratos()));
        textViewPrimeiraMedida.setText("g");

        textViewSegundoItem.setText("Proteinas");
        textViewSegundoValor.setText(String.valueOf(refeicao.getProteinas()));
        textViewSegundaMedida.setText("g");

        textViewTerceiroItem.setText("Gorduras");
        textViewTerceiroValor.setText(String.valueOf(refeicao.getGorduras()));
        textViewTerceiraMedida.setText("g");

        textViewValorTotalKcal.setText(String.valueOf(refeicao.getCalorias()));
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        setResult(RESULT_OK);
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDITAR_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                Alimento alimento = getIntent().getExtras().getParcelable("SALVO");

                refeicao.getRepAlimentos().setItemList(alimento.getNome(), alimento);
                Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
