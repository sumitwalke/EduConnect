package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.dao.TeacherDAO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplJdbc implements TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherServiceImplJdbc(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            teachers = teacherDAO.getAllTeachers();
        } catch (Exception e) {
            System.out.println("Failed to get all teachers "+e.getMessage());
        }
        return teachers;
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        Integer teacherId = null;
        try {
            teacherId = teacherDAO.addTeacher(teacher);
        } catch (Exception e) {
            System.out.println("Failed to add teachers "+e.getMessage());
        }
        return teacherId;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() {
        List<Teacher> sortedTeachers = new ArrayList<>();
        try {
            sortedTeachers = teacherDAO.getAllTeachers();
            Collections.sort(sortedTeachers);

        } catch (Exception e) {
            System.out.println("Failed to get all teachers sorted by experience"+e.getMessage());
        }
        return sortedTeachers;
    }

    public void updateTeacher(Teacher teacher) {
        try {
            teacherDAO.updateTeacher(teacher);
        } catch (Exception e) {
            System.out.println("Failed to update teachers "+e.getMessage());
        }
    }

    public void deleteTeacher(int teacherId) {
        try {
            teacherDAO.deleteTeacher(teacherId);
        } catch (Exception e) {
            System.out.println("Failed to delete teachers "+e.getMessage());
        }
    }

    public Teacher getTeacherById(int teacherId) {
        Teacher teacher = null;
        try {
            teacher = teacherDAO.getTeacherById(teacherId);
        } catch (Exception e) {
            System.out.println("Failed to get teachers by ID "+e.getMessage());
        }
        return teacher;
    }

}