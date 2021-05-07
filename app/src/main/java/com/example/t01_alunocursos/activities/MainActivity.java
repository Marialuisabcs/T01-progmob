package com.example.t01_alunocursos.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.t01_alunocursos.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        this.setTitle("Seja bem-vindo(a)");


    }


    public void abrirAluno(View view) {
        Intent it = new Intent(MainActivity.this, AlunoActivity.class);
        startActivity(it);
    }

    public void abrirCurso(View view) {
        Intent it = new Intent(MainActivity.this, CursosActivity.class);
        startActivity(it);
    }

    public void abrirConsulta(View view) {
        Intent it = new Intent(MainActivity.this, ConsultaActivity.class);
        startActivity(it);
    }
}