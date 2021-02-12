package com.example.ezhealth_mobile.ui.diario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiarioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DiarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is diario fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}