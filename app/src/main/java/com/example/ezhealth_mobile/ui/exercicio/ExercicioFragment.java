package com.example.ezhealth_mobile.ui.exercicio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.ActivityEditarAlimento;
import com.example.ezhealth_mobile.activity.ActivityEditarExercicio;
import com.example.ezhealth_mobile.activity.ActivityMain;
import com.example.ezhealth_mobile.content.ContentFirstPainelInformacoes;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.RepositoryObjectDefault;
import com.example.ezhealth_mobile.ui.exercicio.ExercicioViewModel;

public class ExercicioFragment extends Fragment {

    // Esse fragment corresponde a tela Exercícios criada na protótipação

    private ExercicioViewModel exercicioViewModel;
    private View viewFragment;
    private ViewGroup container;

    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        exercicioViewModel = new ViewModelProvider(this).get(ExercicioViewModel.class);
        viewFragment = inflater.inflate(R.layout.activity_dual_panel, container, false);

        exercicioViewModel.getText().observe(
            getViewLifecycleOwner(),
            new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {}
            }
        );

        this.container = container;

        popular();
        ((TextView) viewFragment.findViewById(R.id.textViewTitelDualPanel)).setText("Lista de Exercícios");
        this.configuraPrimeiroPainel();
        this.configuraSegundoPainel();

        return viewFragment;
    }

    private void configuraPrimeiroPainel(){

        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_panel_first_info, null);

        ConstraintLayout includeFirstPanel = (ConstraintLayout) viewFragment.findViewById(R.id.include);
        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(view);

        ((TextView) view.findViewById(R.id.textViewTituloPrimeiroPainel)).setText("Lista de Exercícios");

        // Classe para configuração do conteúdo do primeiro painel
        new ContentFirstPainelInformacoes(
                viewFragment,
                ActivityEditarAlimento.class,
                true
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
    public void salvar(View v){
        Intent intent = new Intent(container.getContext(), ActivityMain.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltar(View v){
        Intent intent = new Intent(container.getContext(), ActivityMain.class);
        startActivity(intent);
    }

    //Botão "add" para caso o usuário queria adicionar um novo item
    public void adicionar(View view){
        Intent intent = new Intent(container.getContext(), ActivityEditarExercicio.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Ainda será implementado
    }

    private void popular(){
        RepositoryObjectDefault.setTitleListItens("Exercicios da manhã");
        RepositoryObjectDefault.add(new ObjectDefault("Correr", "4", "Km", "400"));
        RepositoryObjectDefault.add(new ObjectDefault("Abdominal", "3", "Series", "300"));
    }


}
