package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appt01.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Seja bem-vindo(a)");


    }


    public void abrirAluno(View view) {
        Intent it = new Intent(MainActivity.this, AlunosActivity.class);
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