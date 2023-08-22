import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { StudentComponent } from './components/student/student.component';
import { TableComponent } from './components/table/table.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { FrontResultComponent } from './components/front-result/front-result.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {
    path: "",
    component: FrontResultComponent
  },
    {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'edit/:id',
    component: AddStudentComponent,
    canActivate: [AuthGuard]

  },
  {
    path: 'Studentlogin',
    component: StudentComponent
  },
  {
    path: 'Table',
    component: TableComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'StudentForm',
    component: AddStudentComponent,
    canActivate: [AuthGuard]

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
