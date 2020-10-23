package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buscar extends AppCompatActivity {

    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        this.regresar = (Button)this.findViewById(R.id.btn_regresarB);
        this.regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buscar.this.startActivity(new Intent(buscar.this, inicio.class));
            }
        });
    }
}