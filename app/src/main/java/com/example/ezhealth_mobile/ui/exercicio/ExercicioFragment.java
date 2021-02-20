package com.example.ezhealth_mobile.ui.exercicio;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.ezhealth_mobile.activity.PopupNome;
import com.example.ezhealth_mobile.content.PainelInformacoes_Content;
import com.example.ezhealth_mobile.entity.Exercicio;
import com.example.ezhealth_mobile.entity.Exercicio_Repositorio;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;
import com.example.ezhealth_mobile.util.ExampleAdapterObjectDefault;
import com.example.ezhealth_mobile.util.OnClickListenerAdapter;

public class ExercicioFragment extends Fragment {

    // Esse fragment corresponde a tela Exercícios criada na protótipação

    private Dialog dialogEditarNome;
    private View viewFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ExercicioViewModel exercicioViewModel = new ViewModelProvider(this).get(ExercicioViewModel.class);

        viewFragment = inflater.inflate(R.layout.activity_dual_panel, container, false);

        dialogEditarNome = configuraPopupEditarNome();

        ((TextView) viewFragment.findViewById(R.id.textViewTitelDualPanel)).setText("Lista de Exercícios");
        ((TextView) viewFragment.findViewById(R.id.buttonCheck)).setVisibility(View.INVISIBLE);
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
        PainelInformacoes_Content.configura(
            "Exercícios",
                viewFragment,
            true,
                new ExampleAdapterObjectDefault(
                        true,
                        Exercicio_Repositorio.getInstance().popular(),
                        (nome) -> { // Construção do botão de EDITAR de cada item da lista
                            Intent intent = new Intent(this.getContext(), EditarExercicio_Activity.class);
                            intent.putExtra("EXERCICIO", nome);
                            startActivity(intent);
                        },
                        (nome) -> {
                            ((EditText)dialogEditarNome.findViewById(R.id.editTextPopupNome)).setText("");
                            dialogEditarNome.show();
                        },
                        nome -> { // Construção do botão de EXCLUIR de cada item da lista
                        }
                )
        );
    }

    public Dialog configuraPopupEditarNome(){
        TextView textView;
        Dialog dialog;

        dialog = new Dialog(getActivity(), R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);
        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        textView = ((EditText)dialog.findViewById(R.id.editTextPopupNome));
        textView.setHint("Digite o nome da exercício");

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            dialog.dismiss();
            salvarNomeEditado(textView.getText().toString());
        });

        return dialog;
    }

    private void salvarNomeEditado(String nome){
        // Ainda deverá ser contruida
    }

    // Classe para configuração do conteúdo do segundo painel
    private void configuraSegundoPainel(){
        ((TextView) viewFragment.findViewById(R.id.textViewTituloSegundoPainel)).setText("Informações gerais");

        ((TextView) viewFragment.findViewById(R.id.textViewPrimeiroItem)).setText("Duração");
        ((TextView) viewFragment.findViewById(R.id.textViewPrimeiroValor)).setText(Exercicio_Repositorio.getInstance().getQuantidadeTotais());
        ((TextView) viewFragment.findViewById(R.id.textViewPrimeiraMedida)).setText("min");

        ((TextView) viewFragment.findViewById(R.id.textViewSegundoItem)).setText("Calorias Perdidas");
        ((TextView) viewFragment.findViewById(R.id.textViewSegundoValor)).setText(Exercicio_Repositorio.getInstance().getCaloriasTotais());
        ((TextView) viewFragment.findViewById(R.id.textViewSegundaMedida)).setText("kcal");

        ((TextView) viewFragment.findViewById(R.id.textViewTerceiroItem)).setText("");
        ((TextView) viewFragment.findViewById(R.id.textViewTerceiroValor)).setText("");
        ((TextView) viewFragment.findViewById(R.id.textViewTerceiraMedida)).setText("");

        ((TextView) viewFragment.findViewById(R.id.textViewTotal)).setText("");
        ((TextView) viewFragment.findViewById(R.id.textViewValorTotalKcal)).setText("");
        ((TextView) viewFragment.findViewById(R.id.textViewKcal4)).setText("");
    }

    //Botão "check" para confirmar que o usuário deseja salvar os itens
    public void setOnClickSalvar(){
        ((Button) viewFragment.findViewById(R.id.buttonCheck)).setOnClickListener(v1 -> {
            getActivity().finish();
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
