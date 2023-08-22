import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products!:any;
  isDeliverableMessage:boolean=false;
  message!:string;
  constructor(private api:ProductService,private router:Router,private route:ActivatedRoute, private http:HttpClient) { }

  ngOnInit(): void {
    this.api.getProductById(this.route.snapshot.params['id']).subscribe((product)=>{
      this.products=product;
      console.log(product);
    })
  }
  delivery(ship:any)
  {
    console.log(ship.value);
    this.api.onCheckShipping(ship.value.pincode).subscribe({next:(res)=>{
      this.message=`estimated delivery time : ${res.del_time} Days`;
      this.isDeliverableMessage=true;
    },error:(err)=>{
      this.message=err.error.message;
      this.isDeliverableMessage=true;
    }})
  }


}

