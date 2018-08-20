package com.backerror.rit.coursemanagment.Model;

public class Teacher {
    private int Id;
    private String teacherName;
    private String TeacherDept;
    private int teacherCourse;

    public Teacher(int id, String teacherName, String teacherDept, int teacherCourse) {
        Id = id;
        this.teacherName = teacherName;
        TeacherDept = teacherDept;
        this.teacherCourse = teacherCourse;
    }

    public Teacher(String teacherName, String teacherDept, int teacherCourse) {
        this.teacherName = teacherName;
        TeacherDept = teacherDept;
        this.teacherCourse = teacherCourse;
    }

    public int getId() {
        return Id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherDept() {
        return TeacherDept;
    }

    public int getTeacherCourse() {
        return teacherCourse;
    }
}
