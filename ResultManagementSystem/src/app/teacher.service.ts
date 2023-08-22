import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private isAuthenticated!: boolean;
  private authListener = new Subject<boolean>();
  url = 'http://localhost:3000/teacher';
  constructor(private http: HttpClient, private router: Router) { }

  getIsAuthenticated() {
    return this.isAuthenticated;
  }
  getAuthListener() {
    return this.authListener.asObservable();
  }
  setAuthListener(isAuth: boolean) {
    this.authListener.next(isAuth);
  }
  saveToLocalStorage(isAuth: boolean, email: string) {
    localStorage.setItem("email", email);
    localStorage.setItem("isAuth", isAuth.toString());
  }
  getAuthData() {
    const email = localStorage.getItem("email");
    const isAuth = localStorage.getItem("isAuth");

    if (!email || !isAuth) return;
    return { email, isAuth };
  }

  onInit() {
    const authData = this.getAuthData();
    if (!authData) return;
    if (authData) {
      this.isAuthenticated = true;
      this.setAuthListener(true);
    }
  }

  onLogin(student: { email: string, password: string }) {
    this.http.get<any[]>(this.url).subscribe({
      next: (arr) => {
        console.log(arr)
        const authenticatedUser = arr.filter((user) =>
         user.email === student.email && user.password === student.password);
        if (authenticatedUser.length === 1) {
          this.isAuthenticated = true;
          this.setAuthListener(true);
          this.saveToLocalStorage(true, student.email);
          this.router.navigate(["/Table"])
        }
        else {
          this.isAuthenticated=false;
          this.setAuthListener(false);
          alert("Invalid Credentials!!!!");

        }
      }, error: (err) => {
        console.log(err);
      }
    })
  }

  onLogout() {
    this.isAuthenticated = false;
    this.setAuthListener(false);
    localStorage.clear();
    this.router.navigate([""]);
  }
}
