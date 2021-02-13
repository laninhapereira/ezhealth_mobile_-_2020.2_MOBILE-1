package com.example.ezhealth_mobile.ui.diario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.ezhealth_mobile.R;

public class DiarioFragment extends Fragment {

    private DiarioViewModel diarioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        diarioViewModel =
                new ViewModelProvider(this).get(DiarioViewModel.class);

        View root = inflater.inflate(R.layout.fragment_diario, container, false);
        diarioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

}