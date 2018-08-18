package com.backerror.rit.coursemanagment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.backerror.rit.coursemanagment.Model.Student;

public class StudentDatabaseManager  {
    DatabaseHelper databaseHelper;

    public StudentDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper( context );
    }
    public long addStudentData(Student student){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.STUDENT_COLUMN_NAME,student.getStudentName());
        values.put( DatabaseHelper.STUDENT_COLUMN_DEPT_NAME,student.getStudentDept());
        long insertData=sqLiteDatabase.insert( DatabaseHelper.STUDENT_TABLE_NAME,null,values);
        sqLiteDatabase.close();
        return  insertData;
    }

}
