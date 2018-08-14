package com.backerror.rit.coursemanagment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME="course_db";

    private static final String STUDENT_TABLE_NAME="student_db";
    private static final String STUDENT_COLUMN_NAME="student_name";
    private static final String STUDENT_COLUMN_ID="student_id";
    private static final String STUDENT_COLUMN_DEPT_NAME="student_department";

    private static final String DROP_TABLE_STUDENT="DROP TABLE IF EXISTS "+STUDENT_TABLE_NAME;

    private static final String CREATE_STUDENT_TABLE="CREATE TABLE "
            +STUDENT_TABLE_NAME+ "("+STUDENT_COLUMN_NAME+" VARCHAR(25),"
            +STUDENT_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +STUDENT_COLUMN_DEPT_NAME +" VARCHAR(25)" + ")";


    private static final String TEACHER_TABLE_NAME="teacher_db";
    private static final String TEACHER_COLUMN_NAME="teacher_name";
    private static final String TEACHER_COLUMN_ID="teacher_id";
    private static final String TEACHER_COLUMN_DEPT_NAME="teacher_department";

    private static final String DROP_TABLE_TEACHER="DROP TABLE IF EXISTS "+TEACHER_TABLE_NAME;

    private static final String CREATE_TEACHER_TABLE="CREATE TABLE "
            +TEACHER_TABLE_NAME+ "("+TEACHER_COLUMN_NAME+" VARCHAR(25),"
            +TEACHER_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TEACHER_COLUMN_DEPT_NAME + " VARCHAR(25)" + ")";






    public DatabaseHelper(Context context) {
        super( context, DATABASE_NAME, null, VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( CREATE_STUDENT_TABLE );
        db.execSQL( CREATE_TEACHER_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( DROP_TABLE_STUDENT );
        db.execSQL( DROP_TABLE_TEACHER );
        onCreate( db );
    }
}
