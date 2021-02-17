package com.example.ezhealth_mobile.ui.exercicio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.AdicionarExercicio_Activity;
import com.example.ezhealth_mobile.activity.EditarAlimento_Activity;
import com.example.ezhealth_mobile.activity.EditarExercicio_Activity;
import com.example.ezhealth_mobile.activity.Home_Activity;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;
import com.example.ezhealth_mobile.util.OnClickListenerAdapter;

public class ExercicioFragment extends Fragment {

    // Esse fragment corresponde a tela Exercícios criada na protótipação

    private View viewFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        ExercicioViewModel exercicioViewModel = new ViewModelProvider(this).get(ExercicioViewModel.class);

        viewFragment = inflater.inflate(R.layout.activity_dual_panel, container, false);

        ((TextView) viewFragment.findViewById(R.id.textViewTitelDualPanel)).setText("Lista de Exercícios");
        ((TextView) viewFragment.findViewById(R.id.textViewTitelDualPanel)).setPadding(53,0,0,0);
        ((TextView) viewFragment.findViewById(R.id.textViewDataDualPanel)).setPadding(53,0,0,0);
        ((Button) viewFragment.findViewById(R.id.buttonVoltar)).setVisibility(View.INVISIBLE);

        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();
        this.setOnClickSalvar();
        this.setOnClickAdicionar();
        return viewFragment;
    }

    private void configuraPrimeiroPainel(){
        // Classe para configuração do conteúdo do primeiro painel
        new PainelInformacoes_Content(
            "Exercicio 1",
                viewFragment,
            true,
                new ExampleAdapterObjectDefault(
                        true,
                        Exercicio_Repositorio.getInstance(),
                        (nome) -> { // Construção do botão de EDITAR de cada item da lista
                            Intent intent = new Intent(this.getContext(), EditarExercicio_Activity.class);
                            intent.putExtra("EXERCICIO", nome);
                            startActivity(intent);
                        },
                        (nome) -> { // Construção do botão de EXCLUIR de cada item da lista
                        }
                )
        );
    }

    // Classe para configuração do conteúdo do segundo painel
    private void configuraSegundoPainel(){
        ((TextView) viewFragment.findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) viewFragment.findViewById(R.id.textViewPrimeiroItem)).setText("Tempo");
        ((TextView) viewFragment.findViewById(R.id.textViewPrimeiroValor)).setText("5");
        ((TextView) viewFragment.findViewById(R.id.textViewPrimeiraMedida)).setText("h");

        ((TextView) viewFragment.findViewById(R.id.textViewSegundoItem)).setText("Quantidade");
        ((TextView) viewFragment.findViewById(R.id.textViewSegundoValor)).setText("1");
        ((TextView) viewFragment.findViewById(R.id.textViewSegundaMedida)).setText("");

        ((TextView) viewFragment.findViewById(R.id.textViewTerceiroItem)).setText("");
        ((TextView) viewFragment.findViewById(R.id.textViewTerceiroValor)).setText("");
        ((TextView) viewFragment.findViewById(R.id.textViewTerceiraMedida)).setText("");

        ((TextView) viewFragment.findViewById(R.id.textViewValorTotalKcal)).setText("700");
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void setOnClickSalvar(){
        ((Button) viewFragment.findViewById(R.id.buttonCheck)).setOnClickListener(v1 -> {
            Intent intent = new Intent(getContext(), Home_Activity.class);
            intent.putExtra("fragment", "diario");
            startActivity(intent);
        });
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void setOnClickAdicionar(){
        ((ImageView) viewFragment.findViewById(R.id.imageViewButtonAdd)).setOnClickListener(v1 -> {
            Intent intent = new Intent(getContext(), AdicionarExercicio_Activity.class);
            startActivity(intent);
        });
    }

}
