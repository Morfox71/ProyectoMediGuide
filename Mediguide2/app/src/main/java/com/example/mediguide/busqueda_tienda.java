package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class busqueda_tienda extends AppCompatActivity {

    private ListView tvItems;
    private Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_tienda);



        final EditText medicamento_busqueda_tienda = (EditText)findViewById(R.id.medicamento_busqueda_tienda);
        Intent intent = getIntent();
        medicamento_busqueda_tienda.setText(intent.getStringExtra("nombre_medicamento"));

        final ImageView imgbtn_busqueda_tienda = (ImageView) findViewById(R.id.imgbtn_busqueda_tienda);
        imgbtn_busqueda_tienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Tienda.class);
                startActivity(intent);
            }
        });

        tvItems = findViewById(R.id.tvItems);
        adaptador = new Adaptador(this, GetArrayItems());
        tvItems.setAdapter(adaptador);

    }

    private ArrayList<Entidad> GetArrayItems(){
        EditText medicamento_busqueda_tienda = (EditText)findViewById(R.id.medicamento_busqueda_tienda);
        String titulo = medicamento_busqueda_tienda.getText().toString();
        ArrayList<Entidad> listItems = new ArrayList<>();


        if("naproxeno".equalsIgnoreCase(titulo)){
            listItems.add(new Entidad(R.drawable.naproxeno1, "$120", "Farmacias del Ahorro 500mg con 20 tabletas.", "Farmacias Similares"));
            listItems.add(new Entidad(R.drawable.naproxeno2, "$250", "Medimart 500mg con 20 tabletas.", "Farmacia San Pablo"));
            listItems.add(new Entidad(R.drawable.naproxeno3, "$300", "Laboratorio Chile 550mg con 20 cápsulas.", "Farmacia Guadalajara"));
        } else if("ibuprofeno".equalsIgnoreCase(titulo)){
            listItems.add(new Entidad(R.drawable.ibuprofeno1, "$220", "Caja de 600mg con 20 cápsulas.", "Farmacias Similares"));
            listItems.add(new Entidad(R.drawable.ibuprofeno2, "$130", "Actron 400mg en cápsulas.", "Farmacia San Pablo"));
            listItems.add(new Entidad(R.drawable.ibuprofeno3, "$170", "Cinfa 600mg 40 comprimidos recubiertos con película.", "Farmacia Benavides"));
        } else if("paracetamol".equalsIgnoreCase(titulo)){
            listItems.add(new Entidad(R.drawable.paracetamol1, "$130.00", "Laboratorio Chile 500mg con 16 comprimidos.", "Farmacia San Pablo"));
            listItems.add(new Entidad(R.drawable.paracetamol2, "$200.00", "BAYER 50 comprimidos analgésico antifebril.", "Farmacia Benavides"));
            listItems.add(new Entidad(R.drawable.paracetamol3, "$350.00", "Pharmalife 750mg con 10 tabletas.", "Farmacia Guadalajara"));
        }


        return listItems;
    }




}