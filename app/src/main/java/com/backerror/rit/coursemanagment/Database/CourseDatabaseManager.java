package com.backerror.rit.coursemanagment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.backerror.rit.coursemanagment.Model.Courses;

import java.util.ArrayList;

public class CourseDatabaseManager {
    private DatabaseHelper databaseHelper;

    public CourseDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public long insertCourse(Courses courses){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(DatabaseHelper.COURSE_COLUMN_NAME,courses.getCourseName());
        long insertData=sqLiteDatabase.insert(DatabaseHelper.COURSE_TABLE,null,values);
        return insertData;

    }

    public ArrayList<Courses> getAllCourse(){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getReadableDatabase();
        ArrayList<Courses>course=new ArrayList<>();
        String selectQuery="select * from "+DatabaseHelper.COURSE_TABLE;
        Cursor cursor=sqLiteDatabase.rawQuery( selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COURSE_COLUMN_ID));
                String courseName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COURSE_COLUMN_NAME));
                Courses courses=new Courses(id,courseName);
                course.add(courses);
            }while(cursor.moveToNext());
        }
        return course;
    }

}

