package com.example.t01_alunocursos.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.t01_alunocursos.entities.Aluno;

import java.util.List;

@Dao
public interface AlunoDao   {
    @Query("SELECT * FROM alunos")
    List<Aluno> getAll();

    @Query("SELECT * FROM alunos WHERE alunoId IN (:alunoId) LIMIT 1")
    Aluno loadAllByIds(int alunoId);

    @Query("SELECT * FROM alunos WHERE nome LIKE :nome")
    Aluno findByName(String nome);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Aluno... aluno);

    @Delete
    void delete(Aluno aluno);

    @Update
    void update(Aluno aluno);
}
