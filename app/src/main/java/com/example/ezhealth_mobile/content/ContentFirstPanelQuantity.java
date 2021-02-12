package com.example.ezhealth_mobile.content;

import android.view.View;
import android.widget.TextView;

import com.example.ezhealth_mobile.entity.ObjectDefault;
import com.example.ezhealth_mobile.R;

public class ContentFirstPanelQuantity {

    public ContentFirstPanelQuantity(View view, String titlePanel, String quantity, String quantityMeasure) {
        ((TextView)view.findViewById(R.id.textViewTitle)).setText(titlePanel);
        ((TextView)view.findViewById(R.id.editTextQtd)).setText(quantity);
        ((TextView)view.findViewById(R.id.editTextQtd)).setText(quantityMeasure);
    }

}
