package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class tutorial2 extends AppCompatActivity {

    Button omitir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85),(int)(alto * 0.58));

        omitir = (Button) findViewById(R.id.omitir2);
        this.omitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorial2.this.startActivity(new Intent(tutorial2.this, tutorial3.class));
                finish();
            }
        });
    }
}