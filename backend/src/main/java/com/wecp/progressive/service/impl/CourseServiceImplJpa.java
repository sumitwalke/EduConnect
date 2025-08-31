package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.repository.CourseRepository;
import com.wecp.progressive.service.CourseService;

@Service
public class CourseServiceImplJpa implements CourseService {

    CourseRepository courseRepository;

    public CourseServiceImplJpa(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

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


    
}