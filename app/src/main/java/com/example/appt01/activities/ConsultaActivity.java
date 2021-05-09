package com.example.appt01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.appt01.R;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        this.setTitle("Consulta");
    }
}