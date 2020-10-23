package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inicio extends AppCompatActivity {

    Button buscarB;
    Button recordatoriosB;
    Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        this.buscarB = (Button)this.findViewById(R.id.btn_Buscar);
        this.recordatoriosB = (Button)this.findViewById(R.id.btn_Recordatorio);
        this.salir = (Button)this.findViewById(R.id.btn_salir);
        this.buscarB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inicio.this.startActivity(new Intent(inicio.this, buscar.class));
            }
        });
        this.recordatoriosB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inicio.this.startActivity(new Intent(inicio.this, recordatorios.class));
            }
        });
        this.salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(inicio.this, MainActivity.class));
            }
        });

    }
}