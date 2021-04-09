package com.example.ezhealth_mobile.ui.diario;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.EditarRefeicao_Activity;
import com.example.ezhealth_mobile.activity.Main_Activity;
import com.example.ezhealth_mobile.dao.RefeicaoDAO;
import com.example.ezhealth_mobile.entity.Alimento;
import com.example.ezhealth_mobile.entity.Refeicao;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DiarioFragment extends Fragment {

    private View root;
    private static Integer caloriaisConsumidas;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_diario, container, false);
        caloriaisConsumidas = 0;
        buscarRefeicoesDiarias();
        //Verificar se o usuário está logado para continuar no app ou voltar para login
        Intent intent = new Intent(root.getRootView().getContext(), Main_Activity.class);
        verificarAutenticacao(intent);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        caloriaisConsumidas = 0;
        buscarRefeicoesDiarias();

    }

    private void verificarAutenticacao(Intent intent) {
        if(FirebaseAuth.getInstance().getUid() == null){
            //Fazer que activity seja a principal
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void buscarRefeicoesDiarias(){
        RefeicaoDAO
            .getInstance()
            .getRefeicoesDiarias(
                refeicao -> {
                    configuraBotoes(refeicao);
                    caloriaisConsumidas =+ refeicao.getCalorias();
                }
            );
        configurarPainelCalorias();
    }

    private void configuraBotoes(Refeicao refeicao){
        Intent intent = new Intent(this.getContext(), EditarRefeicao_Activity.class);

        switch (refeicao.getNome()){
            case "Café da Manhã":
                configurarCafeManha(refeicao, intent);
                break;
            case "Lanche da Manhã":
                configurarLancheManha(refeicao, intent);
                break;
            case "Almoço":
                configurarAlmoco(refeicao, intent);
                break;
            case "Lanche da Tarde":
                configurarLancheTarde(refeicao, intent);
                break;
            case "Jantar":
                configurarJantar(refeicao, intent);
                break;
        }

    }

    private void configurarPainelCalorias(){
        TextView consumidos = root.findViewById(R.id.textViewFragmentKcalConsumidosValor);
        TextView consumir = root.findViewById(R.id.textViewFragmentKcalConsumirValor);


    }

    private void configurarCafeManha(Refeicao refeicao, Intent intent){
        TextView txtKcal = (TextView) root.findViewById(R.id.textViewItemPainelValorKcalCafe);
        ImageView buttonAdd = root.findViewById(R.id.imageViewItemPanelAddCafe);

        caloriaisConsumidas += refeicao.getCalorias();
        txtKcal.setText(String.valueOf(refeicao.getCalorias()));
        buttonAdd.setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO", refeicao);
                    startActivity(intent);
                }
        );
    }

    private void configurarLancheManha(Refeicao refeicao, Intent intent){
        TextView txtKcal = (TextView) root.findViewById(R.id.textViewItemPainelValorKcalLancheManha);
        ImageView buttonAdd = root.findViewById(R.id.imageViewItemPanelAddLancheManha);

        caloriaisConsumidas += refeicao.getCalorias();
        txtKcal.setText(String.valueOf(refeicao.getCalorias()));
        buttonAdd.setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO", refeicao);
                    startActivity(intent);
                }
        );
    }

    private void configurarAlmoco(Refeicao refeicao, Intent intent){
        TextView txtKcal = (TextView) root.findViewById(R.id.textViewItemPainelValorKcalAlmoco);
        ImageView buttonAdd = root.findViewById(R.id.imageViewItemPanelAddAlmoco);

        caloriaisConsumidas += refeicao.getCalorias();
        txtKcal.setText(String.valueOf(refeicao.getCalorias()));
        buttonAdd.setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO", refeicao);
                    startActivity(intent);
                }
        );
    }

    private void configurarLancheTarde(Refeicao refeicao, Intent intent){
        TextView txtKcal = (TextView) root.findViewById(R.id.textViewItemPainelValorKcalLancheTarde);
        ImageView buttonAdd = root.findViewById(R.id.imageViewItemPanelAddLancheTarde);

        caloriaisConsumidas += refeicao.getCalorias();
        txtKcal.setText(String.valueOf(refeicao.getCalorias()));
        buttonAdd.setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO", refeicao);
                    startActivity(intent);
                }
        );
    }

    private void configurarJantar(Refeicao refeicao, Intent intent){
        TextView txtKcal = (TextView) root.findViewById(R.id.textViewItemPainelValorKcalJantar);
        ImageView buttonAdd = root.findViewById(R.id.imageViewItemPanelAddJantar);

        caloriaisConsumidas += refeicao.getCalorias();
        txtKcal.setText(String.valueOf(refeicao.getCalorias()));
        buttonAdd.setOnClickListener(
                v -> {
                    intent.putExtra("REFEICAO", refeicao);
                    startActivity(intent);
                }
        );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        onResume();
    }

}