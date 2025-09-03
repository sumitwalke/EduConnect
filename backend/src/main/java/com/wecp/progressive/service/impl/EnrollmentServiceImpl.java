package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Enrollment;
import com.wecp.progressive.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    EnrollmentService enrollmentService;

    @Override
    public int createEnrollment(Enrollment enrollment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEnrollment'");
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEnrollment'");
    }

    @Override
    public Enrollment getEnrollmentById(int enrollmentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEnrollmentById'");
    }

    @Override
    public List<Enrollment> getAllEnrollmentsByStudent(int studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEnrollmentsByStudent'");
    }

    @Override
    public List<Enrollment> getAllEnrollmentsByCourse(int courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEnrollmentsByCourse'");
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEnrollments'");
    }

    
}