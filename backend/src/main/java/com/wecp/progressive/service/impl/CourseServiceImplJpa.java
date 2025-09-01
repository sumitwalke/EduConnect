package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.repository.CourseRepository;
import com.wecp.progressive.repository.TeacherRepository;
import com.wecp.progressive.service.CourseService;

@Service
public class CourseServiceImplJpa implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Course> getAllCourses() throws Exception{
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int courseId) throws Exception{
       return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public Integer addCourse(Course course) throws Exception{
        Course newCourse = courseRepository.save(course);
        return newCourse.getCourseId();
    }

    @Override
    public void updateCourse(Course course) throws Exception{
        Course updatedCourse = courseRepository.findById(course.getCourseId()).orElse(null);
        if(updatedCourse != null){
            updatedCourse.setCourseName(course.getCourseName());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setTeacherId(course.getTeacherId());
            courseRepository.save(updatedCourse);
        }
    }

    @Override
    public void deleteCourse(int courseId) throws Exception{
        Course deletedCourse = courseRepository.findById(courseId).orElse(null);
        if(deletedCourse != null){
            courseRepository.delete(deletedCourse);
        }
    }

    public List<Course> getAllCourseByTeacherId(int teacherId) { 
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesByTeacher = new ArrayList<>();
        for(Course c: courses){
            if(c.getTeacherId() == teacherId){
                coursesByTeacher.add(c);
            }
        }
        return coursesByTeacher;
    }
}