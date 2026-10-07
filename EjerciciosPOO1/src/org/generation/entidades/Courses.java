package org.generation.entidades;

import java.util.ArrayList;

public class Courses {
    String courseName;
    String professorName;
    int year;
    ArrayList<Student> students;

    public Courses(String courseName, String professorName, int year){
        this.courseName = courseName.toUpperCase();
        this.professorName = professorName.toUpperCase();
        this.year = year;
        this.students = new ArrayList<>();
    }// constructor Courses

    public void enroll(Student student){
        this.students.add(student);
    }// enroll

    public void enroll(Student[] students){
        for(Student student: students){
            this.enroll(student);
        }// forEach
    }// enroll

    public void unEnroll(Student student){
        //TODO remove this student from the collection
        // Hint: check if that really is this student
        Student tempStudent = student;

        for(Student std: students){
            if(tempStudent.equals(std)){
                tempStudent = std;
                break;
            }// if
        }// forEach

        this.students.remove(tempStudent);

    }// unEnroll

    public int countStudents(){
        return this.students.size();
    }// countStudents

    public int bestGrade(){
        int max = 0;

        for(Student student: this.students){
            if(student.grade > max){
                max = student.grade;
            }// if
        }// forEach

        return max;
    }// bestGrade



    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", professorName='" + professorName + '\'' +
                ", year=" + year +
                ", students=" + students +
                '}';
    }// toString


    public void isAboveAverage() {
         double promedio =  average();
        for(Student student: students){
            if(student.grade > promedio){
                System.out.println(student.firstName + " Esta por encima del promedio " );
            }else {
                System.out.println(student.firstName + " No esta por encima del promedio " );
            }//if

        }//forEach

    }//isAboveAverage

    public void ranking() {
        students.sort((s2, s1) -> Integer.compare(s1.grade, s2.grade));
       

    }

    public double average() {
         int suma = 0;
        for(Student student: students){
            suma =+ student.grade;
        }//for
        return (double) suma /students.size();
    }//average
}//Courses
