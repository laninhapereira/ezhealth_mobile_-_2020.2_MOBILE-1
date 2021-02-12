package com.example.ezhealth_mobile.activity;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ezhealth_mobile.content.ContentFirstPanelInformation;
import com.example.ezhealth_mobile.content.ContentFirstPanelQuantity;
import com.example.ezhealth_mobile.content.ContentPanel;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.R;

import java.util.ArrayList;

public class DualPanelActivity extends AppCompatActivity {

    ContentPanel contentPanel;
    ConstraintLayout includeFirstPanel;
    ArrayList<ObjectDefault> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_panel);

        includeFirstPanel = (ConstraintLayout) findViewById(R.id.include);

        list = new ArrayList<ObjectDefault>();
        list.add(new ObjectDefault("Laranja", "5", null, "120"));
        list.add(new ObjectDefault("Maça", "4", null, "100"));
        list.add(new ObjectDefault("Uva", "3", null, "80"));
        list.add(new ObjectDefault("Coca-Cola", "500", "ml", "120"));
        list.add(new ObjectDefault("Pedaço de Pizza", "2", null, "500"));

        this.selectFirstTypePanel("information" , "Café da manhã");
    }

    /* Function: selectFirstTypePanel
    *  Description: This funcion work for switching the first panel between "information panel" and "quantity panel"
    */
    public void selectFirstTypePanel(String type, String titlePanel){
        switch (type){
            case "quantity":
                this.setFirstPanel(R.layout.content_panel_first_quant);
                contentPanel = new ContentFirstPanelQuantity(getWindow().getDecorView(), titlePanel, list.get(0));
                break;
            case "information":
                this.setFirstPanel(R.layout.content_panel_first_info);
                contentPanel = new ContentFirstPanelInformation(getWindow().getDecorView(), titlePanel, list);
                ((ContentFirstPanelInformation)contentPanel).setOnListernButtonAdd(v->{
                    Log.d("teste", "selectFirstTypePanel: ");
                });
                break;
        }
    }


    /* Function: setFirstPanel
    *  Description: The first panel can be used to display information or receive quantities
    */
    private void setFirstPanel(@LayoutRes int layoutId){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(layoutId, null);

        includeFirstPanel.removeAllViews();
        includeFirstPanel.addView(layout);
    }

    //Botão "check" para confirmar que o usuário já adicionou os alimentos/refeições desejados
    public void check_Alimento_refeição(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Botão "voltar" para caso o usuário desista e volte para a tela anterior
    public void voltarListaAlimentos(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}