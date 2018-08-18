package com.backerror.rit.coursemanagment.Model;

public class Student {
    private int studentId;
    private String studentName;
    private String StudentDept;

    public Student(int studentId, String studentName, String studentDept) {
        this.studentId = studentId;
        this.studentName = studentName;
        StudentDept = studentDept;
    }

    public Student(String studentName, String studentDept) {
        this.studentName = studentName;
        StudentDept = studentDept;
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
}
