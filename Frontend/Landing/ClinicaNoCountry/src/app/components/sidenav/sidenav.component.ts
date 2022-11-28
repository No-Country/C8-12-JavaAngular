import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  events: string[] = [];
  opened= false;

  shouldRun = /(^|.)(stackblitz|webcontainer).(io|com)$/.test(window.location.host);


  constructor() {  }

  ngOnInit(): void {
  }

}


