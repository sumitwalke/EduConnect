import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Student } from "../models/Student";
import { Teacher } from "../models/Teacher";
import { Course } from "../models/Course";
import { Enrollment } from "../models/Enrollment";
import { User } from "../models/User";
import { TeacherDTO } from "../models/TeacherDTO";
import { StudentDTO } from "../models/StudentDTO";
import { Token } from "@angular/compiler";

@Injectable({
  providedIn: "root",
})
export class EduConnectService {
  private baseUrl = `${environment.apiUrl}`;
  getStudentsByTeacherId: any;

  constructor(private http: HttpClient) {}

  getHeader(){
    const token = localStorage.getItem('token');
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorozation', `Bearer ${token}`);
    }
    return {headers};
  }

  addStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.baseUrl}/students`, student, this.getHeader());
  }

  updateStudent(student: StudentDTO): Observable<Student> {
    return this.http.put<Student>(`${this.baseUrl}/students/${student.studentId}`, student, this.getHeader());
  }

  deleteStudent(studentId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/students/${studentId}`,  this.getHeader());
  }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}/students`, this.getHeader());
  }

  getStudentById(studentId: number): Observable<Student> {
    return this.http.get<Student>(`${this.baseUrl}/students/${studentId}`, this.getHeader());
  }


  addTeacher(teacher: Teacher): Observable<Teacher> {
    return this.http.post<Teacher>(`${this.baseUrl}/teachers`, teacher,  this.getHeader());
  }

  updateTeacher(teacher: TeacherDTO): Observable<Teacher> {
    return this.http.put<Teacher>(`${this.baseUrl}/teachers/${teacher.teacherId}`, teacher, this.getHeader());
  }

  deleteTeacher(teacherId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/teachers/${teacherId}`, this.getHeader());
  }

  getAllTeachers(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(`${this.baseUrl}/teachers`, this.getHeader());
  }

  getTeacherById(teacherId: number): Observable<Teacher> {
    return this.http.get<Teacher>(`${this.baseUrl}/teachers/${teacherId}`, this.getHeader());
  }


  addCourse(course: Course): Observable<Course> {
    return this.http.post<Course>(`${this.baseUrl}/courses`, course, this.getHeader());
  }

  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.baseUrl}/courses/${course.courseId}`, course, this.getHeader());
  }

  deleteCourse(courseId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/courses/${courseId}`, this.getHeader());
  }

  getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.baseUrl}/courses`, this.getHeader());
  }

  getCourseById(courseId: number): Observable<Course> {
    return this.http.get<Course>(`${this.baseUrl}/courses/${courseId}`);
  }

  getCoursesByTeacherId(teacherId: number): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.baseUrl}/courses/teacher/${teacherId}`);
  }


  createEnrollment(enrollment: Enrollment): Observable<Enrollment> {
    return this.http.post<Enrollment>(`${this.baseUrl}/enrollments`, enrollment);
  }

  updateEnrollment(enrollment: Enrollment): Observable<Enrollment> {
    return this.http.put<Enrollment>(`${this.baseUrl}/enrollments/${enrollment.enrollmentId}`, enrollment);
  }

  getAllEnrollments(): Observable<Enrollment[]> {
    return this.http.get<Enrollment[]>(`${this.baseUrl}/enrollments`);
  }

  getEnrollmentById(enrollmentId: number): Observable<Enrollment> {
    return this.http.get<Enrollment>(`${this.baseUrl}/enrollments/${enrollmentId}`);
  }

  getEnrollmentsByCourse(courseId: number): Observable<Enrollment[]> {
    return this.http.get<Enrollment[]>(`${this.baseUrl}/enrollments/course/${courseId}`);
  }

  getEnrollmentsByStudent(studentId: number): Observable<Enrollment[]> {
    return this.http.get<Enrollment[]>(`${this.baseUrl}/enrollments/student/${studentId}`);
  }

  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/users/${userId}`);
  }
}