package com.example.t01_alunocursos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t01_alunocursos.R;
//FRAGMENTO DE BUSCA E EDIÇÃO DE ALUNOS
public class Fragment2A extends Fragment{
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment2a_layout, container, false);
        return rootView;
    }
}
