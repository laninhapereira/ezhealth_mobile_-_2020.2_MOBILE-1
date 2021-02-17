package com.example.ezhealth_mobile.ui.diario;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.entity.Refeicao_Repositorio;

public class DiarioFragment extends Fragment {

    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DiarioViewModel diarioViewModel = new ViewModelProvider(this).get(DiarioViewModel.class);

        root = inflater.inflate(R.layout.fragment_diario, container, false);
        diarioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        configuraBotoes();
        return root;
    }

    private void configuraBotoes(){
        Intent intent = new Intent(this.getContext(), EditarRefeicao_Activity.class);
        ((TextView)root.findViewById(R.id.textViewItemPainelValorKcalCafe)).
                setText(Refeicao_Repositorio.getInstance().getRefeicoesDiarias().get(0).getCalorias());
        root.findViewById(R.id.imageViewItemPanelAddCafe).setOnClickListener(
            v -> {
                intent.putExtra("REFEICAO","Café da manhã");
                startActivity(intent);
            }
        );
        ((TextView)root.findViewById(R.id.textViewItemPainelValorKcalLancheManha)).
                setText(Refeicao_Repositorio.getInstance().getRefeicoesDiarias().get(1).getCalorias());
        root.findViewById(R.id.imageViewItemPanelAddLancheManha).setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO","Lanche da Manhã");
                    startActivity(intent);
                }
        );
        ((TextView)root.findViewById(R.id.textViewItemPainelValorKcalAlmoco)).
                setText(Refeicao_Repositorio.getInstance().getRefeicoesDiarias().get(2).getCalorias());
        root.findViewById(R.id.imageViewItemPanelAddAlmoco).setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO","Almoço");
                    startActivity(intent);
                }
        );
        ((TextView)root.findViewById(R.id.textViewItemPainelValorKcalLancheTarde)).
                setText(Refeicao_Repositorio.getInstance().getRefeicoesDiarias().get(3).getCalorias());
        root.findViewById(R.id.imageViewItemPanelAddLancheTarde).setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO","Lanche da Tarde");
                    startActivity(intent);
                }
        );
        ((TextView)root.findViewById(R.id.textViewItemPainelValorKcalJantar)).
                setText(Refeicao_Repositorio.getInstance().getRefeicoesDiarias().get(4).getCalorias());
        root.findViewById(R.id.imageViewItemPanelAddJantar).setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO","Jantar");
                    startActivity(intent);
                }
        );
    }

}