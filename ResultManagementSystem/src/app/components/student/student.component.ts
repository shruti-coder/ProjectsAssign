import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentsService } from 'src/app/students.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {


  constructor(private student: StudentsService) { }
  public studentRecord!:  {
    name: string,
    date: string,
    score: number,
    id:number
}
  toggle:boolean=false;
  ngOnInit(): void {
  }
  search(searchForm: NgForm) {
    console.log(searchForm.value);
    // this.student.onSearch(searchForm.value);
    const stud = searchForm.value;
    this.student.onSearch().subscribe({
      next: (arr) => {
        let record ;
        arr.forEach((i) => { if(i.id === stud.rollNo && i.date === stud.dob) record=i });
        console.log(record)
        if (record) {
          this.studentRecord = record;
          this.toggle=true;
          console.log(this.studentRecord)
        }
        else {
          alert("No Match Found")
        }
      }
      ,
      error: (err) => {
        console.log(err);
      }
    });
  }

  searchAnother(){
    this.toggle=false;
  }
}
