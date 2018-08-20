package com.backerror.rit.coursemanagment.Model;

public class Student {
    private int studentId;
    private String studentName;
    private String StudentDept;
    private int studentCourse;



    public Student(int studentId, String studentName, String studentDept, int studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.StudentDept = studentDept;
        this.studentCourse=studentCourse;

    }

    public Student(String studentName, String studentDept,int studentCourse) {
        this.studentName = studentName;
        this.StudentDept = studentDept;
        this.studentCourse=studentCourse;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentDept() {
        return StudentDept;
    }
    public int getStudentCourse() {
        return studentCourse;
    }
}
