package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ingresarB, registro;
    EditText usuario, contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.usuario = (EditText) findViewById(R.id.TextUsuario);
        this.contra = (EditText) findViewById(R.id.TextContra);
        this.registro= (Button) findViewById(R.id.registro);
        this.ingresarB = (Button) findViewById(R.id.btn_siguiente);

        final DB_MediGuide db_mediGuide = new DB_MediGuide(getApplicationContext());

        this.ingresarB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int accion;
                String usuario1, contra1;
                contra1 = contra.getText().toString();
                usuario1 = usuario.getText().toString();

                accion = db_mediGuide.iniciarSesion(usuario1,contra1);
                if (accion == 1){
                    MainActivity.this.startActivity(new Intent(MainActivity.this, NavigationDrawer.class));
                }else if (accion == 0){
                    Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }else if(accion == 2){
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();

                }

            }
        });

        this.registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, registro.class));
            }
        });

    }
}