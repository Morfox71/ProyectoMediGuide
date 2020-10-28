package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationDrawer extends AppCompatActivity {
    //Inicializar variables

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //Asignar variables
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        //Abrir el drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Abrir el Layout del drawer
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Cerrar el drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Cerrar el layout del drawer
        //Checar condición
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //Cuando el drawer está abierto
            //Cerrar el drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Rehacer actividad
        recreate();
    }

    public void ClickBusqueda(View view){
        //Redireccionar actividad a Busqueda
        redirectActivity(this,buscar.class);
    }

    public void ClickTienda(View view){
        //Redireccionar actividad a Tienda
        redirectActivity(this, Tienda.class);
    }

    public void ClickPadecimientos(View view){
        //Redireccionar actividad a Padecimientos
        redirectActivity(this, Padecimientos.class);
    }

    public void ClickChat(View view){
        //Redireccionar actividad a Chat
        redirectActivity(this, Chat.class);
    }

    public void ClickRecordatorios(View view){
        //Redireccionar actividad a recordatorios
        redirectActivity(this, recordatorios.class);
    }

    public void ClickLogout(View view){
        //Cerrar aplicación
        logout(this);
    }

    public static void logout(final Activity activity) {
        //Inicializar diálogo de alerta
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Estabelcer título
        builder.setTitle("Logout");
        //Establecer mensaje
        builder.setMessage("Are you sure you want to log out?");
        //Botón de afirmación
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finalizar actividad
                activity.finishAffinity();
                //Salir de la app
                System.exit(0);

            }
        });
        //Botón de negación
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Mostrar diálogo
        builder.show();
    }


    public static void redirectActivity(Activity activity, Class aClass) {
        //Inicializar variables
        Intent intent = new Intent(activity, aClass);
        //Establecer bandera
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Cerrar drawer
        closeDrawer(drawerLayout);
    }
}