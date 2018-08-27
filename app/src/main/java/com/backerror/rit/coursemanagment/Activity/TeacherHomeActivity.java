package com.backerror.rit.coursemanagment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.backerror.rit.coursemanagment.Adapter.CourseAdapter;
import com.backerror.rit.coursemanagment.Database.CourseDatabaseManager;
import com.backerror.rit.coursemanagment.Model.Courses;
import com.backerror.rit.coursemanagment.R;

import java.util.ArrayList;
import java.util.List;

public class TeacherHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = TeacherHomeActivity.class.getSimpleName();
    CourseDatabaseManager courseDatabaseManager;
    Courses courses;
    EditText createET;
    Button createBTN;
    ListView courseLV;
    private List<Courses> coursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_teacher);
        initialization();
        objectInit();
        coursesList=courseDatabaseManager.getAllCourse();
        CourseAdapter adapter = new CourseAdapter( coursesList, TeacherHomeActivity.this);
        courseLV.setAdapter(adapter);

    }

    public void initialization(){
        createET=findViewById(R.id.createCourse);
        createBTN=findViewById(R.id.createBtn);
        courseLV=findViewById(R.id.showCourse);

    }
    public void objectInit(){
        createBTN.setOnClickListener(this);
        courseDatabaseManager=new CourseDatabaseManager( this);

    }


    public boolean checkValidity() {
        View focusView = null;
        boolean cancel = false;
        String name = createET.getText().toString();

        if (TextUtils.isEmpty( name)) {
            //focusView=userName;
            cancel = true;
            createET.setError("Enter the Course name");
        }
        return cancel;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        String courseName=createET.getText().toString();

        if(id== R.id.createBtn){
            if (checkValidity()){
            }else{


                courses=new Courses( courseName);
                long insertRow=courseDatabaseManager.insertCourse(courses);
                if(insertRow>0){
                    Toast t = Toast.makeText( getApplicationContext(), "Data inserted! "+ insertRow, Toast.LENGTH_LONG);
                    t.show();

                }else{
                    Toast t = Toast.makeText(getApplicationContext(), "Data not inserted! ", Toast.LENGTH_LONG);
                    t.show();
                }

            }


        }

    }
}
