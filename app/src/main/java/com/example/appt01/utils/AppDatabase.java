package com.example.appt01.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appt01.daos.AlunoDao;
import com.example.appt01.daos.CursoDao;
import com.example.appt01.entities.Aluno;
import com.example.appt01.entities.Curso;

@Database(entities = {Aluno.class, Curso.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AlunoDao alunoDao();
    public abstract CursoDao cursoDao();

    private static AppDatabase INST;

    public static AppDatabase getConnection(Context appContext){
        if(INST == null) {
            return Room.databaseBuilder(appContext, AppDatabase.class, "CURSO_E_ALUNOS").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return INST;

    }
}
