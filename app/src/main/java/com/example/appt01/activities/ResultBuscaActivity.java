package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appt01.R;
import com.example.appt01.entities.Aluno;
import com.example.appt01.utils.AppDatabase;

import java.util.List;

public class ResultBuscaActivity extends AppCompatActivity {
    private int cursoId;
    private String nomeCurso;
    private ListView lvAlunoDoCurso;
    ArrayAdapter<Aluno> adpt;
    List<Aluno> alunos;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_busca);

        db = AppDatabase.getConnection(getApplicationContext());

        Intent it = getIntent();
        cursoId = it.getIntExtra("cursoId_key", -1);
        nomeCurso = it.getStringExtra("nomeCurso_key");
        this.setTitle(nomeCurso);

        lvAlunoDoCurso = findViewById(R.id.listViewAlunoCurso);
        alunos = db.alunoDao().findByCurso(cursoId);
        if(alunos.size() == 0){
            Toast toast = Toast.makeText(this, "Nenhum aluno matriculado nessa matéria", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            adpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos);
            lvAlunoDoCurso.setAdapter(adpt);
        }
    }
}