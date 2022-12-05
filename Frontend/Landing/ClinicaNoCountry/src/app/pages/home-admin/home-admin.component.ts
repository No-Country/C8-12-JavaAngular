import { Component, OnInit } from '@angular/core';
export interface turnosPaciente {
  fecha: string ;
  hora: string;
  direccion: string;
  especialidad: string;
  profesional: string;
}

const ELEMENT_DATA: turnosPaciente[] = [
  {fecha: 'Lunes 9/12/2022', hora: '11:30 a.m', direccion:'San Martín 360, CABA', especialidad: 'Oftalmología', profesional: "Dra. Gonzalez Claudia"},
  {fecha: 'Jueves 11/11/22', hora: '10:00 a.m', direccion: 'San Martín 360, CABA', especialidad: 'Cardiología', profesional: "Dr. Perez Esteban"},
  {fecha: 'Martes 22/11/22', hora: '12:15 p.m', direccion: 'San Martín 360, CABA', especialidad: 'Dermatología', profesional: "Dra. Fernandez Liliana"},

];

/**
 * @title Binding event handlers and properties to the table rows.
 */


@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent  implements OnInit {

  displayedColumns: string[] = ['fecha', 'hora', 'direccion', 'especialidad', 'profesional'];
  dataSource = ELEMENT_DATA;


  constructor() { }

  ngOnInit(): void {
  }

}
