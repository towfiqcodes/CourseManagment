package com.backerror.rit.coursemanagment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

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
    ImageButton createBTN;
    ImageButton edit, delete;
    SearchView searchView;
    ListView courseLV;
    List <Courses> coursesList = new ArrayList <>();
    int selectedId = 0;
    boolean updateData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.home_teacher );
        initialization();
        objectInit();
        updateMethod();
        toolbarMethod();
       coursesList=courseDatabaseManager.getAllCourse();
        ArrayList<String>searchList=new ArrayList<>();
        for(Courses course:coursesList){
            searchList.add(course.getCourseName());
        }
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, searchList);
        courseLV.setAdapter( adapter );
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter( newText );
                //Toast.makeText( TeacherHomeActivity.this,"Query is "+ text,Toast.LENGTH_LONG).show();
                return true;
            }
        } );


    }

    public void initialization() {
        createET = findViewById( R.id.createCourse );
        createBTN = findViewById( R.id.createBtn );
        courseLV = findViewById( R.id.showCourse );
        searchView=findViewById( R.id.searchV );
        edit = findViewById( R.id.editBtn );
        delete = findViewById( R.id.deleteBtn );


    }

    public void objectInit() {
        createBTN.setOnClickListener( this );
        delete.setOnClickListener( this );
        edit.setOnClickListener( this );
        courseDatabaseManager = new CourseDatabaseManager( this );

    }


    public boolean checkValidity() {
        View focusView = null;
        boolean cancel = false;
        String name = createET.getText().toString();

        if (TextUtils.isEmpty( name )) {
            //focusView=userName;
            cancel = true;
            createET.setError( "Enter the Course name" );
        }
        return cancel;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String courseName = createET.getText().toString();

        if (id == R.id.createBtn) {
            if (checkValidity()) {
            } else {


                courses = new Courses( courseName );
                long insertRow = courseDatabaseManager.insertCourse( courses );
                if (insertRow > 0) {
                    Toast t = Toast.makeText( getApplicationContext(), "Data inserted! " + insertRow, Toast.LENGTH_LONG );
                    t.show();

                } else {
                    Toast t = Toast.makeText( getApplicationContext(), "Data not inserted! ", Toast.LENGTH_LONG );
                    t.show();
                }

            }


        } else if (id == R.id.editBtn) {
            if(updateData) {
                Courses courses = new Courses( selectedId, createET.getText().toString() );
                long update = courseDatabaseManager.courseUpdate( courses );
                if (update > 0) {
                    Toast t = Toast.makeText( getApplicationContext(), "Data updated ", Toast.LENGTH_LONG );
                    t.show();
                } else {
                    Toast t = Toast.makeText( getApplicationContext(), "Data not updated ", Toast.LENGTH_LONG );
                    t.show();
                }
            }
        }else if (id == R.id.deleteBtn) {
                long result = courseDatabaseManager.deleteCourse( courseName );
                if (result > 0) {
                    Toast t = Toast.makeText( getApplicationContext(), "Data Deleted! " + result, Toast.LENGTH_LONG );
                    t.show();
                    startActivity( new Intent( TeacherHomeActivity.this, TeacherHomeActivity.class ) );

                } else {
                    Toast t = Toast.makeText( getApplicationContext(), "Data not Deleted! ", Toast.LENGTH_LONG );
                    t.show();
                }
            }

        }
        public void updateMethod(){
            coursesList = courseDatabaseManager.getAllCourse();
            ArrayList<String>listForDisplay=new ArrayList<>();
            for(Courses course:coursesList){
                listForDisplay.add(course.getCourseName());
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, listForDisplay);
            courseLV.setAdapter( adapter );
            courseLV.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                    selectedId = coursesList.get( position ).getCourseId();
                    Courses courses=courseDatabaseManager.getCourseById( selectedId );
                    createET.setText( courses.getCourseName() );
                    updateData = true;

                }
            } );
        }
        public void toolbarMethod(){

            Toolbar toolbar = findViewById( R.id.toolbar );
            TextView titleText = toolbar.findViewById( R.id.titleText );
            setSupportActionBar( toolbar );
            titleText.setText( "Teacher Home" );
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowHomeEnabled( true );
                getSupportActionBar().setDisplayHomeAsUpEnabled( true );
            }

        }
}
