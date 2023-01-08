package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class studentTeacherRepository {

    //using HashMap as database using admission no. as key and student object as value
    private HashMap<String,Student>studentDb;
    private HashMap<String,Teacher>teacherDB;
    private HashMap<String,String>studentTeacherDb;

    public studentTeacherRepository() {
        this.studentDb = new HashMap<>();
        this.teacherDB=new HashMap<>();
        this.studentTeacherDb=new HashMap<>();
    }

    //add student
    public void addStudent(Student student){
      studentDb.put(student.getName(),student);
    }

    // add teacher
   public void addTeacher(Teacher teacher){
       teacherDB.put(teacher.getName(),teacher);
   }

    //add student teacher pair
    public void addStudentTeacherPair(String student, String teacher){
        studentTeacherDb.put(student, teacher);
    }

   //get student using id
   public Student getStudentByName(String studentName){
       return studentDb.get(studentName);
   }

    //get teacher by name
    public Teacher getTeacherByName(String teacherName){
        return  teacherDB.get(teacherName);
    }



    // delete student using id
    public void deleteStudent(String name){
     studentDb.remove(name);

    }

    // delete teacher by name
    public void delete_teacher_by_name(String teacherName){
        for (String studentName : studentTeacherDb.keySet()) {
            if (studentTeacherDb.get(studentName) == teacherName) {
                if (studentDb.containsKey(studentName)) {
                    studentDb.remove(studentName);
                }
                if (teacherDB.containsKey(teacherName)) {
                    teacherDB.remove(teacherName);
                }
            }
        }
    }

}
