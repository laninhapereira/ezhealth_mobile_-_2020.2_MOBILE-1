package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.content.PainelQuantidades_Content;
import com.example.ezhealth_mobile.entity.Alimento;

public class EditarAlimento_Activity extends AppCompatActivity {

    private Alimento alimento;

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
    private PainelQuantidades_Content painelQuantidades_content;

    private TextView textViewEditTextQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        ((TextView) findViewById(R.id.textViewTitelDualPanel)).setText("Editar Alimento");

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
        textViewEditTextQtd = findViewById(R.id.editTextQtd);

        this.procurar();
        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
    }

    private void configuraPrimeiroPainel(){
        painelQuantidades_content = new PainelQuantidades_Content(this);
        painelQuantidades_content.configurarPainel(alimento);
    }

    private void configuraSegundoPainel(){
        textViewTituloSegundoPainel.setText("Informações gerais");

        textViewPrimeiroItem.setText("Carboidratos");
        textViewPrimeiroValor.setText(String.valueOf(alimento.getCarboidratos()));
        textViewPrimeiraMedida.setText("g");

        textViewSegundoItem.setText("Proteinas");
        textViewSegundoValor.setText(String.valueOf(alimento.getProteinas()));
        textViewSegundaMedida.setText("g");

        textViewTerceiroItem.setText("Gorduras");
        textViewTerceiroValor.setText(String.valueOf(alimento.getGorduras()));
        textViewTerceiraMedida.setText("g");

        textViewValorTotalKcal.setText(String.valueOf(alimento.getCalorias()));
    }

    public void procurar(){
        alimento = (Alimento) getIntent().getSerializableExtra("ALIMENTO");
        if(alimento == null) alimento = new Alimento();
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void salvar(View v){
        String quantidade = painelQuantidades_content.getQuantidade();
        alimento.setQuantidade(Integer.parseInt(quantidade));

        Intent intent = new Intent();
        intent.putExtra("ALIMENTO", alimento);
        setResult(RESULT_OK, intent);
        finish();
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        setResult(RESULT_CANCELED, null);
        finish();
    }

}
