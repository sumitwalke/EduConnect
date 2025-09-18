
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
    selector: 'app-course-create',
    templateUrl: './coursecreate.component.html',
    styleUrls: ['./coursecreate.component.scss']
})
export class CourseCreateComponent {
    courseForm: FormGroup;
    submitted = false;
    successMessage = '';
    errorMessage = '';
    constructor(private fb: FormBuilder) {
        this.courseForm = this.fb.group({
            courseId: [0],
            courseName: ['', Validators.required],
            description: ['', [Validators.required, Validators.maxLength(500)]],
            teacherId: [, [Validators.required, Validators.pattern(/^\d+$/)]]
        });
    }
    get f() {
        return this.courseForm.controls;
    }
    onSubmit(): void {
        this.submitted = true;
        this.successMessage = '';
        this.errorMessage = '';
        if (this.courseForm.invalid) {
            this.errorMessage = 'Please fix errors in the form.';
            return;
        }
        console.log('Course Created:', this.courseForm.value);
        this.successMessage = 'Course created successfully!';
        this.courseForm.reset();
        this.submitted = false;
    }
    resetForm(): void {
        this.courseForm.reset();
        this.submitted = false;
        this.successMessage = '';
        this.errorMessage = '';
    }
}
