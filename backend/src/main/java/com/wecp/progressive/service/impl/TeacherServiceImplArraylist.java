package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplArraylist implements TeacherService {

    @Override
    public List<Teacher> getAllTeachers(){
        return new ArrayList<>();
    }

    @Override
    public Integer addTeacher(Teacher teacher){
        return -1;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience(){
        return new ArrayList<>();
    }

    @Override
    public void emptyArrayList() {
        
    }
    
}