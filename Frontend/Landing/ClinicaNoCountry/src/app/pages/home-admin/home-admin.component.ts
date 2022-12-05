import { Component, OnInit } from '@angular/core';
export interface turnosPaciente {
  paciente: string;
  fecha: string;
  hora: string;
  identidad: string;
  estado: string;
  
}

const ELEMENT_DATA: turnosPaciente[] = [
  {
    fecha: 'Lunes 9/12/2022',
    hora: '11:30 a.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Oftalmología',
    paciente: 'Farias, Pedro',
  },
  {
    fecha: 'Jueves 11/11/22',
    hora: '10:00 a.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Cardiología',
    paciente: 'Salutri, Juana',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Dermatología',
    paciente: 'Fuentes, Marcelo',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Dermatología',
    paciente: 'Garcia, Lautaro',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Dermatología',
    paciente: 'Martinez, Julieta',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Dermatología',
    paciente: 'Hernández, Laura',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Dermatología',
    paciente: 'Perez, Julian',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: 'San Martín 360, CABA',
    estado: 'Dermatología',
    paciente: 'Munro, Esteban',
  },
];

/**
 * @title Binding event handlers and properties to the table rows.
 */

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css'],
})
export class HomeAdminComponent implements OnInit {
  displayedColumns: string[] = [
    'paciente',
    'fecha',
    'hora',
    'identidad',
    'estado',
  ];
  dataSource = ELEMENT_DATA;

  constructor() {}

  ngOnInit(): void {}
}
