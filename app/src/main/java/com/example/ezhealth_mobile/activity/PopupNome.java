package com.example.ezhealth_mobile.activity;

import android.app.Activity;
import android.app.Dialog;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.OnClickListenerAdapter;

public class PopupNome {

    public static Dialog configuraPopup(Activity activity, String tipo, OnClickListenerAdapter<String> onclick){
        TextView textView;
        Dialog dialog;

        dialog = new Dialog(activity, R.style.PopupDialog );
        dialog.setContentView(R.layout.popup_nome);
        dialog.findViewById(R.id.button_popup_voltar).setOnClickListener( v -> {
            dialog.dismiss();
        });

        textView = ((EditText)dialog.findViewById(R.id.editTextPopupNome));
        textView.setHint("Digite o nome do "+tipo);

        dialog.findViewById(R.id.button_popup_continuar).setOnClickListener(v -> {
            if(textView.getText().toString().equals("")) {
                Toast.makeText(activity, "Digite o nome do "+tipo, Toast.LENGTH_SHORT).show();
                return;
            }
            dialog.dismiss();
            onclick.OnClick(textView.getText().toString());
        });

        return dialog;
    }

}
