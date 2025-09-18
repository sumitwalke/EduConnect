import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { EduConnectRoutingModule } from "./educonnect-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { EnrollmentComponent } from "./components/enrollment/enrollment.component";
import { StudentCreateComponent } from "./components/studentcreate/studentcreate.component";
import { TeacherCreateComponent } from "./components/teachercreate/teachercreate.component";
import { CourseCreateComponent } from "./components/coursecreate/coursecreate.component";

@NgModule({
  declarations: [
    EnrollmentComponent,
    StudentCreateComponent,
    TeacherCreateComponent,
    CourseCreateComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    
  ]
})
export class EduconnectModule {}
