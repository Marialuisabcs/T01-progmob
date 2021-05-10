package com.example.appt01.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "alunos", foreignKeys = @ForeignKey(entity = Curso.class,
        parentColumns = "cursoId", childColumns = "cursoId"))
public class Aluno {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "alunoId")
    private int alunoId;

    @ColumnInfo(name = "nome_aluno")
    private String name;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "telefone")
    private String tel;

    @ColumnInfo(name = "cpf")
    private String cpf;

    @ColumnInfo(name = "cursoId", index = true)
    private int cursoId;

    @Ignore
    private Curso curso;

    public Aluno(){
    }

    @Ignore
    public Aluno(String nome, String email, String cpf, String tel, int cursoId, Curso curso) {
        this.name = nome;
        this.email = email;
        this.cpf = cpf;
        this.tel = tel;
        this.cursoId = cursoId;
        this.curso = curso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nome: " + name;
    }
}
