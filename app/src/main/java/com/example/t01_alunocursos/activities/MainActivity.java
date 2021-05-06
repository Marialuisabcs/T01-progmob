package com.example.t01_alunocursos;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        this.setTitle("Seja bem-vindo(a)");


    }


    public void abrirAluno(View view) {
        Intent it = new Intent(TelaInicial.this, Alunos.class);
        startActivity(it);
    }

    public void abrirCurso(View view) {
        Intent it = new Intent(TelaInicial.this, Cursos.class);
        startActivity(it);
    }
}