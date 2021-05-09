package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        Intent it = new Intent(this, InsrtCrsActivity.class);

        alunos = db.alunoDao().getAll();
        adpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos);
        lvAlunos.setAdapter(adpt);

        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
                Aluno aluno = alunos.get(pos);
                it.putExtra("aluno_key", aluno.getAlunoId());
                it.putExtra("nome_key", aluno.getName());
                it.putExtra("email_key", aluno.getEmail());
                it.putExtra("tel_key", aluno.getTel());
                it.putExtra("cpf_key", aluno.getCpf());
                it.putExtra("cursoId_key", aluno.getCursoId());
                startActivity(it);
            }
        });
    }

    public void abrirInsrtAlu(View view){
        Intent it = new Intent(this, InsrtAluActivity.class);
        startActivity(it);
    }


}