import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HtmlParser } from '@angular/compiler';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user= JSON.stringify(users);
  obj= {
    "id": "1",
    "nombre": "Lucio",
    "apellido":"Burella",
    "documento":"41603130",
    "email":"lucioburella@live.com",
    "contraseña":"12345",
    "repetirContraseña":"12345"
}
isLoged=false
  form:FormGroup;
  constructor( private formbuilder: FormBuilder) {

    this.form=this.formbuilder.group(

      {
        email: ["", [Validators.required, Validators.email]],
        password: ["", [Validators.required, Validators.minLength(8)]]
      }
    )
  }

  ngOnInit(): void {

  }

  Mostrar(){
    var registros = [];
  console.log(this.obj.id)


  var nombre=document.querySelector('#nombres') as HTMLInputElement,
      apellido = document.querySelector('#apellidos') as HTMLInputElement ,
      documento = document.querySelector('#DNI')as HTMLInputElement,
      mail = document.querySelector('#Email')as HTMLInputElement,
      pass = document.querySelector('#password')as HTMLInputElement;


  var nuevoRegistro = {
    nombre: nombre.value,
    apellido: apellido.value,
    documento: documento.value,
    mail: mail.value,
    pass: pass.value
};

console.log(nuevoRegistro);
registros.push(nuevoRegistro);

var es_correcto=true;
if(this.obj.nombre!=nuevoRegistro.nombre || this.obj.apellido!=nuevoRegistro.apellido || this.obj.documento!=nuevoRegistro.documento || this.obj.email!=nuevoRegistro.mail || this.obj.contraseña!=nuevoRegistro.pass){
  es_correcto=false;
 
  
}


}





  get Email () { return this.form.get('email') }
  get Password () { return this.form.get('password') }

}
import * as users from '../../../app/database/users.json';
