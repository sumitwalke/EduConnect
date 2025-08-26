package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Student;
import com.wecp.progressive.service.StudentService;

public class StudentServiceImplArraylist implements StudentService {

    @Override
    public List<Student> getAllStudents() {
       return new ArrayList<>();
    }

    @Override
    public Integer addStudent(Student student) {
        return -1;
    }

    @Override
    public List<Student> getAllStudentSortedByName() {
        return new ArrayList<>();
    }

    @Override
    public void emptyArrayList() {
        
    }

}