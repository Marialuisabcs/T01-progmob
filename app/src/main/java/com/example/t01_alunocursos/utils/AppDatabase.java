package com.example.t01_alunocursos.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.t01_alunocursos.entities.Aluno;
import com.example.t01_alunocursos.entities.Curso;
import com.example.t01_alunocursos.daos.CursoDao;
import com.example.t01_alunocursos.daos.AlunoDao;

@Database(entities = {Aluno.class, Curso.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AlunoDao alunoDao();
    public abstract CursoDao cursoDao();

    public static AppDatabase getConnection(Context appContext){
         return Room.databaseBuilder(appContext, AppDatabase.class, "app_database").fallbackToDestructiveMigration().build();


    }
}
