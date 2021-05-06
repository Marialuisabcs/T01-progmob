package com.example.t01_alunocursos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.t01_alunocursos.ui.main.SectionsPagerAdapterA;

public class Alunos extends AppCompatActivity {
    EditText edtNomeAluno, edtCurso, edtEmail, edtTel, edtCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);

        SectionsPagerAdapterA sectionsPagerAdapterA = new SectionsPagerAdapterA(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapterA);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        edtNomeAluno = findViewById(R.id.edtNomeAluno);
        edtCurso = findViewById(R.id.edtCurso);
        edtEmail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTel);
        edtCpf = findViewById(R.id.edtCpf);



    }
}