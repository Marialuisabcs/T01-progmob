package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;

import com.example.appt01.R;
import com.example.appt01.entities.Aluno;
import com.example.appt01.entities.Curso;
import com.example.appt01.utils.AppDatabase;

public class AlunosActivity extends AppCompatActivity {
    AppDatabase db;
    ListView lvAlunos;
    List<Aluno> alunos;
    ArrayAdapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);
        this.setTitle("Alunos");

        db = AppDatabase.getConnection(getApplicationContext());
        lvAlunos = findViewById(R.id.listViewAlunos);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarAlunos();
    }

    public void mostrarAlunos(){//Teminar a implementação do list view dos alunos
        alunos = db.alunoDao().getAll();
        adpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos);
        lvAlunos.setAdapter(adpt);
        //ação quando selecionar algum do list view
    }

    public void abrirInsrtAlu(View view){
        Intent it = new Intent(this, InsrtAluActivity.class);
        startActivity(it);
    }


}