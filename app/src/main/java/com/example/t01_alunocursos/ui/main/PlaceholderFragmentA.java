package com.example.t01_alunocursos.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.t01_alunocursos.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragmentA extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModelA pageViewModelA;

    public static PlaceholderFragmentA newInstance(int index) {
        PlaceholderFragmentA fragment = new PlaceholderFragmentA();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModelA = new ViewModelProvider(this).get(PageViewModelA.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModelA.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_alunos, container, false);
        final TextView textView = root.findViewById(R.id.section_label_Aluno);
        pageViewModelA.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}