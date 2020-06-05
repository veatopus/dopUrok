package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BlankFragment extends Fragment {
    static String TAG = "tag_for_blankFragment";
    static String TAG1 = "tag1_for_blankFragment";

    private EditText editText;
    private IShowText iShowText;
    private int id;

    BlankFragment(int i) {
        id = i;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iShowText = (IShowText) context;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        initialisation(v);
        return v;
    }

    String getText(){
        return editText.getText().toString();
    }

    private void initialisation(View v){
        editText = v.findViewById(R.id.fragmentBlank_et);
    }

    void showText(String s){
    }
}
