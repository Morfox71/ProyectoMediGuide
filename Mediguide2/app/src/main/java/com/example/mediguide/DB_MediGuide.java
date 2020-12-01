package com.example.mediguide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class DB_MediGuide extends SQLiteOpenHelper {

    private static final String Nombre_BD = "MediGuide";
    private static final int VERSION_BD = 1;
    private static final String TABLA_Usuarios = "CREATE TABLE if not exists USUARIOS (id_usuarios integer PRIMARY KEY autoincrement, " +
            "nombre_usuario text, contra text, correo text, inicio_sesion text)";
    private static final String TABLA_informacion = "CREATE TABLE if not exists INFORMACION (id_usuarios integer PRIMARY KEY, " +
            "edad text, estatura text, tipo_sangre text, padecimientos text, alergias text)";
    private static final String TABLA_productos = "CREATE TABLE if not exists PRODUCTOS (id_producto integer PRIMARY KEY autoincrement, " +
            "precio text, descripcion text, nombre text, imagen_producto blob)";


    public DB_MediGuide(Context context){
        super(context, Nombre_BD, null, VERSION_BD);
    }

    String usuarioGlobal;
    MainActivity mainActivity = new MainActivity();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_Usuarios);
        sqLiteDatabase.execSQL(TABLA_informacion);
        sqLiteDatabase.execSQL(TABLA_productos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_Usuarios));
        sqLiteDatabase.execSQL(TABLA_Usuarios);
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_informacion));
        sqLiteDatabase.execSQL(TABLA_informacion);
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_productos));
        sqLiteDatabase.execSQL(TABLA_productos);
    }

    public int agregarUsuarios(String nombre_usuario, String contra, String correo){
        SQLiteDatabase bd = getWritableDatabase();
        int accion = 0;
        Cursor cursor;
        Cursor cursor1;
        if (bd != null){
            cursor = bd.rawQuery("SELECT * FROM USUARIOS WHERE nombre_usuario = '" + nombre_usuario+"'", null);
            cursor1 = bd.rawQuery("SELECT * FROM USUARIOS WHERE correo = '" + correo+"'", null);
            if (cursor.moveToFirst()){
                accion = 0;
            }else if (cursor1.moveToFirst()){
                accion = 1;
            }else{
                accion = 2;
                bd.execSQL("INSERT INTO USUARIOS " +
                        "(nombre_usuario, contra, correo, inicio_sesion) VALUES ('"+nombre_usuario+"','" +contra+"','" +correo+"', 'Si')");
                bd.close();
            }


        }
        return accion;
    }

    public int iniciarSesion(String usuario, String contra){
        SQLiteDatabase bd = getReadableDatabase();
        usuarioGlobal = usuario;
        int accion = 0;
        Cursor cursor = bd.rawQuery("SELECT nombre_usuario FROM USUARIOS WHERE nombre_usuario = '" + usuario +"'",null);
        Cursor cursor1 = bd.rawQuery("SELECT contra FROM USUARIOS WHERE contra = '" + contra +"' AND nombre_usuario = '" + usuario +"'",null);

        if (cursor.moveToFirst()){
            if (cursor1.moveToFirst()){
                accion = 1;

            }else{
                accion = 0;
            }
        }else{
            accion = 2;
        }
        mainActivity.usuarioGlobal = this.usuarioGlobal;
        return accion;


    }
    public int sesion_iniciada(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        int accion=0;
        Cursor cursor = bd.rawQuery("SELECT inicio_sesion FROM USUARIOS WHERE nombre_usuario = '" + usuario +"' AND inicio_sesion = 'Si'",null);
        if (cursor.moveToFirst()){
            accion = 1;
        }
        return accion;
    }

    public void actualizarSesion(){
        SQLiteDatabase bd = getWritableDatabase();
        bd.execSQL("UPDATE USUARIOS SET inicio_sesion = 'No' ");
        bd.close();
    }

    public String cargarEdad(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        String edad = "";
        Cursor cursor = bd.rawQuery("SELECT id_usuarios FROM USUARIOS WHERE nombre_usuario = '"+ usuario +"'",null);
        bd.close();

        if (cursor.moveToFirst()){
            String id_usuario = cursor.getString(cursor.getColumnIndex("id_usuarios"));

            Cursor cursor1 = bd.rawQuery("SELECT edad FROM INFORMACION WHERE id_usuarios = "+id_usuario+"", null);
            if (cursor1.moveToFirst()){
                edad = cursor.getString(cursor.getColumnIndex("edad"));
            }

        }
        return edad;
    }

    public String cargarEstatura(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        String estatura = "";
        Cursor cursor = bd.rawQuery("SELECT id_usuarios FROM USUARIOS WHERE nombre_usuario = '"+ usuario +"'",null);

        if (cursor.moveToFirst()){
            String id_usuario = cursor.getString(cursor.getColumnIndex("id_usuarios"));

            Cursor cursor1 = bd.rawQuery("SELECT estatura FROM INFORMACION WHERE id_usuarios = '"+id_usuario+"'", null);
            if (cursor1.moveToFirst()){
                estatura = cursor.getString(cursor.getColumnIndex("estatura"));
            }

        }
        return estatura;
    }

    public String cargarTipoSangre(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        String tipoSangre = "";
        Cursor cursor = bd.rawQuery("SELECT id_usuarios FROM USUARIOS WHERE nombre_usuario = '"+ usuario +"'",null);

        if (cursor.moveToFirst()){
            String id_usuario = cursor.getString(cursor.getColumnIndex("id_usuarios"));

            Cursor cursor1 = bd.rawQuery("SELECT tipo_sangre FROM INFORMACION WHERE id_usuarios = '"+id_usuario+"'", null);
            if (cursor1.moveToFirst()){
                tipoSangre = cursor.getString(cursor.getColumnIndex("tipo_sangre"));
            }

        }
        return tipoSangre;
    }

    public String cargarPadecimiento(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        String padecimientos = "";
        Cursor cursor = bd.rawQuery("SELECT id_usuarios FROM USUARIOS WHERE nombre_usuario = '"+ usuario +"'",null);

        if (cursor.moveToFirst()){
            String id_usuario = cursor.getString(cursor.getColumnIndex("id_usuarios"));

            Cursor cursor1 = bd.rawQuery("SELECT padecimientos FROM INFORMACION WHERE id_usuarios = '"+id_usuario+"'", null);
            if (cursor1.moveToFirst()){
                padecimientos = cursor.getString(cursor.getColumnIndex("padecimientos"));
            }

        }
        return padecimientos;
    }
    public String cargarAlergias(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        String alergia = "";
        Cursor cursor = bd.rawQuery("SELECT id_usuarios FROM USUARIOS WHERE nombre_usuario = '"+ usuario +"'",null);

        if (cursor.moveToFirst()){
            String id_usuario = cursor.getString(cursor.getColumnIndex("id_usuarios"));

            Cursor cursor1 = bd.rawQuery("SELECT alergias FROM INFORMACION WHERE id_usuarios = "+id_usuario+"", null);
            //if (cursor1.moveToFirst()){
               // alergia = cursor.getString(cursor.getColumnIndex("alergias"));
            //}

        }
        return alergia;
    }

    public void guardarInformacion(String usuario, String edad, String estatura, String tipoSangre, String padecimientos, String alergias){
        SQLiteDatabase bd = getReadableDatabase();

        Cursor cursor = bd.rawQuery("SELECT id_usuarios FROM USUARIOS WHERE nombre_usuario = '"+ usuario +"'",null);
        if (cursor.moveToFirst()){
            String id_usuario = cursor.getString(cursor.getColumnIndex("id_usuarios"));

            bd.execSQL("INSERT INTO INFORMACION " +
                    "(id_usuarios, edad, estatura, tipo_sangre, padecimientos, alergias) VALUES ('"+id_usuario+"','" +edad+"','" +estatura+"', '"+tipoSangre+"', '"+padecimientos+"', '"+ alergias+"')");
        }

    }

}
