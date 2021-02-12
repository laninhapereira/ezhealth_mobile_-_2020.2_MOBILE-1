package com.example.ezhealth_mobile.content;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.activity.MainActivity;
import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.RecyclerViewAdapter;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class ContentFirstPanelInformation {

    public ContentFirstPanelInformation(AppCompatActivity appCompatActivity, String titlePanel, Class classEdicaoItem) {
        View view = appCompatActivity.getWindow().getDecorView();

        ((TextView)view.findViewById(R.id.textViewTitle)).setText(titlePanel);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(appCompatActivity, classEdicaoItem);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
