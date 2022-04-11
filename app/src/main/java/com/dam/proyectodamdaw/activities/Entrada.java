package com.dam.proyectodamdaw.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.dam.proyectodamdaw.R;

public class Entrada extends AppCompatActivity {
            private ImageView imagen;
            private Spinner spinner;
            private Button seleccionar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
        seleccionar=findViewById(R.id.Seleccionar);
        spinner=findViewById(R.id.spinner);
        imagen=findViewById(R.id.imagenCity);
    }
}