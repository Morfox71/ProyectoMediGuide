package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class recordatorios extends AppCompatActivity {

    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);

        this.regresar = (Button)this.findViewById(R.id.btn_regresarR);
        this.regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recordatorios.this.startActivity(new Intent(recordatorios.this, inicio.class));
            }
        });
    }
}