import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router, UrlSerializer } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class StudentsService {
  url = 'http://localhost:3000/students';
  constructor(private http: HttpClient) { }
  getAllStudent() {
    return this.http.get(this.url);
  }
  saveStudentData(data: any) {
    console.log(data);
    return this.http.post(this.url, data);

  }
  deleteStudent(id: any) {
    return this.http.delete(`${this.url}/${id}`);
  }
  getSingleStudent(id: any) {
    return this.http.get(`${this.url}/${id}`);
  }
  editStudentData(data: any) {
    console.log(data);
    return this.http.put(`${this.url}/${data.id}`, data);

  }
  onSearch() {
    return this.http.get<any[]>(this.url);
  }
}