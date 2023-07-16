package com.example.fyp8july23;

import android.database.sqlite.SQLiteDatabase;

public class User_Education_Table
{
    //User_Education(String cnic, String degree, String passing_year, String board,
    // String total_marks, String marks_obtained, String percentage, String status)
    public static final String TABLE_NAME = "users_Education_Table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "cnic";
    public static final String COL_3 = "degree";
    public static final String COL_4 = "passing_year";
    public static final String COL_5 = "board";
    public static final String COL_6 = "total_marks";
    public static final String COL_7 = "marks_obtained";
    public static final String COL_8 = "percentage";
    public static final String COL_9 = "status";


    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " REAL,"
                    + COL_7 + " REAL,"
                    + COL_8 + " REAL,"
                    + COL_9 + " TEXT"

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
