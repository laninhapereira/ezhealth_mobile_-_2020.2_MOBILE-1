package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.entity.Usuario;
import com.example.ezhealth_mobile.util.ExampleAdapterChat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;
import com.xwray.groupie.ViewHolder;

import java.util.List;

public class TelaChat_Activity extends AppCompatActivity {

    private ExampleAdapterChat mAdapter;
    private GroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_chat);

        /*RecyclerView mRecyclerView = findViewById(R.id.recyclerViewChat);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        RecyclerView recyclerView = findViewById(R.id.recyclerViewChat);
        adapter = new GroupAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                Intent intent = new Intent(TelaChat_Activity.this, TelaChatConversas_Activity.class);

                //Enviar objeto para outra activity (Tela de conversa)
                UserItem userItem = (UserItem) item;
                intent.putExtra("user", userItem.user);

                startActivity(intent);
            }
        });

        //Buscar usuarios do firestore para povoar o chat
        buscarUsuarios();


        FloatingActionButton fab = findViewById(R.id.fabChat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pop up para buscar usuário e criar a tela de conversa", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /*mRecyclerView.setAdapter(new ExampleAdapterChat(
                // Construção do botão de Visualizar de cada item da lista
                nome -> {
                    Intent intent = new Intent(this, TelaChatConversas_Activity.class);
                    startActivity(intent);
                })
        );*/
    }


    private void buscarUsuarios() {
        FirebaseFirestore.getInstance().collection("/usuarios")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error != null){
                            Log.i("TesteBusca", error.getMessage(), error);
                            return;
                        }

                        //Elementos da lista de usuários
                        List<DocumentSnapshot> docs =  value.getDocuments();
                        for (DocumentSnapshot doc : docs){
                            Usuario user = doc.toObject(Usuario.class);
                            //Log.i("TesteBusca", user.getNomeCompleto());

                            if(!user.getId().equals(FirebaseAuth.getInstance().getUid())){
                                adapter.add(new UserItem(user));
                            }
                        }

                    }
                });
    }

    //Gerenciar itens do recycler view
    private class UserItem extends Item<ViewHolder> {

        private final Usuario user;

        private UserItem(Usuario user) {
            this.user = user;
        }

        @Override
        //Conectar itens para manipulá-los
        public void bind(@NonNull ViewHolder viewHolder, int position) {
            TextView txtNomeUser = viewHolder.itemView.findViewById(R.id.textViewChat);

            txtNomeUser.setText(user.getNomeCompleto());
        }

        @Override
        //Layout de cada item
        public int getLayout() {
            return R.layout.example_item_chat;
        }
    }


    public void voltarPerfil(View v){
        Intent intent = new Intent(this, Home_Activity.class );
        startActivity(intent);
    }

}