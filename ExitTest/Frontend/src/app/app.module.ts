import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SignupComponent} from './component/register/register.component'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './component/login-page/login-page.component';
import { ProductComponent } from './component/product/product.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { FormsModule ,ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomepageComponent } from './component/home-page/home-page.component';



@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginPageComponent,
    SignupComponent,
    ProductComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
