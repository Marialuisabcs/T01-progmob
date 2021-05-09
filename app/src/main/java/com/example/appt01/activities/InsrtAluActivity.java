package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appt01.R;
import com.example.appt01.entities.Aluno;
import com.example.appt01.entities.Curso;
import com.example.appt01.utils.AppDatabase;

import java.util.List;

public class InsrtAluActivity extends AppCompatActivity {
    EditText edtNomeAluno, edtEmail, edtTel, edtCpf;
    Spinner spinnerCursos;
    int idCursoSelect;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insrt_alu);
        this.setTitle("Edição de Alunos");

        edtNomeAluno = findViewById(R.id.edtNomeAluno);
        edtEmail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTel);
        edtCpf = findViewById(R.id.edtCpf);
        spinnerCursos = findViewById(R.id.spinnerCursos);

        //idCursoSelect = getIntent().getIntExtra('curso_selecionado_key') //extra que mostra se é um update ou um insert
    }

    @Override
    public void onResume() {//mudar visibilidade do botao de exclusão quando for só update (alunoKey != -1)
        super.onResume();
        //selecionarCursos();

    }

    public void selecionarCursos(){//Terminar de implementar o spinner
        List<Curso> cursos = db.cursoDao().getAll();
        ArrayAdapter adpt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cursos);
        spinnerCursos.setAdapter(adpt);
        //adiconal seleção
    }

    public void insereAluno(View view) {//terminar de implementar insereAluno!! falta o update que requer um extra da chamada
        String nome, email, tel, cpf, nomeCurso="";
        List<Curso> cursos = db.cursoDao().getAll();

        nome = edtNomeAluno.getText().toString();
        email = edtEmail.getText().toString();
        tel = edtTel.getText().toString();
        cpf = edtCpf.getText().toString();

        if(spinnerCursos.getSelectedItem() != null){
            nomeCurso = spinnerCursos.getSelectedItem().toString();
        }

        if(nome.equals("") || email.equals("") || tel.equals("") || cpf.equals("") || nomeCurso.equals("")){
            Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_LONG);
            return;
        }

        Aluno novoAluno = new Aluno(nome, email, tel, cpf, 0, db.cursoDao().findById(0));
        novoAluno.setCursoId(cursos.get(spinnerCursos.getSelectedItemPosition()).getCursoId());
        db.alunoDao().insertAll(novoAluno);
        Toast.makeText(this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT);

    }


    public void excluiAluno(View view) {//implementar a exclusão
    }
}