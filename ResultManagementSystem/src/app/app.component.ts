import { Component, OnInit } from '@angular/core';
import { TeacherService } from './teacher.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ResultManagementSystem';
 
  constructor(private teacherService: TeacherService){}
  ngOnInit(): void {
    this.teacherService.onInit();
  }
  
}
