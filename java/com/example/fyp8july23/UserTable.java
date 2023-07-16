package com.example.fyp8july23;


import android.database.sqlite.SQLiteDatabase;

public class UserTable
{
    //String full_name, String father_name, String gender, String cnic, String address, String status,
// String user_type, String email, String password)
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "full_name";
    public static final String COL_3 = "father_name";
    public static final String COL_4 = "gender";
    public static final String COL_5 = "cnic";
    public static final String COL_6 = "address";
    public static final String COL_7 = "status";
    public static final String COL_8 = "user_type";
    public static final String COL_9 = "email";
    public static final String COL_10 = "password";



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
