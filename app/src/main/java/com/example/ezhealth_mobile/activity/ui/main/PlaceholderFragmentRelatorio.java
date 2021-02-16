package com.example.ezhealth_mobile.activity.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezhealth_mobile.R;

public class PlaceholderFragmentRelatorio extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModelRelatorio pageViewModelRelatorio;

    public static PlaceholderFragmentRelatorio newInstance(int index) {
        PlaceholderFragmentRelatorio fragment = new PlaceholderFragmentRelatorio();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModelRelatorio = new ViewModelProvider(this).get(PageViewModelRelatorio.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModelRelatorio.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_adicionar_alimento_refeicao, container, false);
        final TextView textView = root.findViewById(R.id.textViewTituloTeste);
        pageViewModelRelatorio.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
