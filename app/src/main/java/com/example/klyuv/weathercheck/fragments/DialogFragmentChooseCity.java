package com.example.klyuv.weathercheck.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.klyuv.weathercheck.R;

public class DialogFragmentChooseCity extends DialogFragment implements View.OnClickListener {

    private EditText mEditText;
    private Button mButton;


    public DialogFragmentChooseCity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_city, null);
        mEditText = (EditText) view.findViewById(R.id.cc_fragment_editText);
        mButton = (Button) view.findViewById(R.id.cc_fragment_button);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
