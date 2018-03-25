import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {RouterModule} from "@angular/router";
import { LoginUserComponent } from './components/login-user/login-user.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import {LoginUserService} from "./services/login-user.service";
import { HttpClientModule} from "@angular/common/http";
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import {AuthenticationService} from "./services/authentication.service";


@NgModule({
  declarations: [
    AppComponent,
    LoginUserComponent,
    RegisterUserComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'login', component: LoginUserComponent},
      {path: 'register', component: RegisterUserComponent},
      {path: 'korisnik', component: UserProfileComponent}
    ])
  ],
  providers: [LoginUserService,AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }




