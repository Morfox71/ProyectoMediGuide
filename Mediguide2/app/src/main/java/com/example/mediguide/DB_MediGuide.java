package com.example.mediguide;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DB_MediGuide extends SQLiteOpenHelper {

    private static final String Nombre_BD = "MediGuide";
    private static final int VERSION_BD = 1;
    private static final String TABLA_Usuarios = "CREATE TABLE if not exists USUARIOS (id_usuarios integer PRIMARY KEY autoincrement, " +
            "nombre_usuario text, contra text, correo text)";
    private static final String TABLA_informacion = "CREATE TABLE if not exists INFORMACION (id_usuarios integer PRIMARY KEY autoincrement, " +
            "edad INT(3), estatura text, tipo_sangre text, padecimientos text, alergias text, imagen_perfil blob)";
    private static final String TABLA_tienda = "CREATE TABLE if not exists PRODUCTOS (id_producto integer PRIMARY KEY autoincrement, " +
            "precio text, descripcion text, nombre text, imagen_producto blob)";


    public DB_MediGuide(Context context){
        super(context, Nombre_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_Usuarios);
        sqLiteDatabase.execSQL(TABLA_informacion);
        sqLiteDatabase.execSQL(TABLA_tienda);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_Usuarios));
        sqLiteDatabase.execSQL(TABLA_Usuarios);
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_informacion));
        sqLiteDatabase.execSQL(TABLA_informacion);
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_tienda));
        sqLiteDatabase.execSQL(TABLA_tienda);
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
                        "(nombre_usuario, contra, correo) VALUES ('"+nombre_usuario+"','" +contra+"','" +correo+"')");
                bd.close();
            }


        }
        return accion;
    }

    public int iniciarSesion(String usuario, String contra){
        SQLiteDatabase bd = getReadableDatabase();
        int accion = 0;
        Cursor cursor = bd.rawQuery("SELECT * FROM USUARIOS WHERE nombre_usuario = '" + usuario +"'",null);
        Cursor cursor1 = bd.rawQuery("SELECT * FROM USUARIOS WHERE contra = '" + contra +"'",null);

        if (cursor.moveToFirst()){
            if (cursor1.moveToFirst()){
                accion = 1;

            }else{
                accion = 0;
            }
        }else{
            accion = 2;
        }
        return accion;


    }
}
