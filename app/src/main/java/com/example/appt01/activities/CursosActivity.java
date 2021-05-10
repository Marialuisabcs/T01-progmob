package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appt01.R;
import com.example.appt01.entities.Curso;
import com.example.appt01.utils.AppDatabase;

import java.util.List;

public class CursosActivity extends AppCompatActivity {
    ListView lvCursos;
    List<Curso> cursos;
    ArrayAdapter adpt;
    AppDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        this.setTitle("Cursos");

        db = AppDatabase.getConnection(getApplicationContext());
        lvCursos = findViewById(R.id.listViewCursos);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarCursos();
    }

    public void mostrarCursos(){
        Intent it = new Intent(this, InsrtCrsActivity.class);

        cursos = db.cursoDao().getAll();
        db.close();
        adpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cursos);
        lvCursos.setAdapter(adpt);

        lvCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
                Curso curso = cursos.get(pos);
                it.putExtra("curso_key", curso.getCursoId());
                it.putExtra("nome_curso_key", curso.getNome());
                it.putExtra("qtd_hrs_key", curso.getQtdHrs());
                startActivity(it);
            }
        });
    }

    public void abrirInsrtCrs(View view) {
        Intent it  = new Intent(this, InsrtCrsActivity.class);
        startActivity(it);
    }


}