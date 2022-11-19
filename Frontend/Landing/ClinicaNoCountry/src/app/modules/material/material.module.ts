import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatMenuModule} from '@angular/material/menu';
import {MatCommonModule} from '@angular/material/core';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import { NavComponent } from './components/nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatListModule } from '@angular/material/list';



@NgModule({
  declarations: [NavComponent],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatMenuModule,
    MatCommonModule,
    MatButtonToggleModule,
    ReactiveFormsModule, FormsModule,
    MatSidenavModule,
    LayoutModule,
    MatListModule
  ], 
  exports: [
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatMenuModule,
    MatCommonModule,
    MatButtonToggleModule,
    ReactiveFormsModule, FormsModule,
    MatSidenavModule,
    NavComponent
  ]
})
export class MaterialModule { }
