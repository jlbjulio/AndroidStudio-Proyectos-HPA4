package com.example.taller_27_basedato_con_alertdialog_20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String dbname = "EstudianteA";

    public BaseDatos(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "CREATE TABLE users (Id INTEGER PRIMARY KEY, Nombre TEXT, Correo TEXT, Contraseña TEXT)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean Insertar(String nom, String cor, String con) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", nom);
        contentValues.put("Correo", cor);
        contentValues.put("Contraseña", con);
        long i = db.insert("users", null, contentValues);
        return i != -1;
    }

    public boolean Eliminar(String cor) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE Correo=?", new String[]{cor});
        if (cursor.getCount() > 0) {
            long e = db.delete("users", "Correo=?", new String[]{cor});
            return e != -1;
        } else
            return false;
    }

    public boolean Modificar(String nom, String cor, String con) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", nom);
        contentValues.put("Correo", cor);
        contentValues.put("Contraseña", con);
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE Correo=?", new String[]{cor});
        if (cursor.getCount() > 0) {
            long m = db.update("users", contentValues, "Correo=?", new String[]{cor});
            return m != -1;
        } else
            return false;
    }


    public Cursor getinfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        return cursor;
    }


}