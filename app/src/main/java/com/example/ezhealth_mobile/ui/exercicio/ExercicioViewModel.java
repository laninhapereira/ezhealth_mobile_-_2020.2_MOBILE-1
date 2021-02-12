package com.example.ezhealth_mobile.ui.exercicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExercicioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExercicioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is exercicio fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}