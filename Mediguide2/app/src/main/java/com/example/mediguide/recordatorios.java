package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class recordatorios extends AppCompatActivity {


    //Inicializar variable
    DrawerLayout drawerLayout;

    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);

        //Asignar variable
       drawerLayout = findViewById(R.id.drawer_layout);

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
        //Redireccionar activity a home
        NavigationDrawer.redirectActivity(this, NavigationDrawer.class);
    }

    public void ClickBusqueda(View view){
        //Redireccionar activity a Busqueda
        NavigationDrawer.redirectActivity(this, buscar.class);
    }

    public void ClickTienda(View view){
        //Redireccionar activity a Tienda
        NavigationDrawer.redirectActivity(this, Tienda.class);
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
        //Rehacer activity
        recreate();
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