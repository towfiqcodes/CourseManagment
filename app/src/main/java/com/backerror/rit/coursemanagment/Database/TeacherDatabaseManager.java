package com.backerror.rit.coursemanagment.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.backerror.rit.coursemanagment.Model.Teacher;

import static android.content.Context.MODE_PRIVATE;

public class TeacherDatabaseManager {
    private DatabaseHelper databaseHelper;

    public TeacherDatabaseManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public long addTeacherData(Teacher teacher) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.TEACHER_COLUMN_NAME, teacher.getTeacherName());
        values.put(DatabaseHelper.TEACHER_COLUMN_DEPT_NAME, teacher.getTeacherDept());
        values.put(DatabaseHelper.TEACHER_COLUMN_CONTACT, teacher.getteacherContactNumber());
        values.put(DatabaseHelper.TEACHER_COLUMN_EMAIL, teacher.getteacherEmail());
        values.put(DatabaseHelper.TEACHER_COLUMN_PASS, teacher.getTeacherPassword());
        long insertData = sqLiteDatabase.insert(DatabaseHelper.TEACHER_TABLE_NAME, null, values);
        sqLiteDatabase.close();
        return insertData;
    }

    public Boolean findPassword(String uname, String upassword) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery( "SELECT * FROM " + DatabaseHelper.TEACHER_TABLE_NAME, null);
        boolean result = false;
        if (cursor.getCount() == 0) {
            //Toast t=Toast.makeText(teacherDatabaseManager.this,"No data found! ",Toast.LENGTH_LONG);
            // t.show();
        } else {
            while (cursor.moveToNext()) {
                String userName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TEACHER_COLUMN_NAME));
                String userPass = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TEACHER_COLUMN_PASS));
                if (userName.equals(uname) && userPass.equals(upassword)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}

