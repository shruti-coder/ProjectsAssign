import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { StudentsService } from 'src/app/students.service';
@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  title!:String
  currentDate=new Date();
  constructor(private student:StudentsService,private router:Router,private route:ActivatedRoute) { }
    addStudent=new FormGroup({
      id:new FormControl(''),
     name:new FormControl(''),
     date:new FormControl(''),
     score:new FormControl('')
    });
  ngOnInit(): void {
    this.route.paramMap.subscribe((paramMap:ParamMap)=>{
      if(paramMap.has('id')){
        this.title='Edit'
        this.student.getSingleStudent(paramMap.get('id')).subscribe({
          next:(res:any)=>{
            this.addStudent.setValue(res);
          },error:(err)=>{
            console.log(err);
          }
        });
      }
      else{
        this.title='Add';
      }

    });
  }

  SaveData(){
    // console.log(this.addStudent.value);
    if(this.title==='Add'){
    this.student.saveStudentData(this.addStudent.value).subscribe((result)=>{
      console.log(result);
      this.router.navigate(['Table']);
    });
  }
  else
  {
    this.student.editStudentData(this.addStudent.value).subscribe({
      next:(result)=>{
        console.log(result);
        this.router.navigate(['Table']);
      },
      error:(err)=>{
        alert(err.statusText);
      }
    })
    

  }
}
}
