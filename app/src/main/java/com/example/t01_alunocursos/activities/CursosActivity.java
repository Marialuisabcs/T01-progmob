package com.example.t01_alunocursos.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.t01_alunocursos.R;
import com.example.t01_alunocursos.entities.Aluno;
import com.example.t01_alunocursos.entities.Curso;
import com.example.t01_alunocursos.ui.main.SectionsPagerAdapterC;
import com.example.t01_alunocursos.utils.AppDatabase;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class CursosActivity extends AppCompatActivity {
    private EditText edtNome, edtQtdHrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        SectionsPagerAdapterC sectionsPagerAdapterC = new SectionsPagerAdapterC(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapterC);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        edtNome = findViewById(R.id.edtNomeCurso);
        edtQtdHrs = findViewById(R.id.edtQtdHrs);

    }

    public void insereCurso(View view) {
        String nome;
        int qtdHrs;
        nome = edtNome.getText().toString();
        qtdHrs = Integer.parseInt(edtQtdHrs.getText().toString());

       Curso novoCurso = new Curso(nome, qtdHrs);

       AppDatabase.getConnection(getApplicationContext()).cursoDao().insertAll(novoCurso);

    }


    public void editarCurso(View view){

    }

    public void excluirCurso(View view){

    }
}