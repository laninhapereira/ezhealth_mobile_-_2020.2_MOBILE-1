package com.example.ezhealth_mobile.ui.refeicao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RefeicaoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RefeicaoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is refeicao fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}