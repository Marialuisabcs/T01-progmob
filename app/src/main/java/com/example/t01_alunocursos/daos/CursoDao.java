package com.example.t01_alunocursos.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.t01_alunocursos.entities.Aluno;
import com.example.t01_alunocursos.entities.Curso;

import java.util.List;

@Dao
public interface CursoDao {
    @Query("SELECT * FROM cursos")
    List<Curso> getAll();

    @Query("SELECT * FROM cursos WHERE uid IN (:userIds) LIMIT 1")
    Curso loadAllById(int userIds);

    @Query("SELECT * FROM cursos WHERE nome_curso LIKE :nome LIMIT 1")
    Curso findByName(String nome);

    @Insert
    void insertAll(Curso... cursos);

    @Delete
    void delete(Curso curso);

    @Update
    void update(Curso curso);
}
