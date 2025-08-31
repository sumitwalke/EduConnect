package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.repository.TeacherRepository;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplJpa implements TeacherService {

    TeacherRepository teacherRepository;

    public TeacherServiceImplJpa(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>();
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        return -1;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() {
        return new ArrayList<>();
    }

}