package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.ExampleAdapterChat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TelaChat_Activity extends AppCompatActivity {

    private ExampleAdapterChat mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_chat);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerViewChat);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fabChat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pop up para buscar usuário e criar a tela de conversa", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mRecyclerView.setAdapter(new ExampleAdapterChat(
                // Construção do botão de Visualizar de cada item da lista
                nome -> {
                    Intent intent = new Intent(this, TelaChatConversas_Activity.class);
                    startActivity(intent);
                })
        );

    }


    public void voltarPerfil(View v){
        Intent intent = new Intent(this, Main_Activity.class );
        startActivity(intent);
    }

}