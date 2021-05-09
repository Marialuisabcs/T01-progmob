package com.example.appt01.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.appt01.entities.Curso;

import java.util.List;

@Dao
public interface CursoDao {
    @Query("SELECT * FROM cursos")
    List<Curso> getAll();

    @Query("SELECT * FROM cursos WHERE cursoId IN (:userIds) LIMIT 1")
    Curso findById(int userIds);

    @Query("SELECT * FROM cursos WHERE nome_curso LIKE :nome LIMIT 1")
    Curso findByName(String nome);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Curso... cursos);

    @Delete
    void delete(Curso curso);

    @Update
    void update(Curso curso);
}
