import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ProductService } from 'src/app/service/product.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit,OnDestroy {
  userIsAuth: boolean = false;
  authSub!: Subscription;

  constructor(private user: UserService, public router: Router,private api:ProductService) { }

  ngOnInit(): void {
    this.userIsAuth = this.user.getIsAuthenticated();
    this.authSub = this.user.getAuthListener().subscribe({
      next: (isAuth: boolean) => {
        this.userIsAuth = isAuth;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  onLogout() {
    this.user.onLogout();
  }
  ngOnDestroy(): void {
    this.authSub.unsubscribe();
  }
  searchF(form: NgForm) {
    this.api.getFilteredProduct({ search: form.value.search, price: null });
  }
}
