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
    Button btExcluir;
    int cursoKey;
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

        Intent it = getIntent();
        cursoKey = it.getIntExtra("curso_key", -1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(cursoKey == -1){
            btExcluir.setVisibility(View.GONE);
        }
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

        else{//exlcuir os cursos vazio q deram errado e testar se esta inserindo curso com nome e carga vazia
            if(cursoKey == -1) {
                Curso novoCurso = new Curso(nome, qtdHrs);
                db.cursoDao().insertAll(novoCurso);
                Toast toast = Toast.makeText(this, "Curso cadastrado com sucesso", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Curso novoCurso = new Curso(nome, qtdHrs);
                db.cursoDao().update(novoCurso);
                Toast toast = Toast.makeText(this, "Curso atualizado com sucesso", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        finish();

    }


    public void excluiCurso(View view) {
        //implementar exclusão
    }
}