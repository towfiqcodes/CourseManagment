package com.backerror.rit.coursemanagment.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.backerror.rit.coursemanagment.Model.Courses;
import com.backerror.rit.coursemanagment.R;

import java.util.List;

public class StudentCourseAdapter extends BaseAdapter {
    private List<Courses> coursesList;
    private Context context;

    public StudentCourseAdapter(List<Courses> coursesList, Context context) {
        this.coursesList = coursesList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return coursesList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater
                .from(context)
                .inflate( R.layout.show_student_course, parent, false);
        Courses courses = coursesList.get(position);
        CheckBox checkBox=view.findViewById( R.id.checkData );
        TextView courseName = view.findViewById( R.id.showCourseData);
        courseName.setText(courses.getCourseName());
        if (courses.getIsChecked() == 0)
            checkBox.setChecked(false);
        else
            checkBox.setChecked(true);
        checkBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        } );

        return view;
    }

}
