package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appt01.R;
import com.example.appt01.entities.Curso;
import com.example.appt01.utils.AppDatabase;

public class InsrtCrsActivity extends AppCompatActivity {
    private EditText edtNome, edtQtdHrs;
    private Button btExcluir;
    private String nome_curso_key;
    private int cursoKey, qtd_hrs_key;
    Intent it;
    AppDatabase db ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insrt_crs);
        this.setTitle("Edição de Cursos");

        db = AppDatabase.getConnection(getApplicationContext());

        edtNome = findViewById(R.id.edtNomeCurso);
        edtQtdHrs = findViewById(R.id.edtQtdHrs);
        btExcluir = findViewById(R.id.btExcluirCurso);

        it = getIntent();
        cursoKey = it.getIntExtra("curso_key", -1);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast toast = Toast.makeText(this, "CURSO_KEY: "+cursoKey, Toast.LENGTH_LONG);
        //toast.show();
        if(cursoKey == -1){
            btExcluir.setVisibility(View.GONE);
        }
        else{
            cursoSelecionado();
        }
    }

    public void cursoSelecionado(){
        nome_curso_key = it.getStringExtra("nome_curso_key");
        qtd_hrs_key = it.getIntExtra("qtd_hrs_key", 0);
        edtNome.setText(nome_curso_key);
        edtQtdHrs.setText(Integer.toString(qtd_hrs_key));
    }


    public void insereCurso(View view) {
        String nome;
        int qtdHrs;

        nome = edtNome.getText().toString();
        qtdHrs = Integer.parseInt(edtQtdHrs.getText().toString());


        if((nome.equals("") || qtdHrs == 0)){
            Toast toast = Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        else{
            if(cursoKey == -1) {
                Curso novoCurso = new Curso(nome, qtdHrs);
                db.cursoDao().insertAll(novoCurso);
                Toast toast = Toast.makeText(this, "Curso cadastrado com sucesso", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Curso novoCurso = new Curso(nome, qtdHrs);
                db.cursoDao().update(novoCurso.getNome(), novoCurso.getQtdHrs(), cursoKey);
                Toast toast = Toast.makeText(this, "Curso atualizado com sucesso", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        finish();

    }


    public void excluiCurso(View view) {
        Curso curso = db.cursoDao().findById(cursoKey);
        db.cursoDao().delete(curso);
        Toast toast = Toast.makeText(this, "Curso excluído com sucesso", Toast.LENGTH_SHORT);
        toast.show();
        finish();
    }
}