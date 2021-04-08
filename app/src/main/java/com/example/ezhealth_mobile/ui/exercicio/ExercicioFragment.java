package com.example.ezhealth_mobile.ui.exercicio;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.AdicionarExercicio_Activity;
import com.example.ezhealth_mobile.activity.EditarExercicio_Activity;
import com.example.ezhealth_mobile.activity.PopupNome;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;

public class ExercicioFragment extends Fragment {

    // Esse fragment corresponde a tela Exercícios criada na protótipação

    private View viewFragment;

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
    private TextView textViewTotal;
    private TextView textViewValorTotalKcal;
    private TextView textViewKcal4;

    private TextView textViewtextViewTitelDualPanel;
    private TextView textViewbuttonCheck;
    private TextView textViewtextViewDataDualPanel;
    private Button button;
    private ImageView imageViewButtonAdd;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ExercicioViewModel exercicioViewModel = new ViewModelProvider(this).get(ExercicioViewModel.class);

        viewFragment = inflater.inflate(R.layout.activity_dual_panel, container, false);

        textViewTituloSegundoPainel = viewFragment.findViewById(R.id.textViewTituloSegundoPainel);
        textViewPrimeiroItem = viewFragment.findViewById(R.id.textViewPrimeiroItem);
        textViewPrimeiroValor = viewFragment.findViewById(R.id.textViewPrimeiroValor);
        textViewPrimeiraMedida = viewFragment.findViewById(R.id.textViewPrimeiraMedida);
        textViewSegundoItem = viewFragment.findViewById(R.id.textViewSegundoItem);
        textViewSegundoValor = viewFragment.findViewById(R.id.textViewSegundoValor);
        textViewSegundaMedida = viewFragment.findViewById(R.id.textViewSegundaMedida);
        textViewTerceiroItem = viewFragment.findViewById(R.id.textViewTerceiroItem);
        textViewTerceiroValor = viewFragment.findViewById(R.id.textViewTerceiroValor);
        textViewTerceiraMedida = viewFragment.findViewById(R.id.textViewTerceiraMedida);
        textViewTotal = viewFragment.findViewById(R.id.textViewTotal);
        textViewValorTotalKcal = viewFragment.findViewById(R.id.textViewValorTotalKcal);
        textViewKcal4 = viewFragment.findViewById(R.id.textViewKcal4);

        textViewtextViewTitelDualPanel = viewFragment.findViewById(R.id.textViewTitelDualPanel);
        textViewbuttonCheck = viewFragment.findViewById(R.id.buttonCheck);
        textViewtextViewTitelDualPanel = viewFragment.findViewById(R.id.textViewTitelDualPanel);
        textViewtextViewDataDualPanel = viewFragment.findViewById(R.id.textViewDataDualPanel);
        button = viewFragment.findViewById(R.id.buttonVoltar);
//        imageViewButtonAdd = viewFragment.findViewById(R.id.imageViewButtonAdd);

        this.configuraFragment();
        this.configuraPrimeiroPainel();
//        this.configuraSegundoPainel();
        this.configuraBotoes();

        return viewFragment;
    }

    private void configuraFragment(){
        button.setVisibility(View.INVISIBLE);
        textViewtextViewTitelDualPanel.setText("Lista de Exercícios");
        textViewbuttonCheck.setVisibility(View.INVISIBLE);
        textViewtextViewTitelDualPanel.setPadding(53,0,0,0);
        textViewtextViewDataDualPanel.setPadding(53,0,0,0);
    }

    private void configuraPrimeiroPainel(){
        // Classe para configuração do conteúdo do primeiro painel
//        PainelInformacoes_Content.configura(
//            "Exercícios",
//                viewFragment,
//            true,
//                new ExampleAdapterObjectDefault(
//                        true,
//                        Exercicio_Repositorio.getInstance().popular(),
//                        (nome) -> { // Construção do botão de EDITAR de cada item da lista
//                            Intent intent = new Intent(this.getContext(), EditarExercicio_Activity.class);
//                            intent.putExtra("EXERCICIO", (Exercicio) nome);
//                            startActivity(intent);
//                        },
//                        (nome) -> {
//                            Dialog dialogEditarNome = PopupNome.configuraPopup(getActivity(), "exercício", nomeAtualizado -> {
////                                salvarNomeEditado(nomeAtualizado);
//                            });
//                            EditText editText = dialogEditarNome.findViewById(R.id.editTextPopupNome);
//                            editText.setText("");
//                            dialogEditarNome.show();
//                        },
//                        nome -> { // Construção do botão de EXCLUIR de cada item da lista
//                        }
//                )
//        );
    }

    private void salvarNomeEditado(String nome){
        // Ainda deverá ser contruida
    }


    // Classe para configuração do conteúdo do segundo painel
//    private void configuraSegundoPainel(){
//        textViewTituloSegundoPainel.setText("Informações gerais");
//        textViewPrimeiroValor.setText(String.valueOf(Exercicio_Repositorio.getInstance().getQuantidadeTotais()));
//        textViewPrimeiroItem.setText("Duração");
//        textViewPrimeiraMedida.setText("min");
//
//        textViewSegundoItem.setText("Calorias Perdidas");
//        textViewSegundoValor.setText(String.valueOf(Exercicio_Repositorio.getInstance().getCaloriasTotais()));
//        textViewSegundaMedida.setText("kcal");
//
//        textViewTerceiroItem.setText("");
//        textViewTerceiroValor.setText("");
//        textViewTerceiraMedida.setText("");
//
//        textViewTotal.setText("");
//        textViewValorTotalKcal.setText("");
//        textViewKcal4.setText("");
//    }

    public void configuraBotoes(){
        textViewbuttonCheck.setOnClickListener(v1 -> getActivity().finish());
        imageViewButtonAdd.setOnClickListener(v1 ->
                startActivity(new Intent(getContext(), AdicionarExercicio_Activity.class)));
    }

}
