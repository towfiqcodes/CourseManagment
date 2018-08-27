package com.backerror.rit.coursemanagment.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.backerror.rit.coursemanagment.Model.Courses;
import com.backerror.rit.coursemanagment.R;

import java.util.List;

public class CourseAdapter extends BaseAdapter {
    private List<Courses> coursesList;
    private Context context;

    public CourseAdapter(List<Courses> coursesList, Context context) {
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
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.show_all_course, parent, false);
        Courses courses = coursesList.get(position);

        TextView courseName = view.findViewById( R.id.showData);
        courseName.setText(courses.getCourseName());
        Button button=view.findViewById( R.id.showBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
