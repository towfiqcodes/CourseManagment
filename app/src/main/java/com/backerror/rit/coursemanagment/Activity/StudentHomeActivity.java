package com.backerror.rit.coursemanagment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backerror.rit.coursemanagment.Adapter.StudentCourseAdapter;
import com.backerror.rit.coursemanagment.Database.CourseDatabaseManager;
import com.backerror.rit.coursemanagment.Database.StudentDatabaseManager;
import com.backerror.rit.coursemanagment.Model.Courses;
import com.backerror.rit.coursemanagment.Model.Student;
import com.backerror.rit.coursemanagment.R;

import java.util.ArrayList;
import java.util.List;

public class StudentHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = TeacherHomeActivity.class.getSimpleName();
    CourseDatabaseManager courseDatabaseManager;
    StudentDatabaseManager studentDatabaseManager;
    Courses courses;
    Student student;
    TextView userNameTv,deptNameTv;
    ListView studentLV;
    Button addButton;
    private List<Courses> coursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.home_student);
        initialization();
        objectInit();
        Toolbar toolbar=findViewById( R.id.toolbar);
        TextView titleText=toolbar.findViewById( R.id.titleText);
        setSupportActionBar(toolbar);
        titleText.setText("Student Home");
        coursesList=courseDatabaseManager.getAllCourse();
        StudentCourseAdapter adapter = new StudentCourseAdapter( coursesList, StudentHomeActivity.this);
        studentLV.setAdapter(adapter);

    }
    public void initialization(){
        studentLV=findViewById(R.id.showStudentCourse);
        userNameTv=findViewById( R.id.studentNameTV );
        deptNameTv=findViewById( R.id.studentDeptNameTV );
    }
    public void objectInit(){
        courseDatabaseManager=new CourseDatabaseManager( this);
        studentDatabaseManager=new StudentDatabaseManager( this );
        student=new Student();
        //userNameTv.setText( studentDatabaseManager.getUsername());

    }


    @Override
    public void onClick(View v) {

    }
}
