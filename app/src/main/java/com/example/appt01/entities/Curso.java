package com.example.appt01.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cursos")
public class Curso {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cursoId")
    private int cursoId;

    @ColumnInfo(name = "nome_curso")
    private String nome;

    @ColumnInfo(name = "carga_horaria")
    private int qtdHrs;

    public Curso(){
    }

    @Ignore
    public Curso(String nome, int qtdHrs) {
        this.nome = nome;
        this.qtdHrs = qtdHrs;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdHrs() {
        return qtdHrs;
    }

    public void setQtdHrs(int qtdHrs) {
        this.qtdHrs = qtdHrs;
    }

    @Override
    public String toString() {
        return "\tNome: " + nome +"\t\t\tCarga Horária: " + qtdHrs;
    }
}
