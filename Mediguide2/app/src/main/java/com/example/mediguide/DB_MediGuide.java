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
            bd.execSQL("INSERT INTO USUARIOS " +
                    "(nombre_usuario, contra, correo) VALUES ('"+nombre_usuario+"','" +contra+"','" +correo+"')");
            bd.close();
        }
    }

    public int iniciarSesion(String usuario, String contra){
        SQLiteDatabase bd = getReadableDatabase();
        Context context = null;
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
