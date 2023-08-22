import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { HomepageComponent } from './component/home-page/home-page.component';
import { LoginPageComponent } from './component/login-page/login-page.component';
import { ProductComponent } from './component/product/product.component';
import {SignupComponent}  from './component/register/register.component';

const routes: Routes = [
  {
    path:'login',
    component:LoginPageComponent,
  },
  {
    path:'register',
    component: SignupComponent,
  },
  {
    path:'',
    component:HomepageComponent,
  },
  {
    path:'product/:id',
    component:ProductComponent,
    canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
