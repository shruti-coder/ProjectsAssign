import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url = 'http://localhost:8080';
  private data: any = [];
  private dataListener = new Subject<{ data: any }>();

  constructor(private http: HttpClient) {}
  getData() {
    return this.data;
  }
  setData(data: any) {
    this.data = data;
  }

  getDataListener() {
    return this.dataListener.asObservable();
  }
  setDataListener(data: any) {
    this.dataListener.next({ data: data });
  }

  getProduct() {
    return this.http.get<any>(this.url + '/products').subscribe({
      next: (res: any) => {
        this.setData(res);
        this.setDataListener(res);
      },
      error: (err: any) => {
        console.log(err);
      },
    });
  }
  getProductById(id: any) {
    return this.http.get<any>(`${this.url}/products/${id}`);
  }
  onCheckShipping(pincode: any) {
    return this.http.get<any>(`${this.url}/shipDetails/${pincode}`);
  }
  getFilteredProduct(filter: { search: any; price: any }) {
    let path = this.url + '/products?';
    if (filter.search !== null) path += `search=${filter.search}&`;
    if (filter.price !== null) path += `price=${filter.price}&`;
    console.log(typeof filter.price);
    return this.http.get<any>(path).subscribe({
      next: (res) => {
        console.log(res);
        this.setData(res);
        this.setDataListener(res);
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}




