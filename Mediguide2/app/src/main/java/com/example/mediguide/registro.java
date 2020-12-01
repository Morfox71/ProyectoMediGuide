package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    EditText EditUsuario, EditContra, EditCorreo;
    Button BtnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.EditUsuario = (EditText)findViewById(R.id.EditUsuario);
        this.EditContra = (EditText)findViewById(R.id.EditContra);
        this.EditCorreo = (EditText)findViewById(R.id.EditCorreo);
        this.BtnRegistrar = (Button) findViewById(R.id.BtnRegistrar);

        final DB_MediGuide db_mediGuide = new DB_MediGuide(getApplicationContext());

        this.BtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int accion;
                String Usuario = EditUsuario.getText().toString().toUpperCase();
                String Contra = EditContra.getText().toString();
                String Correo = EditCorreo.getText().toString().toUpperCase();
                accion = db_mediGuide.agregarUsuarios(Usuario, Contra, Correo);
                if (accion == 0){
                    Toast.makeText(getApplicationContext(), "Usuario existente", Toast.LENGTH_SHORT).show();
                }else if (accion == 1){
                    Toast.makeText(getApplicationContext(), "Correo existente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
                    registro.this.startActivity(new Intent(registro.this, MainActivity.class));
                }

            }
        });
    }

}