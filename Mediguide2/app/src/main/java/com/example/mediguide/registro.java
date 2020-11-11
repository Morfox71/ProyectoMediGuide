package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

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
                String Usuario = EditUsuario.getText().toString();
                String Contra = EditContra.getText().toString();
                String Correo = EditCorreo.getText().toString();
                db_mediGuide.agregarUsuarios(Usuario, Contra, Correo);
                Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}