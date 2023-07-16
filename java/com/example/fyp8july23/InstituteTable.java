package com.example.fyp8july23;

import android.database.sqlite.SQLiteDatabase;

public class InstituteTable
{

    public static final String TABLE_NAME = "institutes";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "name";
    public static final String COL_3 = "medium";
    public static final String COL_4 = "address";
    public static final String COL_5 = "managerid";
    public static final String COL_6 = "link";
    public static final String COL_7 = "status";
    public static final String COL_8 = "photo";
    public static final String COL_9 = "manager";
    public static final String COL_10 = "level";
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " TEXT,"
                    + COL_7 + " TEXT,"
                    + COL_8 + " blob,"
                    + COL_9 + " TEXT,"
                    + COL_10 + " TEXT"
                    + ")";
    public static void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}
