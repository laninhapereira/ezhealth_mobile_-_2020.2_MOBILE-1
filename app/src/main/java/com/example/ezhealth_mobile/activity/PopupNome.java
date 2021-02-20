package com.example.ezhealth_mobile.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.ezhealth_mobile.R;

public class PopupNome {
/*
     public static Dialog configuraPopup(Activity activity, String gatilho, String idTextoRecebido){
        Dialog dialog;
        dialog = new Dialog(activity, R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);

        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(activity, EditarAlimento_Activity.class);
            intent.putExtra(gatilho, true);
            String nome = ((EditText)dialog.findViewById(R.id.editTextPopupNome)).getText().toString();
            intent.putExtra(idTextoRecebido, nome);
            activity.startActivity(intent);
        });
        return dialog;
    }*/

}
