package com.example.fyp8july23;

import android.database.sqlite.SQLiteDatabase;

public class User_Applied_Table
{

    public static final String TABLE_NAME = "users_Applied_Table";

    //String user_cnic, String institute, String program,
    // String status, String remarks)
    public static final String COL_1 = "id";
    public static final String COL_2 = "user_cnic";
    public static final String COL_3 = "institute";
    public static final String COL_4 = "program";
    public static final String COL_5 = "status";
    public static final String COL_6 = "remarks";




    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " TEXT"
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
