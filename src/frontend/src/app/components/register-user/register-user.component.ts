import {Component, OnInit} from '@angular/core';
import {LoginUserService} from "../../services/login-user.service";
import {Router} from "@angular/router";
import {Korisnik} from "../../models";

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  firstname: string;
  lastname: string;
  username: string;
  email: string;
  password1: string;
  password2: string;
  korisnik: Korisnik;

  constructor(private loginUserService: LoginUserService, private router: Router) {
  }

  ngOnInit() {
  }


  register() {
    console.log(this.firstname);
    this.loginUserService.save(new Korisnik(null, this.firstname, this.lastname, this.username, this.email, this.password1, "k")).subscribe(user => this.korisnik, error => alert(error));

  }

}
