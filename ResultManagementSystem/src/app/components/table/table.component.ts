import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentsService } from '../../students.service';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor(private student: StudentsService,public router:Router) { }
  studentData: any = [];
  ngOnInit(): void {
    this.student.getAllStudent().subscribe((allData) => {
      console.log(allData);
      this.studentData = allData;
    });
  }

  deleteStudent(id: any) {
    this.student.deleteStudent(id).subscribe({
      next: (res) => {
        console.log(res);
        this.ngOnInit();
      }, error: (err) => {
        console.log(err)
      }
    })
  }
  addStudent(){
    this.router.navigate(['StudentForm'])
  }
 editStudent(id:any){
  this.router.navigateByUrl(`/edit/${id}`)
 }
}
