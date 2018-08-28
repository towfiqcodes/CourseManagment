package com.backerror.rit.coursemanagment.Model;

public class Student {
    private int studentId;
    private String studentName;
    private String studentDept;
    private String studentPassword;
    private String studentContactNumber;
    private String studentEmail ;

    public Student(String studentName, String studentDept, String studentPassword, String studentContactNumber, String studentEmail) {
        this.studentName = studentName;
        this.studentDept = studentDept;
        this.studentPassword = studentPassword;
        this.studentContactNumber = studentContactNumber;
        this.studentEmail = studentEmail;
    }

    public Student(int studentId, String studentName, String studentDept) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDept = studentDept;
    }

    public void setStudentId(int studentId) {

        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public void setStudentContactNumber(String studentContactNumber) {
        this.studentContactNumber = studentContactNumber;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Student() {

    }

    public Student(String studentName) {
        this.studentName = studentName;

    }


    public Student(int studentId, String studentName, String studentDept, String studentPassword, String studentContactNumber, String studentEmail) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDept = studentDept;
        this.studentPassword = studentPassword;
        this.studentContactNumber = studentContactNumber;
        this.studentEmail = studentEmail;
    }

    public String getStudentName() {
        return studentName;
    }


    public String getStudentDept() {
        return studentDept;
    }


    public String getstudentPassword() {
        return studentPassword;
    }


    public String getstudentContactNumber() {
        return studentContactNumber;
    }


    public String getStudentEmail() {
        return studentEmail;
    }




}
