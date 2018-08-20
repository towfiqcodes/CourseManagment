package com.backerror.rit.coursemanagment.Database;

import android.content.Context;

import static android.content.Context.MODE_PRIVATE;

public class TeacherDatabaseManager {
    DatabaseHelper databaseHelper;

    public TeacherDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper( context );
    }
}
