package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.repository.CourseRepository;
import com.wecp.progressive.service.CourseService;

public class CourseServiceImplJpa implements CourseService {

    CourseRepository courseRepository;

    public CourseServiceImplJpa(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>();
    }

    @Override
    public Course getCourseById(int courseId) {
       return null;
    }

    @Override
    public Integer addCourse(Course course) {
        return -1;
    }

    @Override
    public void updateCourse(Course course) {
        
    }

    @Override
    public void deleteCourse(int courseId) {
        
    }


    
}