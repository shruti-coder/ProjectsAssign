import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { TeacherService } from 'src/app/teacher.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  userIsAuthenticated: boolean = true;
  authSub!: Subscription;
  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.userIsAuthenticated = this.teacherService.getIsAuthenticated();
    this.authSub = this.teacherService.getAuthListener().subscribe({ next: (isAuth: boolean) => { this.userIsAuthenticated = isAuth }, error: (err) => { console.log(err) } })
  }
  onLogout() {
    this.teacherService.onLogout();
  }
  ngOnDestroy(): void {
    this.authSub.unsubscribe();
  }

}
