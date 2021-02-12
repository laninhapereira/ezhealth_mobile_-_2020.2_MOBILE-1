package com.example.ezhealth_mobile.content;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.util.RecyclerViewAdapter;

public class ContentFirstPanelInformation {

    public ContentFirstPanelInformation(AppCompatActivity appCompatActivity, String titlePanel, Class classEdicaoItem) {
        View view = appCompatActivity.getWindow().getDecorView();

        ((TextView)view.findViewById(R.id.textViewTitlePanel)).setText(titlePanel);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(appCompatActivity, classEdicaoItem);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
