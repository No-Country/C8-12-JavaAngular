import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { Pag404Component } from './pages/pag404/pag404.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomePatientComponent } from './pages/patient/home-patient/home-patient.component';
import { GenerateTurnComponent } from './pages/patient/generate-turn/generate-turn.component';
import { HomeAdminComponent } from './pages/home-admin/home-admin.component';
import { HomeMedicComponent } from './pages/home-medic/home-medic.component';
import { ApptPatientComponent } from './pages/patient/appt-patient/appt-patient.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home-patient', component: HomePatientComponent },
  {path: 'generate-turn', component: GenerateTurnComponent},
  {path: 'home-admin', component: HomeAdminComponent },
  {path: 'home-medic', component: HomeMedicComponent},
  {path: 'appt-patient', component: ApptPatientComponent },
  {path: '**', component: Pag404Component},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
