import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { AppRoutingModule } from './app-routing.module';
import { HomePatientComponent } from './pages/patient/home-patient/home-patient.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './modules/material/material.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientJsonpModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { Pag404Component } from './pages/pag404/pag404.component';
import { GenerateTurnComponent } from './pages/patient/generate-turn/generate-turn.component';
import { HomeAdminComponent } from './pages/home-admin/home-admin.component';
import { HomeMedicComponent } from './pages/home-medic/home-medic.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    HomePatientComponent,
    SidenavComponent,
    Pag404Component,
    GenerateTurnComponent,
    HomeAdminComponent,
    HomeMedicComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    NgbModule,
    HttpClientJsonpModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    HomePatientComponent,
    SidenavComponent
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]
})
export class AppModule { }
