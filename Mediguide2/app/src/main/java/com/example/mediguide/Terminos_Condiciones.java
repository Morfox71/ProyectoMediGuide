package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Terminos_Condiciones extends AppCompatActivity {

    RadioButton acepto;
    Button siguiente;
    TextView usuario;
    String usuarioGlobal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos__condiciones);

        final MainActivity mainActivity = new MainActivity();

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;
        
        getWindow().setLayout((int)(ancho * 0.85),(int)(alto * 0.58));

        this.siguiente= (Button) findViewById(R.id.siguiente);
        acepto = (RadioButton) findViewById(R.id.radioButton5);
        usuario = (TextView) findViewById(R.id.TextUsuario);
        final DB_MediGuide db_mediGuide = new DB_MediGuide(getApplicationContext());
        this.siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (acepto.isChecked()){
                    db_mediGuide.actualizarSesion();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Primero acepta los terminos y condiciones.", Toast.LENGTH_SHORT).show();

                }
            }
        });

        

    }
}