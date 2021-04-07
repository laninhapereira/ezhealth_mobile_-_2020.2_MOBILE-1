package com.example.ezhealth_mobile.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;
import com.example.ezhealth_mobile.util.OnClickListenerAdapter;

import java.util.ArrayList;

public class EditarRefeicao_Activity extends AppCompatActivity {

    private int EDITAR_ACTIVITY = 0;
    private Refeicao refeicao;
    private Dialog dialogEditarNome;

    private TextView textViewTitelDualPanel;
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
    private ImageView imageViewButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        textViewTitelDualPanel = findViewById(R.id.textViewTitelDualPanel);
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
        imageViewButtonAdd = findViewById(R.id.imageViewButtonAdd);

        procurarRefeicao();
//        configuraPopup();
    }

    @Override
    public void onResume(){ // escreva esse método na act1
        super.onResume();

        procurarRefeicao();
        textViewTitelDualPanel.setText(refeicao.getNome());

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

//    private void configuraPopup(){
//
//    }

    private void procurarRefeicao(){
        refeicao = (Refeicao) getIntent().getSerializableExtra("REFEICAO");

        if(refeicao == null) {
            refeicao = new Refeicao();
            refeicao.setListAlimentos(new ArrayList<>());
        }
    }

    @SuppressLint("WrongViewCast")
    private void configuraPrimeiroPainel(){
        OnClickListenerAdapter botaoEditar;
        OnClickListenerAdapter botaoEditarNome;
        OnClickListenerAdapter botaoExcluir;
        ExampleAdapterObjectDefault exampleAdapterObjectDefault;
        ImageView buttonAdd = (ImageView) findViewById(R.id.imageViewButtonAdd);

        buttonAdd.setOnClickListener(
                v -> {
                    Intent intent = new Intent(this, AdicionarAlimentoRefeicao_Activity.class);
                    startActivityForResult(intent, EDITAR_ACTIVITY);
                }
        );

        botaoEditar = alimento -> {
            Intent intent = new Intent(this, EditarAlimento_Activity.class);
            intent.putExtra("ALIMENTO", (Alimento) alimento);
            this.startActivityForResult(intent, 0);
        };

        botaoEditarNome = alimento -> {
            dialogEditarNome = PopupNome.configuraPopup(this, "alimento", nome -> {
                ((Alimento) alimento).setNome(nome);
                onResume();
            });

            EditText textPopupNome = dialogEditarNome.findViewById(R.id.editTextPopupNome);
            textPopupNome.setText("");

            dialogEditarNome.show();
        };

        botaoExcluir = alimento -> {
            refeicao.getListAlimentos().remove(alimento);
            onResume();
        };

        exampleAdapterObjectDefault = new ExampleAdapterObjectDefault(
                true,
                refeicao.getListAlimentos(),
                botaoEditar,
                botaoEditarNome,
                botaoExcluir
        );

        PainelInformacoes_Content.configura(
                "Alimentos",
                getWindow().getDecorView(),
                true,
                exampleAdapterObjectDefault
        );

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
        imageViewButtonAdd.setOnClickListener(v1 -> {
            Intent intent = new Intent();
            intent.putExtra("SALVO", refeicao);

            setResult(RESULT_OK);
            finish();
        });
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDITAR_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                Alimento alimento = (Alimento) data.getSerializableExtra("ALIMENTO");
                refeicao.getListAlimentos().set(alimento.getPosition(), alimento);
                onResume();
            }
        }

    }

}
