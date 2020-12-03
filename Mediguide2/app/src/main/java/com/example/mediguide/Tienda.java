package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Tienda extends AppCompatActivity {
    //Inicializar variable
    DrawerLayout drawerLayout;
    ViewFlipper flipper_medicamentos;
    ViewFlipper flipper_consejos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        //Asignar variable
        drawerLayout = findViewById(R.id.drawer_layout);

        ImageButton imgbtn_Tienda = (ImageButton)findViewById(R.id.imgbtn_tienda);
        final EditText medicamento_tienda = (EditText)findViewById(R.id.medicamento_tienda);

        imgbtn_Tienda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(getApplicationContext(),busqueda_tienda.class);
                intent.putExtra("nombre_medicamento",medicamento_tienda.getText().toString());
                String input = medicamento_tienda.getText().toString();
                if("paracetamol".equalsIgnoreCase(input) || "naproxeno".equalsIgnoreCase(input) || "ibuprofeno".equalsIgnoreCase(input)){
                    startActivity(intent);
                } else{
                    Toast toast1 = Toast.makeText(getApplicationContext(), "No se encontraron resultados.", Toast.LENGTH_SHORT);

                    toast1.show();
                }

            }
        });

        int images_medicamentos[] = {R.drawable.naproxeno1, R.drawable.ibuprofeno1, R.drawable.paracetamol1};

        flipper_medicamentos = findViewById(R.id.flipper_medicamentos);

        for(int image: images_medicamentos){
            flipperImages(image);
        }

        int images_consejos[] = {R.drawable.consejoscovid1, R.drawable.consejoscovid2, R.drawable.consejoscovid3, R.drawable.consejoscovid4};

        flipper_consejos = findViewById(R.id.flipper_consejos);

        for(int image: images_consejos){
            flipperImages2(image);
        }
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        flipper_medicamentos.addView(imageView);
        flipper_medicamentos.setFlipInterval(3000);
        flipper_medicamentos.setAutoStart(true);

        flipper_medicamentos.setInAnimation(this, android.R.anim.slide_out_right);
        flipper_medicamentos.setInAnimation(this, android.R.anim.slide_in_left);
    }

    public void flipperImages2(int image){ //Consejos
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        flipper_consejos.addView(imageView);
        flipper_consejos.setFlipInterval(6000);
        flipper_consejos.setAutoStart(true);

        flipper_consejos.setInAnimation(this, android.R.anim.slide_out_right);
        flipper_consejos.setInAnimation(this, android.R.anim.slide_in_left);
    }

    public void ClickMenu(View view){
        //Abrir drawer
        NavigationDrawer.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Cerrar drawer
        NavigationDrawer.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redireccionar activity a Home
        NavigationDrawer.redirectActivity(this,NavigationDrawer.class);
    }

    public void ClickBusqueda(View view){
        //Redireccionar activity a Busqueda
        NavigationDrawer.redirectActivity(this,buscar.class);
    }

    public void ClickTienda(View view){
        //Rehacer activity
        recreate();

    }

    public void ClickPadecimientos(View view){
        //Redireccionar activity a Padecimientos
        NavigationDrawer.redirectActivity(this, Padecimientos.class);
    }

    public void ClickChat(View view){
        //Redireccionar activity a Chat
        NavigationDrawer.redirectActivity(this, Chat.class);
    }

    public void ClickRecordatorios(View view){
        //Redireccionar activity a Recordatorios
        NavigationDrawer.redirectActivity(this, recordatorios.class);
    }

    public void ClickLogout(View view){
        //Cerrar app
        NavigationDrawer.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Cerrar drawer
        NavigationDrawer.closeDrawer(drawerLayout);
    }
}