package com.example.appt01.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appt01.R;
import com.example.appt01.entities.Aluno;
import com.example.appt01.entities.Curso;
import com.example.appt01.utils.AppDatabase;

import java.util.List;

public class InsrtAluActivity extends AppCompatActivity {
    private EditText edtNomeAluno, edtEmail, edtTel, edtCpf;
    private Button btExcluir;
    private int alunoKey, cursoId_key;
    private String nome_key, email_key, tel_key, cpf_key;
    Intent it;
    Spinner spinnerCursos;
    ArrayAdapter adpt;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insrt_alu);
        this.setTitle("Edição de Alunos");

        db = AppDatabase.getConnection(getApplicationContext());

        edtNomeAluno = findViewById(R.id.edtNomeAluno);
        edtEmail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTel);
        edtCpf = findViewById(R.id.edtCpf);
        spinnerCursos = findViewById(R.id.spinnerCursos);
        btExcluir = findViewById(R.id.btExcluirAluno);

        it = getIntent();
        alunoKey = it.getIntExtra("aluno_key", -1);

    }

    @Override
    public void onResume() {
        super.onResume();
        selecaoCursos();
        if(alunoKey == -1){
            btExcluir.setVisibility(View.GONE);
        }
        else{
            alunoSelecionado();
        }
    }

    public void alunoSelecionado(){
        nome_key = it.getStringExtra("nome_key");
        edtNomeAluno.setText(nome_key);
        email_key = it.getStringExtra("email_key");
        edtEmail.setText(email_key);
        tel_key = it.getStringExtra("tel_key");
        edtTel.setText(tel_key);
        cpf_key = it.getStringExtra("cpf_key");
        edtCpf.setText(cpf_key);
        cursoId_key = it.getIntExtra("cursoId_key", -1);
        Curso curso = db.cursoDao().findById(cursoId_key);
        int pos = getPos(spinnerCursos, curso.toString());
        spinnerCursos.setSelection(pos);
    }

    private int getPos(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }
        return 0;
    }

    public void selecaoCursos(){//Terminar de implementar o spinner
        List<Curso> cursos = db.cursoDao().getAll();
        adpt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cursos);
        spinnerCursos.setAdapter(adpt);
    }

    public void insereAluno(View view) {//terminar de implementar insereAluno!! falta o update que requer um extra da chamada
        String nome, email, tel, cpf;
        Curso cursoSelecionado = null;

        nome = edtNomeAluno.getText().toString();
        email = edtEmail.getText().toString();
        tel = edtTel.getText().toString();
        cpf = edtCpf.getText().toString();


        if(spinnerCursos.getSelectedItem() != null){
            cursoSelecionado = (Curso)spinnerCursos.getSelectedItem();
        }

        if(nome.equals("") || email.equals("") || tel.equals("") || cpf.equals("") || cursoSelecionado == null){
            Toast toast = Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        else {
            if(alunoKey == -1) {
                Aluno novoAluno = new Aluno(nome, email, tel, cpf, cursoSelecionado.getCursoId(), cursoSelecionado);
                db.alunoDao().insertAll(novoAluno);
                db.close();
                Toast toast  = Toast.makeText(this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                db.alunoDao().update(nome, email, tel, cpf, cursoSelecionado.getCursoId(), alunoKey);
                db.close();
                Toast toast = Toast.makeText(this, "Aluno atualizado com sucesso", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        finish();

    }


    public void excluiAluno(View view) {
        AlertDialog.Builder  confirm = new AlertDialog.Builder(this);
        confirm.setTitle("Confirmar exclusão");
        confirm.setMessage("Tem certeza que seja excluir este aluno?");
        confirm.setCancelable(true);
        confirm.setNegativeButton(
                "Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        confirm.setPositiveButton(
                "Sim",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Aluno aluno = db.alunoDao().findById(alunoKey);
                        db.alunoDao().delete(aluno);
                        db.close();
                        Toast t = Toast.makeText(InsrtAluActivity.this, "Aluno excluído com sucesso", Toast.LENGTH_SHORT);
                        t.show();
                        finish();
                    }
                });

        AlertDialog alert = confirm.create();
        alert.show();

    }

}