import { Component, OnInit } from '@angular/core';
import { NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class SignupComponent implements OnInit {
  isSubmitted: boolean = false;
  constructor(private user: UserService, private router: Router) {}

  ngOnInit(): void {}
  signup(form: NgForm) {
    console.log(form.value);
    this.isSubmitted = true;
    if (form.invalid) {
      return;
    }
    this.user.onSignUp(form.value).subscribe({
      next: (res) => {
        console.log(res);
        alert('user created Successfully');
        this.router.navigateByUrl('/login');
      },
      error: (err) => {
        console.log(err);

        alert('Something went wrong!!!');
      },
    });
  }
}


