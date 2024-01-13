import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParkListComponent } from './component/park-list/park-list.component';
import { NationalParkComponent } from './component/national-park/national-park.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { SuccessComponent } from './component/success/success.component';
import { ParkCheckedListComponent } from './component/park-checked-list/park-checked-list.component';
import { NotFoundComponent } from './component/not-found/not-found.component';
import { LoginGuardService } from './services/login-guard.service';

const routes: Routes = [
  {path: 'parks', component: ParkListComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'success', component: SuccessComponent},
  {path: 'national-park/:id', component: NationalParkComponent},
  {path: 'park-checked', component: ParkCheckedListComponent, canActivate: [LoginGuardService]},
  {path: 'not-found', component: NotFoundComponent},
  {path: '', redirectTo: 'parks', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
