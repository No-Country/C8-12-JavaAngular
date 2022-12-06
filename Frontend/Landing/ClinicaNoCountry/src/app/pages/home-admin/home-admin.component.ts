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
    identidad: '30.628.248',
    estado: 'Activo',
    paciente: 'Farias, Pedro',
  },
  {
    fecha: 'Jueves 11/11/22',
    hora: '10:00 a.m',
    identidad: '41.099.384',
    estado: 'Activo',
    paciente: 'Salutri, Juana',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: '27.348.199',
    estado: 'Activo',
    paciente: 'Fuentes, Marcelo',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: '32.139.655',
    estado: 'Activo',
    paciente: 'Garcia, Lautaro',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: '19.554.239',
    estado: 'Activo',
    paciente: 'Martinez, Julieta',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: '22.478.458',
    estado: 'Cancelado',
    paciente: 'Hernández, Laura',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: '26.547.589',
    estado: 'Cancelado',
    paciente: 'Perez, Julian',
  },
  {
    fecha: 'Martes 22/11/22',
    hora: '12:15 p.m',
    identidad: '29.874.587',
    estado: 'Activo',
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
