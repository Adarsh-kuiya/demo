package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("Students")
public class studentController
{
   @Autowired
   StudentService studentService;

    // add student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody()Student student){
    studentService.addStudent(student);
     return new ResponseEntity<>("New student added successFully",HttpStatus.CREATED);
    }

    //Add teacher
    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
     studentService.addTeacher(teacher);
     return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    //add student teacher pair
    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){
     studentService.addStudentTeacherPair(student,teacher);
     return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    // get Student by name
    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
     Student student = null; // Assign student by calling service layer method
     student=studentService.getStudentByName(name);
     return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // get Teacher by name
    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
     Teacher teacher = null; // Assign student by calling service layer method
     teacher=studentService.getTeacherByName(name);
     return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    // delete student data
    @DeleteMapping("/delete_student")
    public  ResponseEntity<String> deleteStudent(@RequestParam("name")String name){
    studentService.deleteUsingId(name);
    return new ResponseEntity<>("Student data deleted", HttpStatus.CREATED);
    }

    //delete teacher data
    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        studentService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }
 }



