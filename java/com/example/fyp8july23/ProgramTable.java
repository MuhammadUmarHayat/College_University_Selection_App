package com.example.fyp8july23;


import android.database.sqlite.SQLiteDatabase;

public class ProgramTable
{
    public static final String TABLE_NAME = "programs_table";

    public static final String COL_1 = "ID";//0
    public static final String COL_2 = "prorgram";//1
    public static final String COL_3 = "duration";//2
    public static final String COL_4 = "semester_name";//3
    public static final String COL_5 = "starting_date";
    public static final String COL_6 = "closing_date";
    public static final String COL_7 = "status";
    public static final String COL_8 = "remarks";//  String institute;
    public static final String COL_9 = "institute";//8

    public static final String COL_10 = "manager";//  String institute;
    public static final String COL_11 = "seats";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " TEXT,"
                    + COL_7 + " TEXT,"
                    + COL_8 + " TEXT,"
                    + COL_9 + " TEXT,"
                    + COL_10 + " TEXT,"
                    + COL_11 + " INTEGER"

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
