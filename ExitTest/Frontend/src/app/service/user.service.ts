import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private isAuthenticated!: boolean;
  private authListener = new Subject<boolean>();
  url = 'http://localhost:8080/users';
  constructor(private http:HttpClient,private router:Router) { }
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
    localStorage.setItem('email', email);
    localStorage.setItem('isAuth', isAuth.toString());
  }
  getAuthData() {
    const email = localStorage.getItem('email');
    const isAuth = localStorage.getItem('isAuth');
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
  onLogin(user: { email: string; password: string }) {
    this.http
      .post(this.url + '/signin', user)
      .subscribe({
        next: (res:any) => {
          console.log(res);
          if (res.isAuth) {
            this.isAuthenticated = true;
            this.setAuthListener(true);
            this.saveToLocalStorage(true, user.email);
            this.router.navigate(['']);
          } else {
            this.isAuthenticated = false;
            this.setAuthListener(false);
            alert('Invalid Credentials!!!!');
          }
        },
        error: (err:any) => {
          console.log(err);
        },
      });
  }
  onSignUp(user: any) {
    return this.http.post(this.url, user);
  }
  onLogout() {
    this.isAuthenticated = false;
    this.setAuthListener(false);
    localStorage.clear();
    this.router.navigate(['']);
  }
}
