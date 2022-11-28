import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
 
  number?: number;
  password?: string;

  constructor() { }

  login() {
    console.log(this.number);
    console.log(this.password);
  }
  

}
