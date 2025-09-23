import { Component, OnInit } from '@angular/core';
import { EduConnectService } from '../../services/educonnect.service';
import { Teacher } from '../../models/Teacher';
import { Course } from '../../models/Course';
import { Student } from '../../models/Student';
import { Enrollment } from '../../models/Enrollment';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {
  role!: string;
  userId!: number;
  studentId!: number;
  teacherId!: number;
  studentDetails!: Student;
  teacherDetails!: Teacher;
  courses: Course[] = [];
  enrollments: Enrollment[] = [];
  students: Student[] = [];
  teachers: Teacher[] = [];

  constructor(private service: EduConnectService) {}

  ngOnInit(): void {
    this.role = localStorage.getItem('role') || '';
    this.userId = Number(localStorage.getItem('user_id'));
    this.teacherId = Number(localStorage.getItem('teacher_id'));
    this.studentId = Number(localStorage.getItem('teacher_id'));

    if (this.role === 'TEACHER') {
      this.loadTeacherData();
    } 
    if(this.role === 'STUDENT') {
      this.loadStudentData();
    }
  }

  loadTeacherData(): void {
    this.service.getTeacherById(this.teacherId).subscribe((res) => {
      this.teacherDetails = res;
    });

    this.service.getCoursesByTeacherId(this.teacherId).subscribe((res) => {
      this.courses = res;
    });

    this.service.getAllStudents().subscribe((res) => {
      this.students = res;
    });
  }

  loadStudentData(): void {
    this.service.getStudentById(this.studentId).subscribe((res) => {
      this.studentDetails = res;
    });

    this.service.getEnrollmentsByStudent(this.studentId).subscribe((res) => {
      this.enrollments = res;
    });

    this.service.getAllTeachers().subscribe((res) => {
      this.teachers = res;
    });
  }
}