package com.backerror.rit.coursemanagment.Database;

import android.content.Context;

public class TeacherDatabaseManager {
    DatabaseHelper databaseHelper;

    public TeacherDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper( context );
    }
}
