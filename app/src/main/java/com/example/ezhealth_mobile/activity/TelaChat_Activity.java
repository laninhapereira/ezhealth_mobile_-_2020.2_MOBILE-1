package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.ExampleAdapterChat;

public class TelaChat_Activity extends AppCompatActivity {

    private ExampleAdapterChat mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_chat);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerViewChat);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mRecyclerView.setAdapter(new ExampleAdapterChat(
                // Construção do botão de Visualizar de cada item da lista
                nome -> {
                    Intent intent = new Intent(this, Main_Activity.class);
                    startActivity(intent);
                })
        );

    }


    public void voltarPerfil(View v){
        Intent intent = new Intent(this, Main_Activity.class );
        startActivity(intent);
    }

}