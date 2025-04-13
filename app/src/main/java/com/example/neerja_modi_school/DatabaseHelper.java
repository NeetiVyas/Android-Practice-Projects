package com.example.neerja_modi_school;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="mydb.db";
    private static  final int DATABASE_VERSION=1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY="CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT,mobile TEXT,msg TEXT )";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS register");
        onCreate(db);
    }
    public boolean registerUserHelper(String name1, String email1, String mobile, String msg){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name1);
        contentValues.put("email",email1);
        contentValues.put("mobile",mobile);
        contentValues.put("msg",msg);
        long l=sqLiteDatabase.insert("register",null,contentValues);
        sqLiteDatabase.close();
        if(l>0){
            return true;
        }else{
            return false;
        }
    }
    // Method to fetch data from the database
    public Cursor showRegisterUser(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM register",null);
        return cursor;
    }
}
