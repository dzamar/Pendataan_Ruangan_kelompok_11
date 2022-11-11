package com.example.kapasitasruang;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_coba.db";
    public static final String TB_NAME = "ruangan";
    public static final String COL_1 = "no";
    public static final String COL_2 = "kode_ruang";
    public static final String COL_3 = "kapasitas";

    //buat constuctor baru
    public Database(Context context){super(context,DB_NAME,null,1);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TB_NAME + "("+COL_1 + "int not null, " + COL_2 + "char primary key, " + COL_3 + "int not null);";
        sqLiteDatabase.execSQL(sql);
        String query = "INSERT INTO " + TB_NAME + "("+COL_1+", " +COL_2+", "+COL_3+") VALUES ('1','A101','23')";
        sqLiteDatabase.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
