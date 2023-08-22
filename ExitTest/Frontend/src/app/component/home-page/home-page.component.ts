import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomepageComponent implements OnInit ,OnDestroy{
  constructor( private router: Router, private api: ProductService, private http: HttpClient) { }
  product: any=[];
  productSUbscription!: Subscription;


  ngOnInit(): void {
    this.api.getProduct();
    this.product=this.api.getData();
    this.productSUbscription = this.api.getDataListener().subscribe((res) => {
      // console.log(res);
      this.product = res.data;
    });
  }
  productdetails(id: any) {
    this.router.navigateByUrl(`/product/${id}`);
  }
  onChange(s: any) {
    console.log(s.viewModel);
    this.api.getFilteredProduct({ search: null, price: s.viewModel })
    }
  ngOnDestroy(): void {
    this.productSUbscription.unsubscribe();
  }
  onReset(form:NgForm){
    form.controls["priceFilter"].setValue("");
    this.ngOnInit();
  }
}

