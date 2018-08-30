package com.backerror.rit.coursemanagment.Model;

public class Courses {
    private int courseId,isChecked;
    private String courseName;

    public Courses(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Courses() {

    }

    public void setIsChecked(int isChecked) {

        this.isChecked = isChecked;
    }

    public int getIsChecked() {

        return isChecked;
    }

    public Courses(int courseId, String courseName, int isChecked) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isChecked=isChecked;

    }

    public Courses(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {

        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
