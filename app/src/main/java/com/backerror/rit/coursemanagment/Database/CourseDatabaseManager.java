package com.backerror.rit.coursemanagment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.backerror.rit.coursemanagment.Model.Courses;

import java.util.ArrayList;

import static com.backerror.rit.coursemanagment.Database.DatabaseHelper.COURSE_TABLE;

public class CourseDatabaseManager {
    private DatabaseHelper databaseHelper;

    public CourseDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public long insertCourse(Courses courses){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(DatabaseHelper.COURSE_COLUMN_NAME,courses.getCourseName());
        values.put( DatabaseHelper.COURSE_IS_CHECKED,courses.getIsChecked());
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
    public long insertIschecked(Courses courses){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(DatabaseHelper.COURSE_IS_CHECKED,courses.getIsChecked());
        long insertData=sqLiteDatabase.insert(DatabaseHelper.COURSE_TABLE,null,values);
        return insertData;

    }
    public long deleteCourse(String id) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        long idt=  sqLiteDatabase.delete(COURSE_TABLE,  DatabaseHelper.COURSE_COLUMN_NAME+ " =? ",new String[]{id});
        sqLiteDatabase.close();

        return idt;
    }
    public long courseUpdate(Courses courses){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put( DatabaseHelper.COURSE_COLUMN_NAME,courses.getCourseName());
        long updateQuery=sqLiteDatabase.update( DatabaseHelper.COURSE_TABLE,values,
                                                DatabaseHelper.COURSE_COLUMN_ID+" =? ", new String[]{String.valueOf( courses.getCourseId())});
        return  updateQuery;

    }
    public Courses getCourseById(int id){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getReadableDatabase();
        String selectQuery="select * from " + DatabaseHelper.COURSE_TABLE+" where " +DatabaseHelper.COURSE_COLUMN_ID + " = " + id;
        Cursor cursor=sqLiteDatabase.rawQuery( selectQuery,null );
        Courses courses=null;
        if(cursor.moveToFirst()){
            String courseName=cursor.getString( cursor.getColumnIndex( DatabaseHelper.COURSE_COLUMN_NAME ) );
            courses=new Courses(id,courseName);
        }

        return  courses;
    }

}

