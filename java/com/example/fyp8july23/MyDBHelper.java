package com.example.fyp8july23;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;


public class MyDBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 455;
    private static final String DATABASE_NAME = "my_database455";

    public MyDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        UserTable.onCreate(db);
        InstituteTable.onCreate(db);
        ProgramTable.onCreate(db);
        User_Education_Table.onCreate(db);
        User_Applied_Table.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //alter tables
        UserTable.onUpgrade(db, oldVersion, newVersion);
        InstituteTable .onUpgrade(db, oldVersion, newVersion);
        ProgramTable.onUpgrade(db, oldVersion, newVersion);
        User_Applied_Table .onUpgrade(db, oldVersion, newVersion);
        User_Education_Table.onUpgrade(db, oldVersion, newVersion);

    }
    public boolean approveCandidate(String id)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        String remarks="Your addmission is confirmd";
        String status="approved";

        values.put("remarks",remarks);
        values.put("status",status);


        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        long result =  db.update("users_Applied_Table", values, selection, selectionArgs);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean rejectCandidate(String id)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        String remarks="Your addmission is confirmd";
        String status="approved";

        values.put("remarks",remarks);
        values.put("status",status);


        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        long result =  db.update("users_Applied_Table", values, selection, selectionArgs);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean saveUser(String full_name, String father_name, String gender, String cnic, String address, String status,String user_type, String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",full_name);
        contentValues.put("father_name",father_name);
        contentValues.put("gender",gender);
        contentValues.put("cnic",cnic);
        contentValues.put("address",address);
        contentValues.put("status",status);
        contentValues.put("user_type",user_type);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = db.insert("users",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    //common function
    public Cursor getAllData(String table)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table,null);
        return res;
    }
    //common function
    public Cursor getTableData(String table,String col,String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table+" where "+col+"="+value ,null);
        return res;
    }
    public Cursor Search(String program)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query="select * from programs_table  where prorgram='"+program+"'";
        Cursor res = db.rawQuery(query,null);
        return res;
    }

    public Cursor getInstituteMedium(String Medium)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from institutes where medium='Medium'",null);
        return res;
    }
    public Cursor getInstitutelevel(String level)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from institutes where level='"+level+"'",null);
        return res;
    }

    public Cursor getCities()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select DISTINCT managerid from institutes",null);
        return res;
    }
    public Cursor getPrograms()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select DISTINCT prorgram from programs_table",null);
        return res;
    }
    //common function
    public int delete(String tableName,String id,String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, id+"= ?",new String[] {value});
    }

    //login
    public boolean isUserExists(String userID,String Password,String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where cnic='"+userID+"' and Password='"+Password+"' and user_type='"+type+"'",null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return exists;
    }

//    public boolean saveInstitutions(String name, String medium, String address, String managerid, String link, String status, Bitmap seats, String manager, String level)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name",name);
//        contentValues.put("medium",medium);
//        contentValues.put("address",address);
//        contentValues.put("managerid",managerid);
//        contentValues.put("link",link);
//        contentValues.put("status",status);
//        contentValues.put("photo",seats);
//        contentValues.put("manager",manager);
//        contentValues.put("level",level);
//
//        long result = db.insert("institutes",null ,contentValues);
//        if(result == -1)
//            return false;
//        else
//            return true;
//    }

    public boolean updateInstitute(int Id, String name, String medium, String address, String managerid, String link, String status )
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("medium",medium);
        values.put("address",address);
        values.put("managerid",managerid);
        values.put("link",link);
        values.put("status",status);


        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(Id) };

        long result =  db.update("institutes", values, selection, selectionArgs);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean saveUser_Education(String cnic, String degree, String passing_year, String board,float total_marks, float marks_obtained, float percentage, String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cnic",cnic);
        contentValues.put("degree",degree);
        contentValues.put("passing_year",passing_year);
        contentValues.put("board",board);
        contentValues.put("total_marks",total_marks);
        contentValues.put("marks_obtained",marks_obtained);
        contentValues.put("percentage",percentage);
        contentValues.put("status",status);
        long result = db.insert("users_Education_Table",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean saveUser_Applied(String user_cnic, String institute, String program,String status, String remarks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_cnic",user_cnic);
        contentValues.put("institute",institute);
        contentValues.put("program",program);
        contentValues.put("status",status);
        contentValues.put("remarks",remarks);


        long result = db.insert("users_Applied_Table",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean saveProgram(String prorgram, String duration, String semester_name, String starting_date, String closing_date, String status, String remarks, String institute,String manager,int seats)
    {//id,prorgram, duration, semester_name, starting_date,  closing_date,institute
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("prorgram",prorgram);
        contentValues.put("duration",duration);
        contentValues.put("semester_name",semester_name);
        contentValues.put("starting_date",starting_date);
        contentValues.put("closing_date",closing_date);
        contentValues.put("status",status);
        contentValues.put("remarks",remarks);
        contentValues.put("institute",institute);
        contentValues.put("manager",manager);
        contentValues.put("seats",seats);
        long result = db.insert("programs_table",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean   updateProgram(int id,String program,String duration,String semester,String start,String close,int seats,String ins, String mgr)
    {
        SQLiteDatabase db = getWritableDatabase();
//String prorgram, String duration, String semester_name, String starting_date, String closing_date,
// String status, String remarks, String institute,String manager,int seats)
        ContentValues values = new ContentValues();
        values.put("prorgram",program);
        values.put("duration",duration);
        values.put("semester_name",semester);
        values.put("starting_date",start);
        values.put("closing_date",close);
        values.put("seats",seats);
        values.put("institute",ins);
        values.put("manager",mgr);
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        long result =  db.update("programs_table", values, selection, selectionArgs);
        if(result == -1)
            return false;
        else
            return true;
    }






}
