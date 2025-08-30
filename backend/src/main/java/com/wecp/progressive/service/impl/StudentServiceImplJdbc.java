package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.dao.StudentDAO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.service.StudentService;

public class StudentServiceImplJdbc implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImplJdbc(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            students = studentDAO.getAllStudents();
        } catch (Exception e) {
            System.out.println("Failed to get all students "+e.getMessage());
        }
        return students;
    }

    @Override
    public Integer addStudent(Student student) {
        Integer studentId = null;
        try {
            studentId = studentDAO.addStudent(student);
        } catch (Exception e) {
            System.out.println("Failed to add students "+e.getMessage());
        }
        return studentId;
    }

    @Override
    public List<Student> getAllStudentSortedByName() {
        List<Student> sortedStudents = new ArrayList<>();
        try {
            sortedStudents = studentDAO.getAllStudents();
            Collections.sort(sortedStudents);

        } catch (Exception e) {
            System.out.println("Failed to get all students sorted by name"+e.getMessage());
        }
        return sortedStudents;
    }

    @Override
    public void updateStudent(Student student) {
        try {
            studentDAO.updateStudent(student);
        } catch (Exception e) {
            System.out.println("Failed to update students "+e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try {
            studentDAO.deleteStudent(studentId);
        } catch (Exception e) {
            System.out.println("Failed to delete students "+e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        Student student = null;
        try {
            student = studentDAO.getStudentById(studentId);
        } catch (Exception e) {
            System.out.println("Failed to get students by ID "+e.getMessage());
        }
        return student;
    }
}