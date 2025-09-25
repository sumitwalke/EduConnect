import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { StudentCreateComponent } from "./components/studentcreate/studentcreate.component";
import { StudentEditComponent } from "./components/studentedit/studentedit.component";
import { TeacherCreateComponent } from "./components/teachercreate/teachercreate.component";
import { TeacherEditComponent } from "./components/teacheredit/teacheredit.component";
import { CourseCreateComponent } from "./components/coursecreate/coursecreate.component";
import { CourseEditComponent } from "./components/courseedit/courseedit.component";
import { EnrollmentComponent } from "./components/enrollment/enrollment.component";

const routes: Routes = [
  {path: "", redirectTo: "/dashboard", pathMatch: 'full'},
  {path: "dashboard", component: DashboardComponent},

  {path: "student", component: StudentCreateComponent},
  {path: "student/edit/:id", component: StudentEditComponent},

  {path: "teacher", component: TeacherCreateComponent},
  {path: "teacher/edit/:id", component: TeacherEditComponent},

  {path: "course", component: CourseCreateComponent},
  {path: "course/edit/:id", component: CourseEditComponent},

  {path: "enrollment", component: EnrollmentComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EduConnectRoutingModule {}
