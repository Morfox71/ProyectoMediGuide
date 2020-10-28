package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Padecimientos extends AppCompatActivity {

    //Inicializar variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padecimientos);

        //asignar variable
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
        //Redireccionar activity a Home
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
        //Rehacer activity
        recreate();
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
        //Volver al inicio
        NavigationDrawer.redirectActivity(this, MainActivity.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Cerrar drawer
        NavigationDrawer.closeDrawer(drawerLayout);
    }
}