package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowId;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appt01.R;
import com.example.appt01.entities.Curso;
import com.example.appt01.utils.AppDatabase;

import java.util.List;

public class ConsultaActivity extends AppCompatActivity {
    AppDatabase db;
    private List<Curso> cursos;
    private EditText edtConsulta;
    private ListView lvConsulta;
    ArrayAdapter adpt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        this.setTitle("Consulta");

        db = AppDatabase.getConnection(getApplicationContext());

        edtConsulta = findViewById(R.id.edtConsulta);
        lvConsulta = findViewById(R.id.listViewConsulta);

    }

    @Override
    protected void onResume() {
        super.onResume();
        preencheCursos();
    }

    public void preencheCursos(){
         cursos = db.cursoDao().getAll();
         adpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cursos);
         lvConsulta.setAdapter(adpt);

        lvConsulta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
                Curso curso = cursos.get(pos);
                Intent it = new Intent(ConsultaActivity.this, ResultBuscaActivity.class);
                it.putExtra("cursoId_key", curso.getCursoId());
                it.putExtra("nomeCurso_key", curso.getNome());
                startActivity(it);
            }
        });
    }

    public void busca(View view) {
        preencheCursos();
        String cursoBuscado = edtConsulta.getText().toString();
        List<Curso> auxCursos = cursos;
        int aux;
        if (cursoBuscado.equals("")){
            preencheCursos();
            return;
        }
        for(int i=0; i<auxCursos.size(); i++){
            if(!auxCursos.get(i).getNome().startsWith(cursoBuscado)){
                cursos.remove(i);
                i = i-1;
            }
        }
        adpt.notifyDataSetChanged();
    }
}
