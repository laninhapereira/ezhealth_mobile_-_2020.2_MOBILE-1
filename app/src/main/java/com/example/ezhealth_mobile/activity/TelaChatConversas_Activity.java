package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezhealth_mobile.R;

public class TelaChatConversas_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_chat_conversas);
    }

    public void voltarTelaChat(View v){
        Intent intent = new Intent(this, TelaChat_Activity.class );
        startActivity(intent);
    }

}