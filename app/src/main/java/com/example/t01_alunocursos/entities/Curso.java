package com.example.t01_alunocursos.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cursos")
public class Curso {

    @PrimaryKey(autoGenerate = true)
    private int uid;

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
}
