package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    studentTeacherRepository StudentRepository;

    // add student
    public void addStudent(Student student){
      StudentRepository.addStudent(student);
    }

    //add teacher
    public void addTeacher(Teacher teacher){
        StudentRepository.addTeacher(teacher);
    }

    //add student teacher pair
    public void addStudentTeacherPair(String student,String teacher){
        StudentRepository.addStudentTeacherPair(student,teacher);
    }

    // get student by name
    public Student getStudentByName(String studentName ){
        return StudentRepository.getStudentByName(studentName);
    }

    //get teacher by name
    public Teacher getTeacherByName(String teacherName){
        return StudentRepository.getTeacherByName(teacherName);
    }

    // delete student
    public void deleteUsingId(String name){
    StudentRepository.deleteStudent(name);
    }

    //delete teacher data
    public void  deleteTeacherByName(String teacherName){
        StudentRepository.delete_teacher_by_name(teacherName);

    }

}
