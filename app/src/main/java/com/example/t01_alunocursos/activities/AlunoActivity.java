package com.example.t01_alunocursos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.t01_alunocursos.R;
import com.example.t01_alunocursos.entities.Aluno;
import com.example.t01_alunocursos.utils.AppDatabase;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.t01_alunocursos.ui.main.SectionsPagerAdapterA;
import com.example.t01_alunocursos.daos.AlunoDao;

public class AlunoActivity extends AppCompatActivity {
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
    public void insereAluno(View view) {
        String nome, curso, email, tel, cpf;
        int cursoId, alunoId;
        nome = edtNomeAluno.getText().toString();
        curso = edtCurso.getText().toString();
        email = edtEmail.getText().toString();
        tel = edtTel.getText().toString();
        cpf = edtCpf.getText().toString();

        //Adicionar o aluno ao curso pela chave do mesmo
        //cursoId =

        Aluno novoAluno = new Aluno(nome, email, cpf, tel);

        AppDatabase.getConnection(getApplicationContext()).alunoDao().insertAll(novoAluno);

    }

    public void buscaaluno(View view){
        String nomeAluno;
        nomeAluno = edtCurso.getText().toString();
        Aluno aluno = AppDatabase.getConnection(getApplicationContext()).alunoDao().findByName(nomeAluno);
        //adcionar a visualização da busca
    }

    public void editarAluno(View view){

    }

    public void excluirAluno(View view){

    }

}