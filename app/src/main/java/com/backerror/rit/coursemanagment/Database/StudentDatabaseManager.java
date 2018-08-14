package com.backerror.rit.coursemanagment.Database;

import android.content.Context;

public class StudentDatabaseManager  {
    DatabaseHelper databaseHelper;

    public StudentDatabaseManager(Context context) {
        databaseHelper=new DatabaseHelper( context );
    }

}
