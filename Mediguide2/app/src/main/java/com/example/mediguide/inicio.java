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
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class inicio extends AppCompatActivity {

    TextView NombreUsuario;
    TextView edad, estatura, tipoSangre, padecimientos, alergias;
    Button guardar;
    DrawerLayout drawerLayout;
    FloatingActionButton editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_usuario);

        final DB_MediGuide db_mediGuide = new DB_MediGuide(getApplicationContext());

        editar = (FloatingActionButton) findViewById(R.id.my_fab);
        NombreUsuario = (TextView) findViewById(R.id.NombreUsuario);
        edad = (TextView) findViewById(R.id.edadText);
        estatura = (TextView) findViewById(R.id.estaturaText);
        tipoSangre = (TextView) findViewById(R.id.TipoSangreText);
        padecimientos = (TextView) findViewById(R.id.padecimientosText);
        alergias = (TextView) findViewById(R.id.alergiasText);
        guardar = (Button) findViewById(R.id.btnGuardar);

        edad.setEnabled(false);
        estatura.setEnabled(false);
        tipoSangre.setEnabled(false);
        padecimientos.setEnabled(false);
        alergias.setEnabled(false);

        final Intent intent = getIntent();
        NombreUsuario.setText(intent.getStringExtra("usuario"));

        //edad.setText(db_mediGuide.cargarEdad(intent.getStringExtra("usuario")));
        //estatura.setText(db_mediGuide.cargarEstatura(intent.getStringExtra("usuario")));
        //tipoSangre.setText(db_mediGuide.cargarTipoSangre(intent.getStringExtra("usuario")));
        //padecimientos.setText(db_mediGuide.cargarPadecimiento(intent.getStringExtra("usuario")));
        //alergias.setText(db_mediGuide.cargarAlergias(intent.getStringExtra("usuario")));

        drawerLayout = findViewById(R.id.drawer_layout);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edad.setEnabled(true);
                estatura.setEnabled(true);
                tipoSangre.setEnabled(true);
                padecimientos.setEnabled(true);
                alergias.setEnabled(true);

                guardar.setVisibility(View.VISIBLE);

            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //db_mediGuide.guardarInformacion(intent.getStringExtra("usuario"), edad.getText().toString(), estatura.getText().toString(), tipoSangre.getText().toString(), padecimientos.getText().toString(), alergias.getText().toString());

                edad.setEnabled(false);
                estatura.setEnabled(false);
                tipoSangre.setEnabled(false);
                padecimientos.setEnabled(false);
                alergias.setEnabled(false);

                guardar.setVisibility(View.INVISIBLE);
            }
        });
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
        builder.setTitle("Salir");
        //Establecer mensaje
        builder.setMessage("¿Seguro que quieres salir?");
        //Botón de afirmación
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
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


