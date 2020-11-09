package com.example.mediguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_MediGuide extends SQLiteOpenHelper {

    private static final String Nombre_BD = "MediGuide.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_Usuarios = "CREATE TABLE USUARIOS(id_usuarios TINYINT PRIMARY KEY, " +
            "nombre_usuario VARCHAR(50), contra VARCHAR(50), correo VARCHAR(50))";

    public DB_MediGuide(Context context){
        super(context, Nombre_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_Usuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLA_Usuarios));
        sqLiteDatabase.execSQL(TABLA_Usuarios);

    }

    public void agregarUsuarios(String nombre_usuario, String contra, String correo){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null){
            bd.execSQL("INSERT INTO USUARIOS VALUES('"+ nombre_usuario +"','"+contra+"','"+correo+"')");
            bd.close();
        }
    }
}
