package com.example.quiz1mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String table_name= "table Student";
    public static final String id= "table Student";
    public static final String name= "Name";
    public static final String Email= "Email";
    public static final String Password= "Password";

    private static final String DATABASE_NAME ="mydatabase";

    DatabaseHelper myhelper;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);

        myhelper = new DatabaseHelper(context);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL( "create table Records " +
                "(id integer primary key, Name text,Email text, Password text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Records");
        onCreate(db);
    }
    public boolean insertContact (String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.insert("Records", null, contentValues);
        return true;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {DatabaseHelper.id,DatabaseHelper.name,DatabaseHelper.Password};
        Cursor cursor =db.query(DatabaseHelper.table_name,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(DatabaseHelper.id));
            String name =cursor.getString(cursor.getColumnIndex(DatabaseHelper.name));
            String  password =cursor.getString(cursor.getColumnIndex(DatabaseHelper.Password));
            buffer.append(cid+ "   " + name + "   " + password +" \n");
        }
        return buffer.toString();
    }
}
