package com.example.appt01.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.appt01.entities.Aluno;

import java.util.List;

@Dao
public interface AlunoDao   {
    @Query("SELECT * FROM alunos")
    List<Aluno> getAll();

    @Query("SELECT * FROM alunos WHERE alunoId IN (:alunoId) LIMIT 1")
    Aluno findById(int alunoId);

    @Query("SELECT * FROM alunos WHERE nome_aluno LIKE :nome")
    Aluno findByName(String nome);

    @Query("UPDATE alunos SET nome_aluno=:nome, email=:email, telefone=:tel, cpf=:cpf WHERE alunoId = :id")
    void update(String nome, String email, String tel, String cpf, int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Aluno... aluno);

    @Delete
    void delete(Aluno aluno);

}
