import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { TeacherService } from 'src/app/teacher.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  authSub!: Subscription;
  isAuthenticated: boolean = false;
  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.isAuthenticated = this.teacherService.getIsAuthenticated();
    this.authSub=this.teacherService.getAuthListener().subscribe({next: (isAuth)=>{this.isAuthenticated = isAuth}, error: (err)=>{console.log(err)}})
  }
login(form:NgForm){
  console.log(form.value);
  this.teacherService.onLogin(form.value);
}
ngOnDestroy(): void {
  this.authSub.unsubscribe()
}

}
