package com.example.ezhealth_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ezhealth_mobile.R;
import com.example.ezhealth_mobile.activity.ui.main.SectionsPagerAdapterRelatorio;
import com.google.android.material.tabs.TabLayout;

public class Relatorio_Activity extends AppCompatActivity {

    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        SectionsPagerAdapterRelatorio sectionsPagerAdapter = new SectionsPagerAdapterRelatorio(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager_relatorio);
        viewPager.setAdapter(sectionsPagerAdapter);

        tabs = findViewById(R.id.tabsRelatorio);
        tabs.setupWithViewPager(viewPager);

    }

    public void VoltarParaHome(View v){
        Intent intent = new Intent(this, Home_Activity.class);
        startActivity(intent);
    }

}
