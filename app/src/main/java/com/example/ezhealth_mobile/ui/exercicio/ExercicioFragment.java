package com.example.ezhealth_mobile.ui.exercicio;

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

public class ExercicioFragment extends Fragment {

    private ExercicioViewModel exercicioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        exercicioViewModel =
                new ViewModelProvider(this).get(ExercicioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exercicio, container, false);
        final TextView textView = root.findViewById(R.id.text_exercicio);
        exercicioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}